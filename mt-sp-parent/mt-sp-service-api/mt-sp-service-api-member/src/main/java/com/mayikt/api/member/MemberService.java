package com.mayikt.api.member;


import com.mayikt.api.base.BaseResponse;
import com.mayikt.api.member.dto.req.UserReqDto;
import com.mayikt.api.member.dto.resp.UserRespDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

public interface MemberService {

    /**
     * 调用微信服务接口
     * @param a
     * @return
     */
    @GetMapping("memberToWeiXin")
    String memberToWeiXin(Integer a);



    @PostMapping("updateUserDto")
    BaseResponse<UserRespDto> updateUserDto(@RequestBody UserReqDto userReqDto);

    @RequestMapping("/getTestConfig")
    String getTestConfig();
    /**
     * 不符合规范
     * @return
     */
//    @PostMapping("updateUser")
//    Object updateUser(@RequestBody Map<String, String> map);

    /**
     * 不符合规范
     * @return
     */
//    @GetMapping("addMember")
//    BaseResponse<String> addMember(String userName, String pwd, Integer age);
}