package com.yysoft.md5.cloud.service.md5.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.yysoft.md5.cloud.entities.CrackMd5TenInfo;
import com.yysoft.md5.cloud.repository.CrackMd5TenInfoMapper;
import com.yysoft.md5.cloud.service.md5.CrackMd5TenInfoService;
import com.yysoft.md5.cloud.utils.CMD5Util;
import com.yysoft.md5.cloud.utils.CreateDic;
import com.yysoft.md5.cloud.utils.ZipUtils;

@Service
@Transactional
public class CrackMd5TenInfoServiceImpl implements CrackMd5TenInfoService
{
	@Autowired
	private CrackMd5TenInfoMapper dao;

	@Override
	public int insert(CrackMd5TenInfo record) {
		record.setUpdateDate(new Date());
		System.out.println(record);
		return dao.insert(record);
	}

	@Override
	public int updateAllCount(CrackMd5TenInfo record) {
		return dao.updateAllCount(record);
	}

	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	@Override
	public int createMd5Data(int size) throws Exception {

		StringBuffer allStrSb = new StringBuffer("");
		for(int i = 33; i <= 126 ; i ++){ // ASCII码
			allStrSb.append((char)i);
		}
		System.out.println("总字符串基数: " + allStrSb);

		Gson gson = new Gson();

		CreateDic cd = new CreateDic();
		cd.setBitNum(size);
		cd.setStr(allStrSb.toString());
		List<List<String>> oldMd5List = cd.GetDic();
		System.out.println("本次共" + oldMd5List.size() + "组");

		for(final List<String> childList : oldMd5List){

			List<Map<String,String>> sendList0 = new ArrayList<Map<String,String>>();
			List<Map<String,String>> sendList4 = new ArrayList<Map<String,String>>();
			List<Map<String,String>> sendList8 = new ArrayList<Map<String,String>>();
			List<Map<String,String>> sendListc = new ArrayList<Map<String,String>>();
			
			List<List<Map<String,String>>> allList = new ArrayList<List<Map<String,String>>>();
			
			for(String oldStr : childList) {
				String md5Str1 = CMD5Util.strToMd5(oldStr);
				String md5Str2 = CMD5Util.strToMd5(md5Str1);
				String md5Str3 = CMD5Util.strToMd5(md5Str2);
				String md5Str4 = CMD5Util.strToMd5(md5Str3);
				String md5Str5 = CMD5Util.strToMd5(md5Str4);
				
				addListData(sendList0, sendList4, sendList8, sendListc, oldStr, md5Str1);
				addListData(sendList0, sendList4, sendList8, sendListc, oldStr, md5Str2);
				addListData(sendList0, sendList4, sendList8, sendListc, oldStr, md5Str3);
				addListData(sendList0, sendList4, sendList8, sendListc, oldStr, md5Str4);
				addListData(sendList0, sendList4, sendList8, sendListc, oldStr, md5Str5);
				
//				String startPrefix1 = md5Str1.substring(0 , 1);
//				String startPrefix2 = md5Str2.substring(0 , 1);
//				String startPrefix3 = md5Str3.substring(0 , 1);
//				String startPrefix4 = md5Str4.substring(0 , 1);
//				String startPrefix5 = md5Str5.substring(0 , 1);
//				
//				childMap.put(md5Str1, oldStr);
//				childMap.put(md5Str2, oldStr);
//				childMap.put(md5Str3, oldStr);
//				childMap.put(md5Str4, oldStr);
//				childMap.put(md5Str5, oldStr);
				
				// 0,1,2,3		4,5,6,7		8,9,a,b		c,d,e,f
			}
			System.out.println("本组中字典个数：" + childList.size());
			
			allList.add(sendList0);
			allList.add(sendList4);
			allList.add(sendList8);
			allList.add(sendListc);
			
			for(int i = 0 ; i < 4 ; i ++) {
				String json = gson.toJson(allList.get(i));
				byte[] byteArr = json.toString().getBytes("utf-8");
				byteArr = ZipUtils.zip(byteArr);
				System.out.println(byteArr.length + "   " + json.length());
				rabbitTemplate.convertAndSend("yysoft.md5.topic" , "md5_message.route" + ( i + 1 ) , byteArr); // 分发到相应的路由分别处理 , Feigin收到MQ消息后进行消息转发到对应的微服务
			}
			
			// 更新发送的总数量
			CrackMd5TenInfo record = new CrackMd5TenInfo();
			record.setAllCount(Long.valueOf(childList.size() * 5));
			dao.updateAllCount(record);
			
		}
		System.out.println("\n");

		return 1;
	}
	
	/**
	 * 组装对应的数据到list中
	 * @Date 2020年7月17日 下午9:53:22
	 * @author ZhouMing 
	 * @Description 
	 * @param sendList0
	 * @param sendList4
	 * @param sendList8
	 * @param sendListc
	 * @param oldStr
	 * @param md5Str
	 */
	private void addListData(List<Map<String,String>> sendList0 , List<Map<String,String>> sendList4 , List<Map<String,String>> sendList8 , List<Map<String,String>> sendListc , String oldStr , String md5Str ) {
		String startPrefix = md5Str.substring(0 , 1);
		Map<String,String> childMap = new HashMap<String,String>();
		switch (startPrefix) {
		case "0":
		case "1":
		case "2":
		case "3":
			childMap.put(md5Str, oldStr);
			sendList0.add(childMap);
			break;
			
		case "4":
		case "5":
		case "6":
		case "7":
			childMap.put(md5Str, oldStr);
			sendList4.add(childMap);
			break;
			
			
		case "8":
		case "9":
		case "a":
		case "b":
			childMap.put(md5Str, oldStr);
			sendList8.add(childMap);
			break;
			
		case "c":
		case "d":
		case "e":
		case "f":
			childMap.put(md5Str, oldStr);
			sendListc.add(childMap);
			break;
			
	}

	}

}












