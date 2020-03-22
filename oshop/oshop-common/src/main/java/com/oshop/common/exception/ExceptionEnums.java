package com.oshop.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 异常枚举类
 *
 * @author wyw
 * @date 2020/01/20
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {

    PRICE_IS_NULL(400,"价格不能为空"),
    CATEGORY_NOT_FOUND(404,"未查到商品分类"),
    BRAND_NOT_FOUND(404,"品牌信息不存在"),
    BRAND_SAVE_ERROR(500,"品牌信息不存在");

    private int code;
    private String msg;
}
