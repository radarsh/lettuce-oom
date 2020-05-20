package com.adarshr.lettuce.oom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RedisService {

    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    private final StringRedisTemplate redisTemplate;

    public RedisService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Transactional
    public void ping() {
        logger.info("Pinging Redis");

        redisTemplate.boundValueOps("timestamp-1").set(String.valueOf(System.currentTimeMillis()));
        redisTemplate.boundValueOps("timestamp-2").set(String.valueOf(System.currentTimeMillis()));
        redisTemplate.boundValueOps("timestamp-3").set(String.valueOf(System.currentTimeMillis()));
        redisTemplate.boundValueOps("timestamp-4").set(String.valueOf(System.currentTimeMillis()));
    }
}
