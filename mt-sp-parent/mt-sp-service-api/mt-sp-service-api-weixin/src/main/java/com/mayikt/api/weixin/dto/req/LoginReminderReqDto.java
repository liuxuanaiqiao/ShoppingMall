package com.mayikt.api.weixin.dto.req;

import lombok.Data;

import java.util.Date;

@Data
public class LoginReminderReqDto {
    private String openId;
    private String phone;
    private Date loginTime;
    private String loginIp;
    private String equipment;

    public LoginReminderReqDto(String phone, Date loginTime, String loginIp, String equipment, String openId) {
        this.phone = phone;
        this.loginTime = loginTime;
        this.loginIp = loginIp;
        this.equipment = equipment;
        this.openId = openId;
    }

}