package com.mayikt.api.member;


import com.mayikt.api.base.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface MemberService {

    /**
     * 调用微信服务接口
     * @param a
     * @return
     */
    @GetMapping("memberToWeiXin")
    String memberToWeiXin(Integer a);


    /**
     * 不符合规范
     * @return
     */
//    @GetMapping("addMember")
//    BaseResponse<String> addMember(String userName, String pwd, Integer age);
}