package org.shock.weixin.bean;

import java.nio.charset.Charset;
import java.util.List;

import org.shock.weixin.utils.RedisObjectSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigurationBean {
	@Bean
	public RestTemplate geRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
		for (HttpMessageConverter<?> httpMessageConverter : messageConverters) {
			if(httpMessageConverter instanceof StringHttpMessageConverter) {
				((StringHttpMessageConverter)httpMessageConverter).setDefaultCharset(Charset.forName("UTF-8"));
			}
		}
		return restTemplate;
	}
	@Bean
	public RedisTemplate<String, Object> getRedisTemplate(RedisConnectionFactory factory){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new RedisObjectSerializer());
		return redisTemplate;
	}
}
