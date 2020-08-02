package com.yysoft.md5.cloud.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yysoft.md5.cloud.entities.CrackMd5Ten;

@Mapper
public interface CrackMd5TenbMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CrackMd5Ten record);

    int insertSelective(CrackMd5Ten record);

    CrackMd5Ten selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CrackMd5Ten record);
    
    int updateByPrimaryKey(CrackMd5Ten record);
    
    int insertMd5DataBatch(List<CrackMd5Ten> md5RecordList);
    
}