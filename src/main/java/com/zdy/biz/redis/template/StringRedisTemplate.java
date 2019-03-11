package com.zdy.biz.redis.template;

import com.zdy.biz.redis.seriallzer.FastJson2JsonRedisSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisServerCommands;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.Charset;
import java.util.*;

/**
 * Redis Repository
 *
 * @author zhangdb
 */
public abstract class StringRedisTemplate<T> extends AbstractRedisTemplate<String> {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StringRedisTemplate.class);
    /**
     * 默认编码
     */
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public StringRedisTemplate(RedisConnectionFactory connectionFactory, RedisSerializer<?> valueSerializer,
                               Boolean enableTransaction) {
        super(connectionFactory, valueSerializer, enableTransaction);
    }

    public StringRedisTemplate(RedisConnectionFactory connectionFactory) {
        super(connectionFactory, new StringRedisSerializer(), Boolean.FALSE);
    }


    public StringRedisTemplate(RedisConnectionFactory connectionFactory, Class<T> clazz) {
        super(connectionFactory, new FastJson2JsonRedisSerializer<>(clazz), Boolean.FALSE);
    }

    /**
     * 添加到带有 过期时间的  缓存
     *
     * @param key   redis主键
     * @param value 值
     * @param time  过期时间
     */
    public void setExpire(final byte[] key, final byte[] value, final long time) {
        this.execute((RedisCallback<Long>) connection -> {
            connection.set(key, value);
            connection.expire(key, time);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("[redisTemplate redis]放入 缓存  url:{} ========缓存时间为{}秒", key, time);
            }
            return 1L;
        });
    }

    /**
     * 添加到带有 过期时间的  缓存
     *
     * @param key   redis主键
     * @param value 值
     * @param time  过期时间
     */
    public void setExpire(final String key, final String value, final long time) {
        this.execute((RedisCallback<Long>) connection -> {
            RedisSerializer<String> serializer = getRedisSerializer();
            byte[] keys = serializer.serialize(key);
            byte[] values = serializer.serialize(value);
            connection.set(keys, values);
            connection.expire(keys, time);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("[redisTemplate redis]放入 缓存  url:{} ========缓存时间为{}秒", key, time);
            }
            return 1L;
        });
    }

    /**
     * 一次性添加数组到   过期时间的  缓存，不用多次连接，节省开销
     *
     * @param keys   redis主键数组
     * @param values 值数组
     * @param time   过期时间
     */
    public void setExpire(final String[] keys, final String[] values, final long time) {
        this.execute((RedisCallback<Long>) connection -> {
            RedisSerializer<String> serializer = getRedisSerializer();
            for (int i = 0; i < keys.length; i++) {
                byte[] bKeys = serializer.serialize(keys[i]);
                byte[] bValues = serializer.serialize(values[i]);
                connection.set(bKeys, bValues);
                connection.expire(bKeys, time);
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("[redisTemplate redis]放入 缓存  url:{} ========缓存时间为:{}秒", keys[i], time);
                }
            }
            return 1L;
        });
    }


    /**
     * 一次性添加数组到   过期时间的  缓存，不用多次连接，节省开销
     *
     * @param keys   the keys
     * @param values the values
     */
    public void set(final String[] keys, final String[] values) {
        this.execute((RedisCallback<Long>) connection -> {
            RedisSerializer<String> serializer = getRedisSerializer();
            for (int i = 0; i < keys.length; i++) {
                byte[] bKeys = serializer.serialize(keys[i]);
                byte[] bValues = serializer.serialize(values[i]);
                connection.set(bKeys, bValues);
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("[redisTemplate redis]放入 缓存  url:{}", keys[i]);
                }
            }
            return 1L;
        });
    }


    /**
     * 添加到缓存
     *
     * @param key   the key
     * @param value the value
     */
    public void set(final String key, final String value) {
        this.execute((RedisCallback<Long>) connection -> {
            RedisSerializer<String> serializer = getRedisSerializer();
            byte[] keys = serializer.serialize(key);
            byte[] values = serializer.serialize(value);
            connection.set(keys, values);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("[redisTemplate redis]放入 缓存  url:{}", key);
            }
            return 1L;
        });
    }

    /**
     * 查询在这个时间段内即将过期的key
     *
     * @param key  the key
     * @param time the time
     * @return the list
     */
    public List<String> willExpire(final String key, final long time) {
        final List<String> keysList = new ArrayList<>();
        this.execute((RedisCallback<List<String>>) connection -> {
            Set<String> keys = this.keys(key + "*");
            for (String key1 : keys) {
                Long ttl = connection.ttl(key1.getBytes(DEFAULT_CHARSET));
                if (0 <= ttl && ttl <= 2 * time) {
                    keysList.add(key1);
                }
            }
            return keysList;
        });
        return keysList;
    }


    /**
     * 根据key获取对象
     *
     * @param key the key
     * @return the byte [ ]
     */
    public byte[] get(final byte[] key) {
        byte[] result = this.execute((RedisCallback<byte[]>) connection -> connection.get(key));
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[redisTemplate redis]取出 缓存  url:{} ", key);
        }
        return result;
    }

    /**
     * 根据key获取对象
     *
     * @param key the key
     * @return the string
     */
    public String get(final String key) {
        String resultStr = this.execute((RedisCallback<String>) connection -> {
            RedisSerializer<String> serializer = getRedisSerializer();
            byte[] keys = serializer.serialize(key);
            byte[] values = connection.get(keys);
            return serializer.deserialize(values);
        });
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[redisTemplate redis]取出 缓存  url:{} ", key);
        }
        return resultStr;
    }


    /**
     * 根据key获取对象
     *
     * @param keyPatten the key patten
     * @return the keys values
     */
    public Map<String, String> getKeysValues(final String keyPatten) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[redisTemplate redis]  getValues()  patten={} ", keyPatten);
        }
        return this.execute((RedisCallback<Map<String, String>>) connection -> {
            RedisSerializer<String> serializer = getRedisSerializer();
            Map<String, String> maps = new HashMap<>();
            Set<String> keys = this.keys(keyPatten + "*");
            for (String key : keys) {
                byte[] bKeys = serializer.serialize(key);
                byte[] bValues = connection.get(bKeys);
                String value = serializer.deserialize(bValues);
                maps.put(key, value);
            }
            return maps;
        });
    }

    /**
     * Ops for hash hash operations.
     *
     * @return the hash operations
     */
    @SuppressWarnings("unchecked")
    @Override
    public HashOperations<String, String, String> opsForHash() {
        return super.opsForHash();
    }

    /**
     * 对HashMap操作
     *
     * @param key       the key
     * @param hashKey   the hash key
     * @param hashValue the hash value
     */
    public void putHashValue(String key, String hashKey, String hashValue) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[redisTemplate redis]  putHashValue()  key={},hashKey={},hashValue={} ", key, hashKey, hashValue);
        }
        opsForHash().put(key, hashKey, hashValue);
    }

    /**
     * 获取单个field对应的值
     *
     * @param key     the key
     * @param hashKey the hash key
     * @return the hash values
     */
    public Object getHashValues(String key, String hashKey) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[redisTemplate redis]  getHashValues()  key={},hashKey={}", key, hashKey);
        }
        return opsForHash().get(key, hashKey);
    }

    /**
     * 根据key值删除
     *
     * @param key      the key
     * @param hashKeys the hash keys
     */
    public void delHashValues(String key, Object... hashKeys) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[redisTemplate redis]  delHashValues()  key={}", key);
        }
        opsForHash().delete(key, hashKeys);
    }

    /**
     * key只匹配map
     *
     * @param key the key
     * @return the hash value
     */
    public Map<String, String> getHashValue(String key) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[redisTemplate redis]  getHashValue()  key={}", key);
        }
        return opsForHash().entries(key);
    }

    /**
     * 批量添加
     *
     * @param key the key
     * @param map the map
     */
    public void putHashValues(String key, Map<String, String> map) {
        opsForHash().putAll(key, map);
    }

    /**
     * 集合数量
     *
     * @return the long
     */
    public long dbSize() {
        return this.execute(RedisServerCommands::dbSize);
    }

    /**
     * 清空redis存储的数据
     *
     * @return the string
     */
    public String flushDB() {
        return this.execute((RedisCallback<String>) connection -> {
            connection.flushDb();
            return "ok";
        });
    }

    /**
     * 判断某个主键是否存在
     *
     * @param key the key
     * @return the boolean
     */
    public boolean exists(final String key) {
        return this.execute((RedisCallback<Boolean>) connection -> connection.exists(key.getBytes(DEFAULT_CHARSET)));
    }


    /**
     * 删除key
     *
     * @param keys the keys
     * @return the long
     */
    public long del(final String... keys) {
        return this.execute((RedisCallback<Long>) connection -> {
            long result = 0;
            for (String key : keys) {
                result = connection.del(key.getBytes(DEFAULT_CHARSET));
            }
            return result;
        });
    }

    /**
     * 获取 RedisSerializer
     *
     * @return the redis serializer
     */
    protected RedisSerializer<String> getRedisSerializer() {
        return this.getStringSerializer();
    }

    /**
     * 对某个主键对应的值加一,value值必须是全数字的字符串
     *
     * @param key the key
     * @return the long
     */
    public long incr(final String key) {
        return this.execute((RedisCallback<Long>) connection -> {
            RedisSerializer<String> redisSerializer = getRedisSerializer();
            return connection.incr(redisSerializer.serialize(key));
        });
    }

    /**
     * redis List数据结构 : 将一个或多个值 value 插入到列表 key 的表头
     *
     * @param key   the key
     * @param value the value
     * @return the long
     */
    public Long leftPush(String key, String value) {
        return opsForList().leftPush(key, value);
    }

    /**
     * redis List数据结构 : 移除并返回列表 key 的头元素
     *
     * @param key the key
     * @return the string
     */
    public String leftPop(String key) {
        return opsForList().leftPop(key);
    }

    /**
     * redis List数据结构 :将一个或多个值 value 插入到列表 key 的表尾(最右边)。
     *
     * @param key   the key
     * @param value the value
     * @return the long
     */
    public Long in(String key, String value) {
        return opsForList().rightPush(key, value);
    }

    /**
     * redis List数据结构 : 移除并返回列表 key 的末尾元素
     *
     * @param key the key
     * @return the string
     */
    public String rightPop(String key) {
        return opsForList().rightPop(key);
    }


    /**
     * redis List数据结构 : 返回列表 key 的长度 ; 如果 key 不存在，则 key 被解释为一个空列表，返回 0 ; 如果 key 不是列表类型，返回一个错误。
     *
     * @param key the key
     * @return the long
     */
    public Long length(String key) {
        return opsForList().size(key);
    }


    /**
     * redis List数据结构 : 根据参数 i 的值，移除列表中与参数 value 相等的元素
     *
     * @param key   the key
     * @param i     the
     * @param value the value
     */
    public void remove(String key, long i, String value) {
        opsForList().remove(key, i, value);
    }

    /**
     * redis List数据结构 : 将列表 key 下标为 index 的元素的值设置为 value
     *
     * @param key   the key
     * @param index the index
     * @param value the value
     */
    public void set(String key, long index, String value) {
        opsForList().set(key, index, value);
    }

    /**
     * redis List数据结构 : 返回列表 key 中指定区间内的元素，区间以偏移量 start 和 end 指定。
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return the list
     */
    public List<String> getList(String key, int start, int end) {
        return opsForList().range(key, start, end);
    }

    /**
     * redis List数据结构 : 批量存储
     *
     * @param key  the key
     * @param list the list
     * @return the long
     */
    public Long leftPushAll(String key, List<String> list) {
        return opsForList().leftPushAll(key, list);
    }

    /**
     * redis List数据结构 : 将值 value 插入到列表 key 当中，位于值 index 之前或之后,默认之后。
     *
     * @param key   the key
     * @param index the index
     * @param value the value
     */
    public void insert(String key, long index, String value) {
        opsForList().set(key, index, value);
    }
}
