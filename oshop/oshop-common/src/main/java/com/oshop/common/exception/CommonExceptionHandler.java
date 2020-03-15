package com.oshop.common.exception;

import com.oshop.common.vo.ExceptionEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 通用异常处理器
 * 默认情况下拦截controller注解的类
 *
 * @ControllerAdvice  默认拦截controller
 *
 * @author wyw
 * @date 2020/01/20
 */
@ControllerAdvice
public class CommonExceptionHandler {

    /**
     * @ExceptionHandler(BizException.class)  拦截指定异常
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    public ResponseEntity<ExceptionEntity> handle(BizException e){
        ExceptionEnums enums = e.getEnums();
        //body返回一个异常对象
        return ResponseEntity.status(enums.getCode()).body(new ExceptionEntity(enums));
    }
}
