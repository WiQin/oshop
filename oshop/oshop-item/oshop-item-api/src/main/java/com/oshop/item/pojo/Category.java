package com.oshop.item.pojo;

import lombok.Data;

import javax.persistence.Table;

/**
 * 商品分类
 *
 * @author wyw
 * @date 2020/03/08
 */
@Data
@Table(name = "tb_category")
public class Category {

    private Long id;
    private String name;
    private Long parentId;
    private Boolean isParent;
    private Integer sort;
}
