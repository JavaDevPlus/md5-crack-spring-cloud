package com.yysoft.md5.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yysoft.md5.cloud.entities.CrackMd5TenInfo;
import com.yysoft.md5.cloud.service.md5.CrackMd5TenInfoService;

@RestController
@RequestMapping("/md5/production")
public class CrackMd5TenController {
	
	@Autowired
	private CrackMd5TenInfoService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public int add(@RequestBody CrackMd5TenInfo record) {
		return service.insert(record);
	}

	@RequestMapping(value = "/updateAllCount" , method = RequestMethod.POST)
	@ResponseBody
	public int updateAllCount(CrackMd5TenInfo record) {
		System.out.println(record);
		return service.updateAllCount(record);
	}
	
	@RequestMapping(value = "/createMd5Data" , method = RequestMethod.POST)
	public int createMd5Data(@RequestParam("size") int size) {
		System.out.println(size);
		try {
			return service.createMd5Data(size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
