package org.shock.weixin.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	public String getString(String key) {
		Object value = getObject(key);
		if(value==null)return null;
		if(value instanceof String) {
			return (String) value;
		}else {
			return String.valueOf(value);
		}
	}
	public Object getObject(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	public void setValue(String key,Object value) {
		redisTemplate.opsForValue().set(key, value);
	}
	public boolean delete(String key) {
		return redisTemplate.delete(key);
	}
}
