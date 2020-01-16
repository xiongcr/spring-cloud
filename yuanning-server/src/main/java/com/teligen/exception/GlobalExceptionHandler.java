package com.teligen.exception;


import com.teligen.util.returnFormat.Result;
import com.teligen.util.returnFormat.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    //全局异常处理
    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
        log.error(e.getMessage());
        return new Result(false, StatusCode.ERROR,  e.getMessage());
    }

    //自定义异常处理
    @ExceptionHandler(MyException.class)
    public Result myError(MyException e){
        return new Result(false, e.getCode(),  e.getMessage());
    }

}
