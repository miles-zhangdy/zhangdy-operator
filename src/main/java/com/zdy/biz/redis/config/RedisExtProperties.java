package com.zdy.biz.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;


@ConfigurationProperties(prefix = "spring.redis.ext")
public class RedisExtProperties {
    private List<RedisNode> nodes = new ArrayList<>();


    public List<RedisNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<RedisNode> nodes) {
        this.nodes = nodes;
    }
}
