package org.shock.weixin.request;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.shock.weixin.CommonConstant;
import org.shock.weixin.button.Button;
import org.shock.weixin.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private RedisUtils redisUtils;
	
	private String accessToken;
	private String ticket;
	public String getAccessToken() {
		return accessToken;
	}
	public String getTicket() {
		return ticket;
	}
	private String getRedisTimeValue(String key) {
		String value = redisUtils.getString(key);
		if(value!=null) {
			Date date = (Date) redisUtils.getObject(key+"_time");
			if(date!=null) {
				if(date.getTime()<new Date().getTime()) {
					redisUtils.delete(key);
				}else {
					return value;
				}
			}else {
				redisUtils.delete(key);
			}
		}
		return null;
	}
	private void setRedisTimeValue(String key,String value,int time) {
		redisUtils.setValue(key,value);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.SECOND,time);
		redisUtils.setValue(key+"_time",calendar.getTime());
	}
	public void initAccessToken() {
		accessToken = getRedisTimeValue("accessToken");
		if(StringUtils.isEmpty(accessToken)) {//判断accessToken是否存在,如果不存在就获取
			Map<String, String> params = Maps.newHashMap();
			params.put("appid", commonConstant.getAppid());
			params.put("appsecret", commonConstant.getAppsecret());
			Map result = restTemplate.getForObject(weixinApi.getAccessToken().getToken(), Map.class,params);
			if(result.containsKey("errcode")) {
				System.err.println(result.get("errmsg"));
			}else {
				accessToken = (String)result.get("access_token");
				int time = (int) result.get("expires_in");
				setRedisTimeValue("accessToken", accessToken, time);
			}
		}
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
		return JSONObject.fromObject(result);
	}
	public Map createMenu(Button button) {
		Map<String, String> params = Maps.newHashMap();
		params.put("accessToken", accessToken);
		String result = restTemplate.postForObject(weixinApi.getMenu().getCreate(),JSONObject.fromObject(button).toString(),String.class,params);
		return JSONObject.fromObject(result);
	}
	public void initJsapiTicket() {
		ticket = getRedisTimeValue("ticket");
		if(StringUtils.isEmpty(ticket)&&accessToken!=null) {
			Map<String, String> params = Maps.newHashMap();
			params.put("accessToken", accessToken);
			Map result = restTemplate.getForObject(weixinApi.getAccessToken().getJsapiTicket(),Map.class,params);
			if(result.get("errcode").equals(0)) {
				ticket = (String)result.get("ticket");
				int time = (int) result.get("expires_in");
				setRedisTimeValue("ticket", ticket, time);
			}else {
				System.err.println(result.get("errmsg"));
			}
		}
		
	}
}
