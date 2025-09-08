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
 * 用户信息对象 t_app_wallet_record
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_app_wallet_record")
public class TAppWalletRecord extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * 卡ID
     */
        @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 余额
     */
    private BigDecimal amount;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * $column.columnComment
     */
    private String searchValue;
    /**
     * 前值
     */
    private BigDecimal beforeAmount;
    /**
     * 后值
     */
    private BigDecimal afterAmount;
    /**
     * $column.columnComment
     */
    private String serialId;
    /**
     * 余额
     */
    private String type;
    /**
     * 币种
     */
    private String symbol;

}
