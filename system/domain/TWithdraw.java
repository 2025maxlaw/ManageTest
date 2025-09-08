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
 * 用户提现对象 t_withdraw
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_withdraw")
public class TWithdraw extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * 卡ID
     */
        @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 用户
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户名
     */
    private String address;
    /**
     * 提现金额
     */
    private BigDecimal amount;
    /**
     * 0审核中1成功2失败
     */
    private String status;
    /**
     * $column.columnComment
     */
    private String serialId;
    /**
     * $column.columnComment
     */
    private String searchValue;
    /**
     * 用户名
     */
    private String fromAddr;
    /**
     * 0审核中1成功2失败
     */
    private String type;
    /**
     * 用户名
     */
    private String coin;
    /**
     * $column.columnComment
     */
    private Long ratio;
    /**
     * 手续费
     */
    private BigDecimal fee;
    /**
     * 用户名
     */
    private String withdrawId;
    /**
     * Host
     */
    private String host;
    /**
     * 实际金额
     */
    private BigDecimal realAmount;
    /**
     * 收款地址
     */
    private String toAdress;
    /**
     * 后台用户id
     */
    private Long adminUserId;
    /**
     * 通知字段 0未通知 1通知了
     */
    private Long noticeFlag;
    /**
     * 提现说明
     */
    private String withDrawRemark;
    /**
     * 银行名称
     */
    private String bankName;
    /**
     * 银行收款人名称
     */
    private String bankUserName;
    /**
     * $column.columnComment
     */
    private String bankBranch;

}
