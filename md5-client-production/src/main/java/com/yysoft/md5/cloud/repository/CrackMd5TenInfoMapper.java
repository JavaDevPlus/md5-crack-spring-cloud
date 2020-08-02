package com.yysoft.md5.cloud.repository;

import org.apache.ibatis.annotations.Mapper;

import com.yysoft.md5.cloud.entities.CrackMd5TenInfo;

@Mapper
public interface CrackMd5TenInfoMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(CrackMd5TenInfo record);

    int insertSelective(CrackMd5TenInfo record);

    CrackMd5TenInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CrackMd5TenInfo record);

    int updateByPrimaryKey(CrackMd5TenInfo record);
    
    int updateAllCount(CrackMd5TenInfo record);
    
    
}