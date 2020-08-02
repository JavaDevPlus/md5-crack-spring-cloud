package com.yysoft.md5.cloud.service.md5;

import java.util.List;

import com.yysoft.md5.cloud.entities.CrackMd5Ten;

public interface CrackMd5Ten2Service
{
	public boolean add(CrackMd5Ten dept);

	public CrackMd5Ten get(String id);

	public List<CrackMd5Ten> list();
}
