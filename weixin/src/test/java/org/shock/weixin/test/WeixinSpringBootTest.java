package org.shock.weixin.test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shock.weixin.SpringBootApp;
import org.shock.weixin.button.Button;
import org.shock.weixin.button.other.ViewButton;
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
	@Before
	public void getAccessToken() {
		weixinRequest.initAccessToken();
		System.out.println(weixinRequest.getAccessToken());
	}
	
//	@Test
//	public void createMenu() throws Exception {
//		Button button = new Button();
//		ViewButton viewButton = new ViewButton("测试缓存2", "http://shocksun.51vip.biz/weixin/weix/list.html");
//		button.addButton(viewButton);
//		System.out.println(JSONObject.fromObject(button));
//		Map result = weixinRequest.createMenu(button);
//		System.out.println(result);
//	}
	@Test
	public void testrequest() {
		weixinRequest.initJsapiTicket();
		System.out.println(weixinRequest.getTicket());
	}
	
}
