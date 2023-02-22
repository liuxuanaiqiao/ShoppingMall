package com.mayikt.api.impl.wx.mp.handler;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mayikt.api.impl.wx.mp.builder.TextBuilder;
import com.mayikt.api.impl.wx.mp.entity.WechatKeywordDo;
import com.mayikt.api.impl.wx.mp.mapper.KeywordMapper;
import com.mayikt.api.impl.wx.mp.utils.JsonUtils;
import com.mzlion.easyokhttp.HttpClient;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {
    @Autowired
    private KeywordMapper keywordMapper;
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }
        // 1.查询db 匹配关键字
        QueryWrapper<WechatKeywordDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("keyword_Name",wxMessage.getContent());
        WechatKeywordDo wechatKeywordDo = keywordMapper.selectOne(queryWrapper);
        String result=null;
        // 2. 如果db匹配到关键字
        if(wechatKeywordDo!=null){
            result=wechatKeywordDo.getKeywordValue();
        }else {
            // 3.如果数据库没有匹配关键字，则可以调用第三方的接口查询
            result = HttpClient
                    // 请求方式和请求url
                    .get("http://i.itpk.cn/api.php?question="+wxMessage.getContent())
                    .asString();
        }
        return new TextBuilder().build(result, wxMessage, weixinService);

    }

}
