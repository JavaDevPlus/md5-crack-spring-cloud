package com.yysoft.md5.cloud.utils;

/**
 * 对象为空的判断
 * 
 * @author wenping.rong
 * 
 */
public class NullUtil {

	/**
	 * 一个数组是否有为空
	 * @author ZhouMing
	 * 2017-8-2 上午10:17:30
	 * @param objs
	 * @return
	 */
	public static final boolean isEmptys(Object ...objs){
		for(Object obj : objs){
			if(isEmpty(obj)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断是否为NULL
	 * 
	 * @param obj
	 * @return
	 */
	public static final boolean isNull(Object obj) {
		if (null == obj) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否为Not NULL
	 * 
	 * @param obj
	 * @return
	 */
	public static final boolean isNotNull(Object obj) {
		if (null != obj) {
			return true;
		} else {
			return false;
		}
	}

	public static final boolean isEmpty(Object obj) {
		if (null == obj || "".equals(obj)) {
			return true;
		} else {
			return false;
		}
	}

	public static final boolean isNotEmpty(Object obj) {
		if (null != obj && !"".equals(obj)) {
			return true;
		} else {
			return false;
		}
	}

}
