package com.yysoft.md5.cloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yysoft.md5.cloud.entities.CrackMd5Ten;

/**
 *
 * @Description: 修改microservicecloud-api工程，根据已经有的DeptClientService接口

新建

一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
 * @author zzyy
 * @date 2018年4月21日
 */
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
//@FeignClient(value = "MICROSERVICECLOUD-MD5-ONE",fallbackFactory=CrackMd5TenServiceServiceFallbackFactory.class)
@FeignClient(value = "MICROSERVICECLOUD-MD5-ONE")
@Configuration
public interface CrackMd5Ten1FeiginService
{
    @RequestMapping(value = "/md5/get/{sid}", method = RequestMethod.GET)
    public CrackMd5Ten get(@PathVariable("sid") String sid);

    @RequestMapping(value = "/md5/list", method = RequestMethod.GET)
    public List<CrackMd5Ten> list();

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(CrackMd5Ten entity);
}






