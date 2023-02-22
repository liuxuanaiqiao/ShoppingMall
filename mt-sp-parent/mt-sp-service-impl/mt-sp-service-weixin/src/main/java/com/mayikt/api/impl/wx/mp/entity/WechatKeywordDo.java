package com.mayikt.api.impl.wx.mp.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("wechat_keywords")
public class WechatKeywordDo {
    private Long id;
    private String keywordName;
    private String keywordValue;
    private Date createTime;
    private Date updateTime;
    private Long version;
    //逻辑删除默认查询为0的
    @TableLogic
    private int isDelete;
}