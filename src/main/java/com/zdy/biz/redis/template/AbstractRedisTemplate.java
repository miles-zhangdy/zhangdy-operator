package com.zdy.biz.redis.template;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
public  abstract class AbstractRedisTemplate<T> extends RedisTemplate<String, T> {

    private static final StringRedisSerializer keySerializer = new StringRedisSerializer();

    public AbstractRedisTemplate(@NonNull RedisConnectionFactory redisConnectionFactory, @NonNull RedisSerializer<?> valueSerializer, @NonNull Boolean enableTransaction) {
        setConnectionFactory(redisConnectionFactory);

        setKeySerializer(keySerializer);
        setHashKeySerializer(keySerializer);

        setValueSerializer(valueSerializer);
        setHashValueSerializer(valueSerializer);

        afterPropertiesSet();
        setEnableTransactionSupport(enableTransaction);
    }
    public T firstSort(String key) {
        if (this.hasKey(key)) {
            Set<T> range = this.boundZSetOps(key).range(0, 0);
            if (range != null && !range.isEmpty()) {
                return range.iterator().next();
            }
        }
        return null;
    }

    /**
     * 获取尾部第一个订单
     *
     * @param key
     * @return
     */
    public T lastSort(String key) {
        if (this.hasKey(key)) {
            Set<T> range = this.boundZSetOps(key).range(-1, -1);
            if (range != null && !range.isEmpty()) {
                return range.iterator().next();
            }
        }
        return null;
    }

    public T getValueByKey(String key) {
        try {
            if (this.hasKey(key)) {
                BoundValueOperations<String, T> boundValueOperations = super.boundValueOps(key);
                return boundValueOperations.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<T> getSetByKey(String key) {
        try {
            if (this.hasKey(key)) {
                BoundSetOperations<String, T> boundValueOperations = super.boundSetOps(key);
                return boundValueOperations.members();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<T> getListByKey(String key) {
        try {
            if (this.hasKey(key)) {
                BoundListOperations<String, T> boundValueOperations = super.boundListOps(key);
                return boundValueOperations.range(0, boundValueOperations.size() - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void putValueByKey(String key, T value) {
        BoundValueOperations<String, T> boundValueOperations = super.boundValueOps(key);
        boundValueOperations.set(value);
    }

    public void putValueByKeyInvalidTime(String key, T value, long timeout, TimeUnit unit) {
        BoundValueOperations<String, T> boundValueOperations = super.boundValueOps(key);
        boundValueOperations.set(value, timeout, unit);
    }

    public void addSetByKey(String key, T value) {
        BoundSetOperations<String, T> boundValueOperations = super.boundSetOps(key);
        boundValueOperations.add(value);
    }


    public void rightPush(String key, T value) {
        BoundListOperations<String, T> boundValueOperations = super.boundListOps(key);
        boundValueOperations.rightPush(value);
    }

}
