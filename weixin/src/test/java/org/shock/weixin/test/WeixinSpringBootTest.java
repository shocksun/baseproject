package org.shock.weixin.test;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shock.weixin.CommonConstant;
import org.shock.weixin.SpringBootApp;
import org.shock.weixin.button.Button;
import org.shock.weixin.button.SubButton;
import org.shock.weixin.button.other.ClickButton;
import org.shock.weixin.button.other.LocationSelectButton;
import org.shock.weixin.button.other.MediaIdButton;
import org.shock.weixin.button.other.MiniprogramButton;
import org.shock.weixin.button.other.PicPhotoOrAlbumButton;
import org.shock.weixin.button.other.PicSysphotoButton;
import org.shock.weixin.button.other.PicWeixinButton;
import org.shock.weixin.button.other.ScancodePushButton;
import org.shock.weixin.button.other.ScancodeWaitmsgButton;
import org.shock.weixin.button.other.ViewButton;
import org.shock.weixin.button.other.ViewLimitedButton;
import org.shock.weixin.request.WeixinRequest;
import org.shock.weixin.utils.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import net.sf.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootApp.class)
public class WeixinSpringBootTest {
	
	@Autowired
	private WeixinRequest weixinRequest;
	@Before
	public void getAccessToken() {
		weixinRequest.initAccessToken();
	}
	
	@Test
	public void testName() throws Exception {
		Button button = new Button();
		ViewButton viewButton = new ViewButton("测试缓存2", "http://shocksun.51vip.biz/weixin/weix/list.html");
		button.addButton(viewButton);
		System.out.println(JSONObject.fromObject(button));
		Map result = weixinRequest.createMenu(button);
		System.out.println(result);
	}
	@Test
	public void testrequest() {
		Map result = weixinRequest.getJsapiTicket();
		System.out.println(result);
	}
	
}
