package com.oshop.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 规格参数
 */
@Data
@Table(name = "tb_spec_param")
public class SpecParam {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private Long cid;

    private Long groupId;

    private String name;

    //避免关键字误处理
    @Column(name = "'numeric'")
    private Boolean numeric;

    private String unit;

    //是否为sku通用属性
    private Boolean generic;
    //是否用于搜索过滤
    private Boolean Searching;

    private String segements;

}
