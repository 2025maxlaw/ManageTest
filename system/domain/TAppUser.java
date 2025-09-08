package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import java.math.BigDecimal;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 玩家用户对象 t_app_user
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_app_user")
public class TAppUser extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * $column.columnComment
     */
        @TableId(value = "user_id",type = IdType.AUTO)
    private Long userId;
    /**
     * 姓名
     */
    private String loginName;
    /**
     * 登陆密码
     */
    private String loginPassword;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 0-正常 1-测试
     */
    private Long isTest;
    /**
     * 盐
     */
    private String salt;
    /**
     * 地址
     */
    private String address;
    /**
     * 地址类型 ETH TRC
     */
    private String walletType;
    /**
     * 0正常1冻结
     */
    private Long status;
    /**
     * 秒合约打码量
     */
    private BigDecimal totleAmont;
    /**
     * 0正常 1包赢 2包输
     */
    private Long buff;
    /**
     * 代理树
     */
    private String tree;
    /**
     * 代理地址
     */
    private String fatherAddr;
    /**
     * 代理id
     */
    private Long fatherId;
    /**
     * 邀请码
     */
    private String activeCode;
    /**
     * 注册ip
     */
    private String registerIp;
    /**
     * 注册域名
     */
    private String host;
    /**
     * 后台代理id
     */
    private Long systemUserId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * vip等级 
     */
    private Long level;
    /**
     * $column.columnComment
     */
    private String searchValue;

}
