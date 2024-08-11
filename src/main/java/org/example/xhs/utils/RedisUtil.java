package org.example.xhs.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public RedisUtil(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 设置Redis中存放的key-value
     * @param key 键
     * @param value 值
     */
    public void set(String key, Object value) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value);
    }

    /**
     * 带有过期时间的key-value
     * @param key 键
     * @param value 值
     * @param timeout 时长
     * @param unit 时间单位 hour, minute,second
     */
    public void setWithExpiration(String key, Object value, long timeout, TimeUnit unit) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value, timeout, unit);
    }

    /**
     * 从redis中根据key获取对应的value
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    /**
     * 判断redis中是否有未过期的key
     * @param key 键
     * @return true or false
     */
    public boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    /**
     * 根据key删除redis中对应的数据
     * @param key 键
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
