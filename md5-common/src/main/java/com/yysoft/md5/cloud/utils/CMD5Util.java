package com.yysoft.md5.cloud.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class CMD5Util 
{
	private static byte[] hexBase={ '0','1','2','3',
		'4','5','6','7',
		'8','9','a','b',
		'c','d','e','f',};

	/**
	 * 16位MD5
	 *@author SuperTom
	 *@DATE   2016-6-19 下午4:02:30
	 *@param s
	 *@return
	 */
	public static String strToMd516(String s) {
		String md532 = strToMd5(s);
		if(NullUtil.isNotEmpty(md532)){
			return md532.toString().substring(8, 24);
		}
		return "";
	}
	public static String strToMd5(String s) {
		if(s==null) return "";
		byte buff[];
		try {
			buff = s.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			return "";
		}
		try 
		{
			MessageDigest messagedigest = MessageDigest.getInstance("MD5");
			messagedigest.update(buff);
			byte result[] = messagedigest.digest();
			return byteToMd5(result);
		}
		catch(Exception e)
		{
			return "";
		}
	}

	public static String fileToMd5(String fileName) {
		try 
		{
			byte buff[]=new byte[4096];
			MessageDigest messagedigest = MessageDigest.getInstance("MD5");
			FileInputStream fis=new FileInputStream(fileName);
			int len=0;
			while((len=fis.read(buff))>0)
			{
				messagedigest.update(buff,0,len);
			}
			fis.close();
			byte result[] = messagedigest.digest();
			return byteToMd5(result);
		}
		catch(IOException ei)
		{
			System.out.println(CMD5Util.class.getName()+": "+ei.getMessage());
			return "";
		}    	
		catch(Exception e)
		{
			return "";
		}    	
	}
	
	public static void main(String[] args) {
		System.out.println(CMD5Util.strToMd5("/admin/business/common/user/user-operate.jsp"));
	}

	public static String byteToMd5(byte b[]) { 
		if(b==null) return "";
		StringBuffer tmp=new StringBuffer();
		int len=b.length;
		for(int i=0;i<len;i++)
		{
			tmp.append((char)hexBase[(b[i] & 0xF0)>>4]);
			tmp.append((char)hexBase[b[i] & 0x0F]);
		}
		while(tmp.length()<16) tmp.append("00");

		return tmp.toString();
	}
	
}
