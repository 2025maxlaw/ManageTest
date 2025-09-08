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
 * 贷款订单对象 t_load_order
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_load_order")
public class TLoadOrder extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
        @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 贷款商品表id
     */
    private Long proId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 贷款金额
     */
    private BigDecimal amount;
    /**
     * 贷款利率
     */
    private BigDecimal rate;
    /**
     * 利息
     */
    private BigDecimal interest;
    /**
     * 0 进行中 1-已结清 2-已逾期 3 通过  4拒绝
     */
    private Long status;
    /**
     * 最后还款日
     */
    private Date finalRepayTime;
    /**
     * 放款日期
     */
    private Date disburseTime;
    /**
     * 还款日期
     */
    private Date returnTime;
    /**
     * 审批金额
     */
    private BigDecimal disburseAmount;
    /**
     * 后台代理ids
     */
    private String adminParentIds;
    /**
     * $column.columnComment
     */
    private String cardUrl;
    /**
     * $column.columnComment
     */
    private String cardBackUrl;
    /**
     * $column.columnComment
     */
    private String capitalUrl;
    /**
     * $column.columnComment
     */
    private String licenseUrl;
    /**
     * $column.columnComment
     */
    private String orderNo;
    /**
     * $column.columnComment
     */
    private Long cycleType;
    /**
     * $column.columnComment
     */
    private String searchValue;

}
