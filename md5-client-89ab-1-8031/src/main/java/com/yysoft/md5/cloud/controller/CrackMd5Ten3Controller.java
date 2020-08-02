package com.yysoft.md5.cloud.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.yysoft.md5.cloud.entities.CrackMd5Ten;
import com.yysoft.md5.cloud.repository.CrackMd5Ten8Mapper;
import com.yysoft.md5.cloud.repository.CrackMd5Ten9Mapper;
import com.yysoft.md5.cloud.repository.CrackMd5TenaMapper;
import com.yysoft.md5.cloud.repository.CrackMd5TenbMapper;
import com.yysoft.md5.cloud.utils.NullUtil;
import com.yysoft.md5.cloud.utils.SequenceSnowIDUtils;
import com.yysoft.md5.cloud.utils.ZipUtils;

@RestController
public class CrackMd5Ten3Controller {
	@Autowired
	private DiscoveryClient client;

	@Autowired
	private CrackMd5Ten8Mapper dao8;
	@Autowired
	private CrackMd5Ten9Mapper dao9;
	@Autowired
	private CrackMd5TenaMapper daoa;
	@Autowired
	private CrackMd5TenbMapper daob;

	Gson gson = new Gson();
	@RequestMapping(value = "/md5/mq/postAdd", method = RequestMethod.POST)
	public int postAdd(@RequestBody byte[] byteArr) {
		long startDate = new Date().getTime();
		try {
			String msg = new String(ZipUtils.unzip(byteArr) , "UTF-8");
			if(NullUtil.isNotEmpty(msg)) {
				List<Map<String,String>>  jsonList = gson.fromJson(msg, List.class);

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
							case "8":
								CrackMd5Ten md5Bean0 = new CrackMd5Ten();
								md5Bean0.setId(SequenceSnowIDUtils.getId());
								md5Bean0.setMd532Str(key);
								md5Bean0.setOldStr(val);
								md5Bean0.setCreateDate(new Date());
								md5RecordList0.add(md5Bean0);
								break;
							case "9":
								CrackMd5Ten md5Bean1 = new CrackMd5Ten();
								md5Bean1.setId(SequenceSnowIDUtils.getId());
								md5Bean1.setMd532Str(key);
								md5Bean1.setOldStr(val);
								md5Bean1.setCreateDate(new Date());
								md5RecordList1.add(md5Bean1);
								break;
							case "a":
								CrackMd5Ten md5Bean2 = new CrackMd5Ten();
								md5Bean2.setId(SequenceSnowIDUtils.getId());
								md5Bean2.setMd532Str(key);
								md5Bean2.setOldStr(val);
								md5Bean2.setCreateDate(new Date());
								md5RecordList2.add(md5Bean2);

								break;
							case "b":
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
					dao8.insertMd5DataBatch(md5RecordList0);
				}

				if(null != md5RecordList1 && md5RecordList1.size() > 0) {
					dao9.insertMd5DataBatch(md5RecordList1);
				}

				if(null != md5RecordList2 && md5RecordList2.size() > 0) {
					daoa.insertMd5DataBatch(md5RecordList2);
				}

				if(null != md5RecordList3 && md5RecordList3.size() > 0) {
					daob.insertMd5DataBatch(md5RecordList3);
				}



			}
			//		System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long endDate = new Date().getTime();
		System.out.println("exec_time: "+(endDate - startDate)+" ms");
		return 0;
	}

}
