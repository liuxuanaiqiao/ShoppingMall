package com.mayikt.api.weixin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface WeChatService {

    /**
     * nacos生产者接口参数需要添加注解
     * @param a
     * @return
     */
    @GetMapping("/getWeChat")
    String getWeChat(@RequestParam("a") Integer a);
}