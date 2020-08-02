package com.yysoft.md5.cloud.mq;

import java.util.Date;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Component
public class MyTopicListener {

	volatile int index = 0;
	@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "yysoft.queues" , durable = "true"), exchange = @Exchange(value = "yysoft.topic", type = ExchangeTypes.TOPIC , durable = "true" ), key = "yysoft_message.#"))
	@RabbitHandler
	public void consumerTest(String msg) {
		System.out.println("收到消息:" + msg  +  "\t" + index ++);
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	String[] microServiceList = { "MICROSERVICECLOUD-MD5-0123", "MICROSERVICECLOUD-MD5-4567", "MICROSERVICECLOUD-MD5-89AB", "MICROSERVICECLOUD-MD5-CDEF" };
	Gson gson = new Gson();
	// MD5消息接收
	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = "yysoft.md5.topic", type = ExchangeTypes.TOPIC , durable = "true" ) , value = @Queue(value = "yysoft.md5.queues1" , durable = "true") , key = "md5_message.route1"))
	@RabbitHandler
	public void consumerMd50(byte[] byteArr) {
		System.out.println("路由0收到MD5的MQ消息:" + byteArr  +  "\t");
		long startDate = new Date().getTime();
//		try {
//			String msg = new String(ZipUtils.unzip(byteArr) , "UTF-8");
//			if(NullUtil.isNotEmpty(msg)) {
//				List<Map<String,String>>  jsonList = gson.fromJson(msg, List.class);
//				for(Map<String,String> map : jsonList) {
//					Iterator iter = map.entrySet().iterator();
//					while (iter.hasNext()) {
//						Map.Entry entry = (Map.Entry) iter.next();
//						String key = (String) entry.getKey();
//						String val = (String) entry.getValue();
//						if(!NullUtil.isEmptys(key , val)) {
//							String startPrefix = key.substring(0 , 1);
//							switch (startPrefix) {
//							case "0":
//							case "1":
//							case "2":
//							case "3":
//								
////								String serverUrl = "http://" + microServiceList[0] + "/md5/mq/getAdd?old_str={old_str}&md5_32_str={md5_32_str}";
////								Map<String, Object> requestMap = Maps.newHashMap();
////								requestMap.put("old_str", val);
////								requestMap.put("md5_32_str", key);
////						        restTemplate.getForObject(serverUrl, Integer.class, requestMap);
//								break;
//							}
//						}
//					}
//				}
//			}
////			System.out.println(msg);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		String serverUrl = "http://" + microServiceList[0] + "/md5/mq/postAdd";
        restTemplate.postForObject(serverUrl, byteArr, Integer.class);
		
		long endDate = new Date().getTime();
		System.out.println("路由0 exec_time: "+(endDate - startDate)+" ms");
		
	}
	
	// MD5消息接收
		@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = "yysoft.md5.topic", type = ExchangeTypes.TOPIC , durable = "true" ) , value = @Queue(value = "yysoft.md5.queues2" , durable = "true") , key = "md5_message.route2"))
		@RabbitHandler
		public void consumerMd51(byte[] byteArr) {
			System.out.println("路由1收到MD5的MQ消息:" + byteArr  +  "\t");
			long startDate = new Date().getTime();
			
			String serverUrl = "http://" + microServiceList[1] + "/md5/mq/postAdd";
	        restTemplate.postForObject(serverUrl, byteArr, Integer.class);
			
			long endDate = new Date().getTime();
			System.out.println("路由1 exec_time: "+(endDate - startDate)+" ms");
			
		}
		
		// MD5消息接收
		@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = "yysoft.md5.topic", type = ExchangeTypes.TOPIC , durable = "true" ) , value = @Queue(value = "yysoft.md5.queues3" , durable = "true") , key = "md5_message.route3"))
		@RabbitHandler
		public void consumerMd52(byte[] byteArr) {
			System.out.println("路由2收到MD5的MQ消息:" + byteArr  +  "\t");
			long startDate = new Date().getTime();
			
			String serverUrl = "http://" + microServiceList[2] + "/md5/mq/postAdd";
	        restTemplate.postForObject(serverUrl, byteArr, Integer.class);
			
			long endDate = new Date().getTime();
			System.out.println("路由2 exec_time: "+(endDate - startDate)+" ms");
			
		}
		
		// MD5消息接收
		@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = "yysoft.md5.topic", type = ExchangeTypes.TOPIC , durable = "true" ) , value = @Queue(value = "yysoft.md5.queues4" , durable = "true") , key = "md5_message.route4"))
		@RabbitHandler
		public void consumerMd53(byte[] byteArr) {
			System.out.println("路由3收到MD5的MQ消息:" + byteArr  +  "\t");
			long startDate = new Date().getTime();
			
			String serverUrl = "http://" + microServiceList[3] + "/md5/mq/postAdd";
	        restTemplate.postForObject(serverUrl, byteArr, Integer.class);
			
			long endDate = new Date().getTime();
			System.out.println("路由3 exec_time: "+(endDate - startDate)+" ms");
			
		}

}



















