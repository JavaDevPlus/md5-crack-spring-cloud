package com.yysoft.md5.cloud.entities;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 14469
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
//set方法返回当前对象
@Accessors(chain = true)
public class CrackMd5Ten implements Serializable {
	
	private long 	id;
	private String 	oldStr;
	private String 	md532Str;
	private Date 	createDate;

}






