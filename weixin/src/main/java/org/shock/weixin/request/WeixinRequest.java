package org.shock.weixin.request;

import java.util.Map;

import org.shock.weixin.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Maps;

import lombok.Data;
import net.sf.json.JSONObject;

@Data
@Component
@ConfigurationProperties(prefix="wxrequest")
@SuppressWarnings("all")
public class WeixinRequest {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CommonConstant commonConstant;
	
	private String accessToken;
	/**获取access_token*/
	private String token;
	/**获取素材列表*/
	private String batchgetMaterial;
	public void initAccessToken() {
		Map<String, String> params = Maps.newHashMap();
		params.put("appid", commonConstant.getAppid());
		params.put("appsecret", commonConstant.getAppsecret());
		Map result = restTemplate.getForObject(token, Map.class,params);
		if(result.containsKey("errcode")) {
			System.err.println(result.get("errmsg"));
		}
		accessToken = (String)result.get("access_token");
	}
	/**
	 * @param type 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
	 * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	 * @param count 返回素材的数量，取值在1到20之间
	 * @return
	 */
	public String getAllMaterial(String type,int offset,int count) {
		Map<String, String> params = Maps.newHashMap();
		params.put("accessToken", accessToken);
		JSONObject data = new JSONObject();
		data.put("type", type);
		data.put("offset", offset);
		data.put("count", count);
		String result = restTemplate.postForObject(batchgetMaterial,data.toString(),String.class,params);
		return result;
	}
}
