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
    GOOD_NOT_FOUND(404,"商品信息不存在"),
    BRAND_SAVE_ERROR(500,"品牌信息不存在"),
    UPLOAD_ERROR(500,"文件上传失败"),
    INVALID_FILE_TYPE(400,"无效的文件类型"),
    SPEC_GROUP_NOT_FOUND(404,"商品规格组不存在"),
    SPEC_PARAM_NOT_FOUND(404,"商品规格参数不存在");

    private int code;
    private String msg;
}
