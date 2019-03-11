package com.zdy.biz.redis.template;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 */
public abstract class JdkRedisTemplate<T> extends AbstractRedisTemplate<T> {

    public JdkRedisTemplate(RedisConnectionFactory connectionFactory, RedisSerializer<?> valueSerializer,
                            Boolean enableTransaction) {
        super(connectionFactory, valueSerializer, enableTransaction);
    }

    public JdkRedisTemplate(RedisConnectionFactory connectionFactory) {
        super(connectionFactory, new JdkSerializationRedisSerializer(), Boolean.FALSE);
    }

    public T get(String key, Callable<? extends T> loader) throws Exception {
        T data = super.getValueByKey(key);
        return data == null ? loader.call() : data;
    }


    public List<T> getList(String key, Callable<List<T>> loader) throws Exception {
        List<T> data = super.getListByKey(key);
        return data == null ? loader.call() : data;
    }

    public void putList(String key, List<T> datas, long timeout, TimeUnit unit) {
        BoundListOperations<String, T> boundValueOperations = super.boundListOps(key);
        for (T t : datas) {
            boundValueOperations.rightPush(t);
        }
        boundValueOperations.expire(timeout, unit);
    }

    public void clean(String key) {
        super.delete(key);
    }
}
