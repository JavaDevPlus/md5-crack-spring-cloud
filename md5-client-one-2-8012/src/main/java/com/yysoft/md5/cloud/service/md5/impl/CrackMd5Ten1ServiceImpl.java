package com.yysoft.md5.cloud.service.md5.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yysoft.md5.cloud.dao.CrackMd5Ten1Dao;
import com.yysoft.md5.cloud.entities.CrackMd5Ten;
import com.yysoft.md5.cloud.service.md5.CrackMd5Ten1Service;

@Service
public class CrackMd5Ten1ServiceImpl implements CrackMd5Ten1Service
{
	@Autowired
	private CrackMd5Ten1Dao dao;
	
	@Override
	public boolean add(CrackMd5Ten dept)
	{
		return dao.addDept(dept);
	}

	@Override
	public CrackMd5Ten get(String id)
	{
		return dao.findById(id);
	}

	@Override
	public List<CrackMd5Ten> list()
	{
		return dao.findAll();
	}

}
