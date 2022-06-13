package com.tjulab.adminsystem.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理 web controller 异常
 * ExceptionHandlerExceptionResolver 处理异常
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ArithmeticException.class, NullPointerException.class}) // 处理异常，可以以数组的形式传入能够处理的异常类型
    public String handleArithException(Exception e){
        log.error("异常：{}", e);
        return "login"; // 返回视图地址
    }
}
