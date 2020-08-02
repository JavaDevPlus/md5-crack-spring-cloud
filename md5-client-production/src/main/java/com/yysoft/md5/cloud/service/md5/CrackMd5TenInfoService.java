package com.yysoft.md5.cloud.service.md5;

import com.yysoft.md5.cloud.entities.CrackMd5TenInfo;

public interface CrackMd5TenInfoService {
	
	public int insert(CrackMd5TenInfo record);
	
	public int updateAllCount(CrackMd5TenInfo record);
	
	public int createMd5Data(int size) throws Exception;

}
