package com.oshop.common.vo;

import com.oshop.common.exception.ExceptionEnums;
import lombok.Data;

/**
 * 异常结果对象
 *
 * @author wyw
 * @date 2020/01/20
 */
@Data

public class ExceptionEntity {

    //状态码
    private int code;
    //错误信息
    private String msg;
    private long timeStamp;

    public ExceptionEntity(ExceptionEnums enums) {
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.timeStamp = System.currentTimeMillis();
    }
}
