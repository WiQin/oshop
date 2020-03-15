package com.oshop.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 自定义异常
 *
 * @author wyw
 * @date 2020/01/20
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BizException extends RuntimeException{
    private ExceptionEnums enums;
}
