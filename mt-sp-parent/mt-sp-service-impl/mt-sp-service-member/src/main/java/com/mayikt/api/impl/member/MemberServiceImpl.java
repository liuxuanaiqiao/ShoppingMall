package com.mayikt.api.impl.member;

import com.mayikt.api.base.BaseApiService;
import com.mayikt.api.base.BaseResponse;
import com.mayikt.api.impl.feign.WeChatServiceFeign;
import com.mayikt.api.member.MemberService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl extends BaseApiService<String> implements MemberService {
    @Autowired
    private WeChatServiceFeign weChatServiceFeign;
    @Override
    public String memberToWeiXin(Integer a) {
        return weChatServiceFeign.getWeChat(a);
    }

//    @Override
//    public BaseResponse<String> addMember(String userName, String pwd, Integer age) {
//        if(StringUtils.isEmpty(userName)){
//            return setResultError("userName is null error");
//        }
//        int j= 1/age;
//        return setResultSuccess("success");
//    }
}
