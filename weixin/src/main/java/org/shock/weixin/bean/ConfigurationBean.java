package org.shock.weixin.bean;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
}
