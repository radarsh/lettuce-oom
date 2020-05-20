package com.adarshr.lettuce.oom;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/ping")
    public ResponseEntity<Void> pingRedis() {
        redisService.ping();

        return ResponseEntity.noContent().build();
    }
}
