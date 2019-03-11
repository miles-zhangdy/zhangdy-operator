package com.zdy.biz.redis.config;


import lombok.Data;

@Data
public class RedisNode {

    private String host;

    private int port;

    private String password;

    private int database = 0;
}
