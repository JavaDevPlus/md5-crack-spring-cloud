package com.yysoft.md5.cloud.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {
 
	@Autowired
    private RabbitTemplate rabbitTemplate;
 
    public String sendData2MQ(Long userId, Long seckillId) {
        String orderNo = UUID.randomUUID().toString();
        //2、将订单编号、用户ID保存到rabbitMQ中去
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("orderNo",orderNo);
        dataMap.put("userId",userId);
        dataMap.put("seckillId",seckillId);
        rabbitTemplate.convertAndSend("yysoft.topic" , "yysoft_message.test1" , "Test " + orderNo);
        
        rabbitTemplate.convertAndSend("yysoft.md5.topic" , "md5_message.#" , "MD5 " + orderNo);
        
        return orderNo;
    }
 
    @RequestMapping("/rabbit")
    public Map<String,Object> start(Long userId,Long seckillId){
        Map<String,Object> map = new HashMap<>();
        for(int i = 0 ; i < 6000; i ++) {
        	System.out.println("生产消息： " + i);
        	String s = sendData2MQ(userId, seckillId);
            map.put("ID",s);
            try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        return map;
    }
}