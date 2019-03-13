package org.shock.weixin.request;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.shock.weixin.CommonConstant;
import org.shock.weixin.button.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Maps;

import net.sf.json.JSONObject;

@Component
public class WeixinRequest {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CommonConstant commonConstant;
	@Autowired
	private WeixinApi weixinApi;
	
	@Value(value="${accessToken}")
	private String accessToken;
	@Value(value="${ticket}")
	private String ticket;
	public String getAccessToken() {
		return accessToken;
	}
	public String getTicket() {
		return ticket;
	}
	public void initAccessToken() {
		if(StringUtils.isEmpty(accessToken)) {
			Map<String, String> params = Maps.newHashMap();
			params.put("appid", commonConstant.getAppid());
			params.put("appsecret", commonConstant.getAppsecret());
			Map<String,Object> result = restTemplate.getForObject(weixinApi.getAccessToken().getToken(), Map.class,params);
			if(result.containsKey("errcode")) {
				System.err.println(result.get("errmsg"));
			}
			accessToken = (String)result.get("access_token");
		}
		System.out.println(accessToken);
	}
	/**
	 * @param type 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
	 * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	 * @param count 返回素材的数量，取值在1到20之间
	 * @return
	 */
	public Map getAllMaterial(String type,int offset,int count) {
		Map<String, String> params = Maps.newHashMap();
		params.put("accessToken", accessToken);
		JSONObject data = new JSONObject();
		data.put("type", type);
		data.put("offset", offset);
		data.put("count", count);
		String result = restTemplate.postForObject(weixinApi.getMaterial().getBatchgetMaterial(),data.toString(),String.class,params);
		JSONObject json = JSONObject.fromObject(result);
		return json;
	}
	public Map createMenu(Button button) {
		Map<String, String> params = Maps.newHashMap();
		params.put("accessToken", accessToken);
		String result = restTemplate.postForObject(weixinApi.getMenu().getCreate(),JSONObject.fromObject(button).toString(),String.class,params);
		JSONObject json = JSONObject.fromObject(result);
		return json;
	}
	public Map getJsapiTicket() {
		Map<String, String> params = Maps.newHashMap();
		params.put("accessToken", accessToken);
		String result = restTemplate.getForObject(weixinApi.getAccessToken().getJsapiTicket(),String.class,params);
		JSONObject json = JSONObject.fromObject(result);
		return json;
	}
}
