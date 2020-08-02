package com.yysoft.md5.cloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yysoft.md5.cloud.entities.CrackMd5Ten;

@Mapper
public interface CrackMd5Ten1Dao
{
    public boolean addDept(CrackMd5Ten dept);

    public CrackMd5Ten findById(String id);

    public List<CrackMd5Ten> findAll();
}