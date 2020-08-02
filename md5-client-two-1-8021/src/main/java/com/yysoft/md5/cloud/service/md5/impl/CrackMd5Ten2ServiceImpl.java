package com.yysoft.md5.cloud.service.md5.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yysoft.md5.cloud.dao.CrackMd5Ten2Dao;
import com.yysoft.md5.cloud.entities.CrackMd5Ten;
import com.yysoft.md5.cloud.service.md5.CrackMd5Ten2Service;

@Service
public class CrackMd5Ten2ServiceImpl implements CrackMd5Ten2Service
{
	@Autowired
	private CrackMd5Ten2Dao dao;
	
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
		System.out.println("two-CrackMd5TenServiceImpl" + new Date());
		return dao.findAll();
	}

}
