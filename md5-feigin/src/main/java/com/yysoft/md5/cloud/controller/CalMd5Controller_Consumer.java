package com.yysoft.md5.cloud.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yysoft.md5.cloud.entities.CrackMd5Ten;
import com.yysoft.md5.cloud.service.CrackMd5Ten0FeiginService;
import com.yysoft.md5.cloud.service.CrackMd5Ten1FeiginService;
import com.yysoft.md5.cloud.service.CrackMd5Ten2FeiginService;
import com.yysoft.md5.cloud.service.CrackMd5Ten3FeiginService;
import com.yysoft.md5.cloud.utils.CStringUtils;

@RestController
@ResponseBody
public class CalMd5Controller_Consumer {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private CrackMd5Ten0FeiginService service0;

	@Autowired
	private CrackMd5Ten1FeiginService service1;

	@Autowired
	private CrackMd5Ten2FeiginService service2;

	@Autowired
	private CrackMd5Ten3FeiginService service3;

	@RequestMapping(value = "/md5/list")
	public List<CrackMd5Ten> list() {
		System.out.println("/md5/list" + new Date());
		return this.service1.list();
	}

	@RequestMapping("/md5/get1/{md5_str}")
	public CrackMd5Ten getMd5Str1(@PathVariable("md5_str") String md5_str) {
		if (null != md5_str && md5_str.trim().length() > 0) {
			String prefixStr = md5_str.substring(0, 1);
			if (!CStringUtils.isNumber(prefixStr)) {
				return null;
			}
			if (Integer.parseInt(prefixStr) < 4) {
				switch (Integer.parseInt(prefixStr)) {
				case 0:
					return this.service0.get(md5_str);
					
				case 1:
					return this.service1.get(md5_str);
					
				case 2:
					return this.service2.get(md5_str);
					
				case 3:
					return this.service3.get(md5_str);

				default:
					break;
				}
			}

		} else {
			return null;
		}
		return null;
	}

	@RequestMapping("/md5/get2/{md5_str}")
	public CrackMd5Ten getMd5Str2(@PathVariable("md5_str") String md5_str) {
		String[] microServiceList = { "MICROSERVICECLOUD-MD5-ZERO", "MICROSERVICECLOUD-MD5-ONE",
				"MICROSERVICECLOUD-MD5-TWO", "MICROSERVICECLOUD-MD5-THREE" };
		if (null != md5_str && md5_str.trim().length() > 0) {
			String prefixStr = md5_str.substring(0, 1);
			if (!CStringUtils.isNumber(prefixStr)) {
				return null;
			}
			String serverUrl = "http://" + microServiceList[Integer.parseInt(prefixStr)] + "/md5/get/" + md5_str;
			System.out.println(new Date() + "\t serverUrl:\t" + serverUrl);
			if (Integer.parseInt(prefixStr) < 4) {
				return restTemplate.getForObject(serverUrl, CrackMd5Ten.class);
			}

		} else {
			return null;
		}
		return null;
	}

}








