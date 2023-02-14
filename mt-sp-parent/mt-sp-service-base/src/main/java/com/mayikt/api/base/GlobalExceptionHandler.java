package com.mayikt.api.base;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局捕获异常
 */
@ControllerAdvice(basePackages = "com.mayikt.api.impl")
public class GlobalExceptionHandler {

   @ExceptionHandler(RuntimeException.class)
   @ResponseBody
   public Map<String, Object> errorResult() {
      Map<String, Object> errorResultMap = new HashMap<String, Object>();
      errorResultMap.put("code", "500");
      errorResultMap.put("msg", "系统出现错误!");
      return errorResultMap;
   }
}