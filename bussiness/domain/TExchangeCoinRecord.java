package com.ruoyi.bussiness.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import java.math.BigDecimal;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 币种兑换记录对象 t_exchange_coin_record
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_exchange_coin_record")
public class TExchangeCoinRecord extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * $column.columnComment
     */
        @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * $column.columnComment
     */
    private String fromCoin;
    /**
     * $column.columnComment
     */
    private String toCoin;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 
用户名称
     */
    private String username;
    /**
     * 用户地址
     */
    private String address;
    /**
     * 兑换状态0:已提交;1:成功;2失败
     */
    private Long status;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 三方汇率
     */
    private BigDecimal thirdRate;
    /**
     * 系统汇率
     */
    private BigDecimal systemRate;
    /**
     * $column.columnComment
     */
    private String searchValue;

}
