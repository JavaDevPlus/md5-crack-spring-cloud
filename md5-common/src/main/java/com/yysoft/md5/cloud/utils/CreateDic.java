package com.yysoft.md5.cloud.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典生成工具
 * 
 * @author SuperTom
 * @DATE 2016-6-19 下午4:05:04
 *
 */
public class CreateDic {

	private int bitNum;
	private String str;
	private long allUnitSize;

	public long getAllUnitSize() {
		return allUnitSize;
	}

	public void setAllUnitSize(long allUnitSize) {
		this.allUnitSize = allUnitSize;
	}

	public int getBitNum() {
		return bitNum;
	}

	public void setBitNum(int bitNum) {
		this.bitNum = bitNum;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public List<List<String>> GetDic() {
		int[] tmparray = new int[bitNum];
		List<List<String>> final_list = new ArrayList<List<String>>();
		String result = "";
		for (int i = 0; i < bitNum; i++)
			tmparray[i] = 0;
		int nCount1 = 0;
		int nCount2 = -1;
		while (true) {
			result = "";
			for (int i = 0; i < bitNum; i++) {
				result += str.charAt(tmparray[i]);
			}

//			System.out.println(result);
			
			if (nCount1 % (1000) == 0) { // 1000为一组
				List<String> child_list = new ArrayList<String>();
				child_list.add(result);
				nCount2++;
				final_list.add(child_list);
			} else {
				final_list.get(nCount2).add(result);
			}

			nCount1++;
			// System.out.println("index: " + nCount1);

			// 开始进行下一轮循环
			int length = str.length();
			int mark = 0;
			for (int j = bitNum - 1; j >= 0; j--) {
				if (tmparray[j] == length - 1) {
					if (j != 0) {
						continue;
					} else {
						mark = 1;
						break;
					}
				} else {
					tmparray[j]++;
					for (int k = j + 1; k < bitNum; k++) {
						tmparray[k] = 0;
					}
					break;
				}
			}
			if (mark == 1) {
				break;
			}
		}
		setAllUnitSize(nCount1);
		System.out.println("一共输出密码个数：" + getAllUnitSize());
		return final_list;
	}

	public static void main(String[] args) {

		StringBuffer allStrSb = new StringBuffer("");
		for (int i = 33; i <= 126; i++) { // ASCII码
			allStrSb.append((char) i);
		}
		System.out.println(allStrSb);

		CreateDic cd = new CreateDic();
		cd.bitNum = 2;
		cd.str = allStrSb.toString();
		List<List<String>> oldMd5List = cd.GetDic();
		System.out.println("共" + oldMd5List.size() + "组");
	}

}
