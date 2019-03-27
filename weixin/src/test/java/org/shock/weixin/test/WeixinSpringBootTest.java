package org.shock.weixin.test;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shock.weixin.CommonConstant;
import org.shock.weixin.SpringBootApp;
import org.shock.weixin.button.Button;
import org.shock.weixin.button.other.ClickButton;
import org.shock.weixin.button.other.ViewButton;
import org.shock.weixin.request.WeixinApi;
import org.shock.weixin.request.WeixinRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import net.sf.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootApp.class)
public class WeixinSpringBootTest {
	
	@Autowired
	private WeixinRequest weixinRequest;
	@Autowired
	private WeixinApi weixinApi;
	@Autowired
	private CommonConstant commonConstant;
	@Before
	public void getAccessToken() {
		weixinRequest.initAccessToken();
		System.out.println(weixinRequest.getAccessToken());
	}
	
	private String createAuthorize(String authorize) {
		try {
			return authorize.replace("{appid}", commonConstant.getAppid())
							.replace("{redirectUri}", URLEncoder.encode("http://shocksun.51vip.biz/web/sendRedirectUri","UTF-8"))
							.replace("{scope}", "snsapi_base")//snsapi_base snsapi_userinfo
							.replace("{state}", "");
		} catch (Exception e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void createMenu() throws Exception {
		Button button = new Button();
		ViewButton viewButton = new ViewButton("打开网页", createAuthorize(weixinApi.getOauth2().getAuthorize()));
		button.addButton(viewButton);
		System.out.println(JSONObject.fromObject(button));
		Map result = weixinRequest.createMenu(button);
		System.out.println(result);
	}
//	@Test
//	public void testrequest() {
//		weixinRequest.initJsapiTicket();
//		System.out.println(weixinRequest.getTicket());
//	}
//	@Test
//	public void testMaterial() {
//		Map allMaterial = weixinRequest.getAllMaterial("image", 0, 20);
//		System.out.println(allMaterial);
//	}
	
}
