package com.zdy.biz.redis.config;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.util.StringUtils;

@Slf4j
public abstract class AbsRedisConfiguration {

    protected RedisConnectionFactory createNodeConnectionFactory(RedisProperties redisProperties, RedisNode redisNode) {
        GenericObjectPoolConfig poolConfig = createPoolConfig(redisProperties);
        LettuceConnectionFactory factory = buildLettuceConnectionFactory(poolConfig, redisNode);
        return factory;
    }

    private LettuceConnectionFactory buildLettuceConnectionFactory(GenericObjectPoolConfig poolConfig, RedisNode redisNode) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setDatabase(redisNode.getDatabase());
        redisStandaloneConfiguration.setHostName(redisNode.getHost());
        redisStandaloneConfiguration.setPort(redisNode.getPort());

        if (!StringUtils.isEmpty(redisNode.getPassword())) {
            redisStandaloneConfiguration.setPassword(RedisPassword.of(redisNode.getPassword()));
        }

        LettucePoolingClientConfiguration poolingClientConfiguration = LettucePoolingClientConfiguration.builder().poolConfig(poolConfig).build();
        return new LettuceConnectionFactory(redisStandaloneConfiguration, poolingClientConfiguration);
    }


    protected GenericObjectPoolConfig createPoolConfig(RedisProperties redisProperties) {
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxIdle(redisProperties.getLettuce().getPool().getMaxIdle());
        genericObjectPoolConfig.setMinIdle(redisProperties.getLettuce().getPool().getMinIdle());
        genericObjectPoolConfig.setMaxTotal(redisProperties.getLettuce().getPool().getMaxActive());
        genericObjectPoolConfig.setMaxWaitMillis(redisProperties.getLettuce().getPool().getMaxWait().toMillis());
        return genericObjectPoolConfig;
    }

}
