package com.ruoyi.bussiness.domain;

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
 * ming对象 t_ming_order
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_ming_order")
public class TMingOrder extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * $column.columnComment
     */
        @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 投资金额（分）
     */
    private BigDecimal amount;
    /**
     * 投资期限（天）
     */
    private Long days;
    /**
     * 0 收益  1 结算
     */
    private Long status;
    /**
     * 项目id
     */
    private Long planId;
    /**
     * 项目名称
     */
    private String planTitle;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 到期时间
     */
    private Date endTime;
    /**
     * 结算时间
     */
    private Date settleTime;
    /**
     * 累计收益
     */
    private BigDecimal accumulaEarn;
    /**
     * 最小利率
     */
    private BigDecimal minOdds;
    /**
     * 最大利率
     */
    private BigDecimal maxOdds;
    /**
     * 后台用户id
     */
    private String adminUserIds;
    /**
     * $column.columnComment
     */
    private String collectionOrder;
    /**
     * $column.columnComment
     */
    private Long userId;
    /**
     * $column.columnComment
     */
    private BigDecimal orderAmount;

}
