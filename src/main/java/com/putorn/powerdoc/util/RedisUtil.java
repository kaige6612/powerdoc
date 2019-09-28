package com.putorn.powerdoc.util;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;
/**
 * redicache 工具类
 *
 */
@SuppressWarnings("unchecked")
@Component
public class RedisUtil {
	public static List<String> haveInitKeys = new ArrayList<>();
	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	/**
	 * 批量删除对应的value
	 *
	 * @param keys
	 */
	public void remove(final String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}
	/**
	 * 批量删除key
	 *
	 * @param pattern
	 */
	public void removePattern(final String pattern) {
		Set<Serializable> keys = redisTemplate.keys(pattern);
		if (keys.size() > 0)
			redisTemplate.delete(keys);
	}
	/**
	 * 删除对应的value
	 *
	 * @param key
	 */
	public void remove(final String key) {
		if (exists(key)) {
			redisTemplate.delete(key);
		}
	}
	/**
	 * 判断缓存中是否有对应的key
	 *
	 * @param key
	 * @return
	 */
	public boolean exists(String key) {
		return redisTemplate.hasKey(key);
	}
	/**
	 * 读取缓存
	 *
	 * @param key
	 * @return
	 */
	public String get(final String key) {
		Object result = null;
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		result = operations.get(key);
		if(result==null){
			return null;
		}
		return result.toString();
	}
	/**
	 * 写入缓存
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(final String key, Object value) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, String.valueOf(value));
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 写入缓存
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(final String key, Object value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public  boolean hmset(String key, Map<String, String> value) {
		boolean result = false;
		try {
			redisTemplate.opsForHash().putAll(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public  Map<String,String> hmget(String key) {
		Map<String,String> result =null;
		try {
			result=  redisTemplate.opsForHash().entries(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 递增
	 * @param key
	 * @param step
	 * @return
	 */
	public long incr(String key,Long step) {
		return redisTemplate.opsForValue().increment(key,step);
	}

	/**
	 * 递增(key是字符串类型)
	 * @param key 键
	 * @param step 每次递增数
	 * @return
	 */
	public long incrStringKey(String key,Long step) {
		return stringRedisTemplate.opsForValue().increment(key,step);
	}

	public boolean setStringKey(String key ,String value,Long expireTime) {
		try {
			stringRedisTemplate.opsForValue().set(key,value,expireTime);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 获取值(key为String 类型)
	 * @param key
	 * @return
	 */
	public String getValueStringKey(String key) {
		return  stringRedisTemplate.opsForValue().get(key);
	}

	/**
	 * @Title: 初始化long类型的值
	 * @Description: set cache.
	 * @param key
	 * @param value
	 * @param expireTime
	 */
	public void initValue(String key,Long value,Date expireTime) {
//		redisTemplate.setKeySerializer(new StringRedisSerializer());
		RedisAtomicLong counter = new RedisAtomicLong(key, stringRedisTemplate.getConnectionFactory());
		counter.set(value);
		counter.expireAt(expireTime);
	}


	/**
	 * @Title: generate
	 * @Description: Atomically increments by one the current value.
	 * @param key
	 * @return
	 */
	public long generate(String key) {
		RedisAtomicLong counter = new RedisAtomicLong(key, stringRedisTemplate.getConnectionFactory());
		return counter.incrementAndGet();
	}

	/**
	 * @Title: getLong 获取当前的值--仅限long类型
	 * @Description: get the current long value.
	 * @param key
	 * @return result 0:do not have this key   others:have this key  and its value = result
	 */
	public long getLong(String key) {
		RedisAtomicLong counter = new RedisAtomicLong(key, stringRedisTemplate.getConnectionFactory());
		return counter.get();
	}
}