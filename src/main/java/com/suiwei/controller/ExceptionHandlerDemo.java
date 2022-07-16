package com.suiwei.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author suiwei
 * @date 2021-09-03 16:19
 */
@ControllerAdvice
public class ExceptionHandlerDemo {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String,Object> handleException(Exception e){
        Map<String ,Object> map = new HashMap<>();
        map.put("code","1");
        map.put("message",e.getMessage());
        return map;
    }
}
