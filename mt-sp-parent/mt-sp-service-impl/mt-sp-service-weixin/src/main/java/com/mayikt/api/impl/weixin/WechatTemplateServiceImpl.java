package com.mayikt.api.impl.weixin;

import com.mayikt.api.base.BaseApiService;
import com.mayikt.api.base.BaseResponse;
import com.mayikt.api.impl.wx.mp.config.WxMpConfiguration;
import com.mayikt.api.impl.wx.mp.config.WxMpProperties;
import com.mayikt.api.utils.SimpleDateFormatUtils;
import com.mayikt.api.weixin.WechatTemplateService;
import com.mayikt.api.weixin.dto.req.LoginReminderReqDto;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class WechatTemplateServiceImpl extends BaseApiService<String> implements WechatTemplateService {

    @Value("${mayikt.member.weixin.login.templateId}")
   private  String loginTemplateId;
    @Autowired
    private WxMpProperties wxMpProperties;
    @Override
    public BaseResponse<String> sendTemplate(LoginReminderReqDto loginTemplateDto) {
        String phone = loginTemplateDto.getPhone();
        if (StringUtils.isEmpty(phone)) {
            return setResultError("phone参数不能为空!");
        }
        String loginIp = loginTemplateDto.getLoginIp();
        if (StringUtils.isEmpty(phone)) {
            return setResultError("loginIp参数不能为空!");
        }
        Date loginTime =
                loginTemplateDto.getLoginTime();
        if (loginTime == null) {
            return setResultError("loginTime参数不能为空!");
        }
        String openId = loginTemplateDto.getOpenId();
        if (StringUtils.isEmpty(openId)) {
            return setResultError("loginIp参数不能为空!");
        }
        String equipment = loginTemplateDto.getEquipment();
        WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();
        wxMpTemplateMessage.setTemplateId(loginTemplateId);
        wxMpTemplateMessage.setToUser(openId);
        List<WxMpTemplateData> data = new ArrayList<>();
        data.add(new WxMpTemplateData("first", phone));
        data.add(new WxMpTemplateData("keyword1", SimpleDateFormatUtils.getFormatStrByPatternAndDate(loginTime)));
        data.add(new WxMpTemplateData("keyword2", loginIp));
        data.add(new WxMpTemplateData("keyword3", equipment));
        wxMpTemplateMessage.setData(data);
        try {
            String appId = wxMpProperties.getConfigs().get(0).getAppId();
            WxMpTemplateMsgService templateMsgService = WxMpConfiguration.getMpServices().get(appId).getTemplateMsgService();
            templateMsgService.sendTemplateMsg(wxMpTemplateMessage);
            return setResultSuccess();
        } catch (Exception e) {
            return setResultError("发送失败");
        }
    }
}