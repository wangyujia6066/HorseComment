package com.horseComment.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Collections;

public class RedisLimit {

    public RedisLimit(StringRedisTemplate stringRedisTemplate){
        this.stringRedisTemplate = stringRedisTemplate;
    }
    private static final int FAIl_CODE = 0;
    //间隔1秒进行限流
    private static final int duration = 1000;
    private StringRedisTemplate stringRedisTemplate;
    private static final DefaultRedisScript<Long> LIMIT_SCRIPT;
    static {
        LIMIT_SCRIPT = new DefaultRedisScript<>();
        LIMIT_SCRIPT.setLocation(new ClassPathResource("limit.lua"));
        LIMIT_SCRIPT.setResultType(Long.class);
    }
    public Boolean limit(int limitNum){
        String key = String.valueOf(System.currentTimeMillis()/duration);
        Long result = stringRedisTemplate
                .execute(LIMIT_SCRIPT, Collections.singletonList(key), String.valueOf(limitNum));
        return FAIl_CODE != result.intValue();
    }
    public Boolean limit(int limitNum, int duration){
        String key = String.valueOf(System.currentTimeMillis()/duration);
        Long result = stringRedisTemplate
                .execute(LIMIT_SCRIPT, Collections.singletonList(key), limitNum);
        return FAIl_CODE != result.intValue();
    }
}
