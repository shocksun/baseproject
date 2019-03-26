package org.shock.webrequest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebTestController {
	
	@RequestMapping("arrtest")
	@ResponseBody
	public String arrtest(String list) {
		System.out.println(list);
		return "";
	}
}
