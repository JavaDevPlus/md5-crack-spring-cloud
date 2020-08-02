package com.yysoft.md5.cloud.service;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.yysoft.md5.cloud.entities.CrackMd5Ten;

import feign.hystrix.FallbackFactory;
@Component
@Configuration
public class CrackMd5TenServiceServiceFallbackFactory implements FallbackFactory<CrackMd5Ten2FeiginService> {

    @Override
    public CrackMd5Ten2FeiginService create(Throwable throwable) {
        return new CrackMd5Ten2FeiginService(){

            @Override
            public CrackMd5Ten get(String sid) {
                return new CrackMd5Ten().setMd532Str("未找到数据!");
            }

            @Override
            public List<CrackMd5Ten> list() {
            	System.out.println("---------  " + new Date());
                return null;
            }

            @Override
            public boolean add(CrackMd5Ten dept) {
                return false;
            }
        };
    }
}
