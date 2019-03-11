package com.zdy.biz.redis.template;

import com.zdy.biz.redis.seriallzer.FastJson2JsonRedisSerializer;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 */
public abstract class JsonRedisTemplate<T> extends AbstractRedisTemplate<T> {


    public JsonRedisTemplate(RedisConnectionFactory connectionFactory, RedisSerializer<?> valueSerializer,
                             Boolean enableTransaction) {
        super(connectionFactory, valueSerializer, enableTransaction);
    }

    public JsonRedisTemplate(RedisConnectionFactory connectionFactory, Class<T> clazz) {
        super(connectionFactory, new FastJson2JsonRedisSerializer<>(clazz), Boolean.FALSE);
    }


    public JsonRedisTemplate(RedisConnectionFactory connectionFactory) {
        super(connectionFactory, new FastJson2JsonRedisSerializer<>(Object.class), Boolean.FALSE);
    }


    public JsonRedisTemplate(RedisConnectionFactory connectionFactory, RedisSerializer<?> valueSerializer) {
        super(connectionFactory, valueSerializer, Boolean.FALSE);
    }
}
