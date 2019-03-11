package com.zdy.biz.redis.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.util.StringUtils;

@Slf4j
@Configuration
@EnableConfigurationProperties(RedisExtProperties.class)
public class RedisExtAutoConfiguration extends AbsRedisConfiguration {


    @Autowired
    private RedisExtProperties redisExtProperties;

    @Autowired
    private RedisProperties redisProperties;


    @Bean("redisConnectionFactory")
    @ConditionalOnMissingBean(name = "redisConnectionFactory")
    RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setDatabase(redisProperties.getDatabase());
        redisStandaloneConfiguration.setHostName(redisProperties.getHost());
        redisStandaloneConfiguration.setPort(redisProperties.getPort());

        if (!StringUtils.isEmpty(redisProperties.getPassword())) {
            redisStandaloneConfiguration.setPassword(RedisPassword.of(redisProperties.getPassword()));
        }

        LettucePoolingClientConfiguration poolingClientConfiguration = LettucePoolingClientConfiguration.builder().poolConfig(createPoolConfig(redisProperties)).build();
        LettuceConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration, poolingClientConfiguration);
        return factory;
    }


    @Bean("redisConnectionFactory1")
    @ConditionalOnMissingBean(name = "redisConnectionFactory1")
    RedisConnectionFactory redisConnectionFactory1() {
        if (redisExtProperties.getNodes().isEmpty()) {
            throw new RuntimeException("redis node[0] 没有配置");
        }

        RedisNode redisNode = redisExtProperties.getNodes().get(0);
        return createNodeConnectionFactory(redisProperties, redisNode);
    }
}
