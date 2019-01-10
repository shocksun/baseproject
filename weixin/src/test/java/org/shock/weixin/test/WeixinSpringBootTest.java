package org.shock.weixin.test;

import static org.junit.Assert.assertNull;

import java.util.Map;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

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
		SubButton subButton1 = new SubButton("点击类");
		subButton1.addSubButton(new ClickButton("点击", "click_btn"));
		subButton1.addSubButton(new LocationSelectButton("发送地址", "location_select_btn"));
		subButton1.addSubButton(new MediaIdButton("发送图片", "gQGZX1bJycwu4xDW-lWYJ3CzhJS8nbP-DRvz32PGIJA"));
		subButton1.addSubButton(new ViewLimitedButton("图文消息", "gQGZX1bJycwu4xDW-lWYJ-Z8fmf2DvDgL7-d2ebd7yk"));
		SubButton subButton2 = new SubButton("功能类");
		subButton2.addSubButton(new ScancodePushButton("扫码推事件", "scancode_push_btn"));
		subButton2.addSubButton(new ScancodeWaitmsgButton("扫码带提示", "scancode_waitmsg_btn"));
		subButton2.addSubButton(new PicPhotoOrAlbumButton("拍照或者相册发图", "pic_photo_or_album_btn"));
		subButton2.addSubButton(new PicSysphotoButton("系统拍照发图", "pic_sysphoto_btn"));
		subButton2.addSubButton(new PicWeixinButton("微信相册发图", "pic_weixin_btn"));
		SubButton subButton3 = new SubButton("跳转类");
		subButton3.addSubButton(new ViewButton("打开百度", "http://www.baidu.com"));
		subButton3.addSubButton(new MiniprogramButton("打开小程序", "http://mp.weixin.qq.com", "wx286b93c14bbf93aa", "pages/lunar/index"));
		button.addButton(subButton1);
		button.addButton(subButton2);
		button.addButton(subButton3);
	}
	@Test
	public void getAllMaterial() {
		Object allMaterial = weixinRequest.getAllMaterial("news",0,20);
		System.out.println(allMaterial);
	}
}
