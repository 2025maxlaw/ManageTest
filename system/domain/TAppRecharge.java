package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户充值对象 t_app_recharge
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_app_recharge")
public class TAppRecharge extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * 卡ID
     */
        @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 所有者ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 充值金额
     */
    private BigDecimal amount;
    /**
     * $column.columnComment
     */
    private Long bonus;
    /**
     * 状态
     */
    private Long status;
    /**
     * 订单号
     */
    private String serialId;
    /**
     * 第三方支付订单号
     */
    private String txId;
    /**
     * 类型
     */
    private String type;
    /**
     * $column.columnComment
     */
    private String searchValue;
    /**
     * 充值地址
     */
    private String address;
    /**
     * $column.columnComment
     */
    private String tree;
    /**
     * 币总
     */
    private String coin;
    /**
     * 入款地址
     */
    private String toAddress;
    /**
     * 区块时间
     */
    private Date blockTime;
    /**
     * $column.columnComment
     */
    private String host;
    /**
     * 实际到账金额
     */
    private BigDecimal realAmount;
    /**
     * 充值凭证
     */
    private String fileName;
    /**
     * $column.columnComment
     */
    private String rechargeRemark;
    /**
     * 通知字段 0未通知 1通知了
     */
    private Long noticeFlag;
    /**
     * app代理ids
     */
    private String appParentIds;
    /**
     * 后台代理ids
     */
    private String adminParentIds;

}
