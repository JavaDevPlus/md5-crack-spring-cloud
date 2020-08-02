package com.yysoft.md5.cloud.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yysoft.md5.cloud.entities.CrackMd5Ten;
import com.yysoft.md5.cloud.utils.CStringUtils;

@RestController
public class DeptController_Consumer
{

//	private static final String REST_URL_PREFIX = "http://localhost:8001";//直接调用
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";//通过Eureka调用
	
	@RequestMapping("/md5/get/{md5_str}")
	public CrackMd5Ten getMd5Str(@PathVariable("md5_str") String md5_str){
		String[] microServiceList = {"MICROSERVICECLOUD-MD5-ZERO" , "MICROSERVICECLOUD-MD5-ONE" , "MICROSERVICECLOUD-MD5-TWO" , "MICROSERVICECLOUD-MD5-THREE"};
		if(null != md5_str && md5_str.trim().length() > 0) {
			String prefixStr = md5_str.substring(0, 1);
			if(!CStringUtils.isNumber(prefixStr)) {
				return null;
			}
			String serverUrl = "http://"+microServiceList[Integer.parseInt(prefixStr)]+"/md5/get/" + md5_str;
			System.out.println(new Date() + "\t serverUrl:\t" + serverUrl);
			if(Integer.parseInt(prefixStr) < 4) {
				return restTemplate.getForObject(serverUrl, CrackMd5Ten.class);
			}
			
		}else {
			return null;
		}
		return null;
	}

	/**
	 * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
	 * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate restTemplate;

	// 测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery()
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}

}
