package com.tjulab.adminsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResponseStatusExceptionResolver 处理异常
 * 底层调用 response.sendError(statusCode, resolvedReason);     tomcat发送 /error 请求
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "用户数量太多") // 返回状态码信息
public class UserTooManyException extends RuntimeException{
    public UserTooManyException(){
    }
    public UserTooManyException(String message){
        super(message);
    }
}
