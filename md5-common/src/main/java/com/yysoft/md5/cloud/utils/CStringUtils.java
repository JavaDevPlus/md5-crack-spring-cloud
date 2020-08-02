package com.yysoft.md5.cloud.utils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/**
 * �ַ���������
 * @author SuperAdmin
 *@DATE 2011-11-1 ����01:42:18
 * 
 */
public class CStringUtils {

	/**
	 * ����ĸСд
	 * @param name
	 * @return 
	 * Date: 2015-9-29����5:11:28
	 * @author SuperTom
	 */
	public static String captureName(String name) {
		char[] cs = name.toCharArray();
		cs[0] += 32;
		return String.valueOf(cs);

	}

	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isNull(String str) {
		if (str != null && !str.equals("") && str.trim().length() != 0) {
			return false;
		}
		return true;

	}

	/**
	 * �ж�һ���ַ����Ƿ�Ϊ��
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isNulls(String... strs) {
		if (strs.length == 0) {
			return true;
		}
		for (String str : strs) {
			if (str != null && !str.equals("") && str.trim().length() != 0) {

			} else {
				return true;
			}
		}
		return false;

	}

	private static final DecimalFormat df = new DecimalFormat("#");
	public static String getPercentDesc(float percent) {

		float value = percent * 100;

		return df.format(value);
	}

	/**
	 *�����ַ��������е�λ��
	 * 
	 * @param arr
	 * @param str
	 * @return fail:return -1,
	 */
	public static int findStrArrPos(String[] arr, String str) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(str)) {
				return i;
			}
		}
		return -1;
	}

	public static String subString(String str, int index) {
		if (CStringUtils.isNull(str)) {
			return "";
		} else {
			if (str.length() > index) {
				return str.substring(0, index);
			} else {
				return str;
			}
		}
	}

	/**
	 * ���ܣ���������Ϊnull��Ϊ��
	 * 
	 * @return ��Ϊ��:true ��:false
	 * @param strCs
	 *            java.lang.String
	 */
	public static boolean isNotEmpty(Object objCs) {
		return !isEmpty(objCs);
	}

	/**
	 * ���ܣ���Ϊnull�Ķ���תΪ"",ȥ�ո�
	 * 
	 * @return java.lang.String
	 * @param strCs
	 *            java.lang.String
	 */
	public static String formatTrimString(Object objCs) {
		if (objCs == null) {
			return "";
		}
		String strObj = objCs.toString();
		if (strObj.length() == 0) {
			return strObj;
		}
		return strObj.trim();
	}

	/**
	 * ������ת��Ϊ������
	 * 
	 * @param obj
	 * @return
	 */
	public static long objToLong(Object obj) {
		if (null == obj || obj.toString().trim().length() <= 0) {
			return 0L;
		}
		return Long.parseLong(CStringUtils.formatTrimString(obj));
	}

	public static boolean objToBoolean(Object obj){
		if(isNotEmpty(obj)){
			String temp = objToStr(obj);
			if("true".equals(temp)){
				return true;
			}else if("false".equals(temp)){
				return false;
			}
		}
		return false;
	}

	/**
	 * ����Map�ļ���ѯMap��ֵ
	 * 
	 * @author SuperAdmin
	 *@DATE Sep 2, 2011 2:28:57 PM
	 *@param paramMap
	 *@param mapKey
	 *@return
	 */
	public static String paramMapByKey(Map paramMap, String mapKey) {
		if (!CStringUtils.isNull(mapKey) && null != paramMap
				&& !paramMap.isEmpty() && paramMap.containsKey(mapKey)) {
			return CStringUtils.formatTrimString(objToStr(paramMap.get(mapKey)));
		} else {
			return "";
		}
	}

	/**
	 * ����hashTable�ļ���ѯMap��ֵ
	 * 
	 * @author SuperAdmin
	 *@DATE Sep 2, 2011 2:28:57 PM
	 *@param paramMap
	 *@param mapKey
	 *@return
	 */
	public static String paramMapByKey(Hashtable paramMap, String mapKey) {
		if (!CStringUtils.isNull(mapKey) && null != paramMap
				&& !paramMap.isEmpty() && paramMap.containsKey(mapKey)) {
			return CStringUtils.formatTrimString(objToStr(paramMap.get(mapKey)));
		} else {
			return "";
		}
	}

	/**
	 * ������ת��Ϊ�ַ���
	 * 
	 * @param obj
	 * @return
	 */
	public static String objToStr(Object obj) {
		if (null == obj || obj.toString().trim().length() <= 0) {
			return "";
		}
		return String.valueOf(obj);
	}

	/**
	 * ���ܣ�������Ϊnull��Ϊ��
	 * 
	 * @return boolean
	 * @param strCs
	 *            java.lang.String
	 */
	public static boolean isEmpty(Object objCs) {
		if (objCs == null) {
			return true;
		}

		String strObj = objCs.toString();
		if (strObj.length() == 0) {
			return true;
		}

		return strObj.trim().length() == 0;
	}

	public static Integer objToInteger(Object ojb) {
		if (null == ojb || ojb.toString().trim().length() <= 0) {
			return 0;
		}
		return Integer.parseInt(CStringUtils.formatTrimString(ojb));
	}
	
	public static int StrToInt(String value) {
		if (NullUtil.isEmpty(value))
			return 0;
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * �ж��ַ��ǲ���������
	 * @author ����
	 * @DATE   2011-7-31 13:43:42
	 */
	public static boolean isNumber(String str){   
		Pattern pattern = Pattern.compile("[0-9]*");   
		return pattern.matcher(str).matches();      
	}

	/**
	 * ����������Ľ���    
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static String[] selArrMixed(String[] arr1, String[] arr2) {    
		Map<String, Boolean> map = new HashMap<String, Boolean>();    
		LinkedList<String> list = new LinkedList<String>();    
		for (String str : arr1) {    
			if (!map.containsKey(str)) {    
				map.put(str, Boolean.FALSE);    
			}    
		}    
		for (String str : arr2) {    
			if (map.containsKey(str)) {    
				map.put(str, Boolean.TRUE);    
			}    
		}    

		for (Entry<String, Boolean> e : map.entrySet()) {    
			if (e.getValue().equals(Boolean.TRUE)) {    
				list.add(e.getKey());    
			}    
		}    

		String[] result = {};    
		return list.toArray(result);    
	}
	
	/**
	 * ���ַ�������תΪ���ŷָ����ַ���
	 * @param strArr
	 * @return 
	 * Date: 2015-10-10����10:45:54
	 * @author SuperTom
	 */
	public static String strArrToCommaStr(Object... strArr){
		StringBuffer sb = new StringBuffer("");
		if(NullUtil.isNotNull(strArr) && strArr.length > 0){
			for(int i = 0 ; i < strArr.length ; i++){
				sb.append(strArr[i]);
				if(i != strArr.length -1){
					sb.append(",");
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
//		System.out.println(CStringUtils.isNumber("544343434343434"));
		System.out.println(strArrToCommaStr("1","2","3"));
	}

}



