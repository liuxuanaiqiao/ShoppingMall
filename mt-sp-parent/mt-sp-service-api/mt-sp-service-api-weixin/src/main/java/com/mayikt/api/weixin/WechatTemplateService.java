package com.mayikt.api.weixin;


import com.mayikt.api.base.BaseResponse;
import com.mayikt.api.weixin.dto.req.LoginReminderReqDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface WechatTemplateService {
    /**
     * 根据用户的openId发消息
     * @return
     */
    @PostMapping("sendTemplate")
    BaseResponse<String> sendTemplate(@RequestBody  LoginReminderReqDto LoginReminderReqDto);
}