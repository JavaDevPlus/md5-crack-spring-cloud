package com.yysoft.md5.cloud.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.yysoft.md5.cloud.entities.CrackMd5Ten;
import com.yysoft.md5.cloud.repository.CrackMd5Ten0Mapper;
import com.yysoft.md5.cloud.repository.CrackMd5Ten1Mapper;
import com.yysoft.md5.cloud.repository.CrackMd5Ten2Mapper;
import com.yysoft.md5.cloud.repository.CrackMd5Ten3Mapper;
import com.yysoft.md5.cloud.service.md5.CrackMd5Ten1Service;
import com.yysoft.md5.cloud.utils.NullUtil;
import com.yysoft.md5.cloud.utils.SequenceSnowIDUtils;
import com.yysoft.md5.cloud.utils.ZipUtils;

@RestController
public class CrackMd5TenController {
	@Autowired
	private CrackMd5Ten1Service service;
	@Autowired
	private DiscoveryClient client;

	@Autowired
	private CrackMd5Ten0Mapper dao0;
	@Autowired
	private CrackMd5Ten1Mapper dao1;
	@Autowired
	private CrackMd5Ten2Mapper dao2;
	@Autowired
	private CrackMd5Ten3Mapper dao3;

	@RequestMapping(value = "/md5/add", method = RequestMethod.POST)
	public boolean add(@RequestBody CrackMd5Ten dept) {
		return service.add(dept);
	}

	Gson gson = new Gson();
	@RequestMapping(value = "/md5/mq/postAdd", method = RequestMethod.POST)
	public int postAdd(@RequestBody byte[] byteArr) {
		long startDate = new Date().getTime();
		int count0 = 0 , count1 = 0;
		try {
			String msg = new String(ZipUtils.unzip(byteArr) , "UTF-8");
			if(NullUtil.isNotEmpty(msg)) {
				List<Map<String,String>>  jsonList = gson.fromJson(msg, List.class);

				count1 = jsonList.size();
				
				List<CrackMd5Ten> md5RecordList0 = new ArrayList<CrackMd5Ten>();
				List<CrackMd5Ten> md5RecordList1 = new ArrayList<CrackMd5Ten>();
				List<CrackMd5Ten> md5RecordList2 = new ArrayList<CrackMd5Ten>();
				List<CrackMd5Ten> md5RecordList3 = new ArrayList<CrackMd5Ten>();

				for(Map<String,String> map : jsonList) {
					Iterator iter = map.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next();
						String key = (String) entry.getKey();
						String val = (String) entry.getValue();
						if(!NullUtil.isEmptys(key , val)) {

							String startPrefix = key.substring(0 , 1);
							switch (startPrefix) {
							case "0":
								CrackMd5Ten md5Bean0 = new CrackMd5Ten();
								md5Bean0.setId(SequenceSnowIDUtils.getId());
								md5Bean0.setMd532Str(key);
								md5Bean0.setOldStr(val);
								md5Bean0.setCreateDate(new Date());
								md5RecordList0.add(md5Bean0);
								break;
							case "1":
								CrackMd5Ten md5Bean1 = new CrackMd5Ten();
								md5Bean1.setId(SequenceSnowIDUtils.getId());
								md5Bean1.setMd532Str(key);
								md5Bean1.setOldStr(val);
								md5Bean1.setCreateDate(new Date());
								md5RecordList1.add(md5Bean1);
								break;
							case "2":
								CrackMd5Ten md5Bean2 = new CrackMd5Ten();
								md5Bean2.setId(SequenceSnowIDUtils.getId());
								md5Bean2.setMd532Str(key);
								md5Bean2.setOldStr(val);
								md5Bean2.setCreateDate(new Date());
								md5RecordList2.add(md5Bean2);

								break;
							case "3":
								CrackMd5Ten md5Bean3 = new CrackMd5Ten();
								md5Bean3.setId(SequenceSnowIDUtils.getId());
								md5Bean3.setMd532Str(key);
								md5Bean3.setOldStr(val);
								md5Bean3.setCreateDate(new Date());
								md5RecordList3.add(md5Bean3);
								break;
							}
						}
					}
				}

				if(null != md5RecordList0 && md5RecordList0.size() > 0) {
					dao0.insertMd5DataBatch(md5RecordList0);
					count0 += md5RecordList0.size();
				}

				if(null != md5RecordList1 && md5RecordList1.size() > 0) {
					dao1.insertMd5DataBatch(md5RecordList1);
					count0 += md5RecordList1.size();
				}

				if(null != md5RecordList2 && md5RecordList2.size() > 0) {
					dao2.insertMd5DataBatch(md5RecordList2);
					count0 += md5RecordList2.size();
				}

				if(null != md5RecordList3 && md5RecordList3.size() > 0) {
					dao3.insertMd5DataBatch(md5RecordList3);
					count0 += md5RecordList3.size();
				}

			}
			//		System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long endDate = new Date().getTime();
		System.out.println("exec_time: "+(endDate - startDate)+" ms"  + " size1->count0:" + count0 + "     size2->count1:" + count1);
		return 0;
	}

	@RequestMapping(value = "/md5/mq/getAdd", method = RequestMethod.POST)
	public int getAdd(@RequestParam String old_str,@RequestParam String md5_32_str) {
		//		System.out.println("Call 8011" + "  " + old_str + "  " + md5_32_str);
		long startDate = new Date().getTime();
		String startPrefix = md5_32_str.substring(0 , 1);
		CrackMd5Ten record = new CrackMd5Ten();
		record.setCreateDate(new Date());
		record.setId(SequenceSnowIDUtils.getId());
		record.setOldStr(old_str);
		record.setMd532Str(md5_32_str);
		switch (startPrefix) {
		case "0":
			dao0.insert(record);
			break;

		case "1":
			dao1.insert(record);	
			break;

		case "2":
			dao2.insert(record);
			break;

		case "3":
			dao3.insert(record);
			break;
		}

		long endDate = new Date().getTime();
		System.out.println("exec_time: "+(endDate - startDate)+" ms");

		//		CrackMd5Ten dept = service.get(md5_32_str);
		//		if (dept == null) {
		//			throw new RuntimeException("没有id为" + md5_32_str + "的dept记录");
		//		}
		return 1;
	}

	@RequestMapping(value = "/md5/list", method = RequestMethod.GET)
	public List<CrackMd5Ten> list() {
		return service.list();
	}

	// @Autowired
	// private DiscoveryClient client;
	@RequestMapping(value = "/md5/discovery", method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-MD5");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

}
