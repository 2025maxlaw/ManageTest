package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户详细信息对象 t_app_user_detail
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_app_user_detail")
public class TAppUserDetail extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * 
     */
        @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 
     */
    private Long userId;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 身份证正面照片
     */
    private String frontUrl;
    /**
     * 国际
     */
    private String country;
    /**
     * 
     */
    private String cardType;
    /**
     * 手持身份证照片
     */
    private String handelUrl;
    /**
     * 身份证反面照片
     */
    private String backUrl;
    /**
     * 用户交易密码
     */
    private String userTardPwd;
    /**
     * 
     */
    private String searchValue;
    /**
     * 初级验证状态
     */
    private Long auditStatusPrimary;
    /**
     * 高级验证状态
     */
    private Long auditStatusAdvanced;
    /**
     * 信用分
     */
    private Long credits;
    /**
     * 用户充值地址
     */
    private String userRechargeAddress;
    /**
     * 连赢场次
     */
    private Long winNum;
    /**
     * 连输场次
     */
    private Long loseNum;

}
