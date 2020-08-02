package com.yysoft.md5.cloud.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
//set方法返回当前对象
@Accessors(chain = true)
public class CrackMd5TenInfo {
    private Long id;

    private Long allCount;

    private Date updateDate;

}