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
 * 用户资产返佣对象 t_app_asset_rebate
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_app_asset_rebate")
public class TAppAssetRebate extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
        @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * $column.columnComment
     */
    private Long userId;
    /**
     * 地址
     */
    private String adress;
    /**
     * 币种
     */
    private String symbol;
    /**
     * 资产总额
     */
    private BigDecimal amout;
    /**
     * 返佣金额
     */
    private BigDecimal rebateAmout;
    /**
     * 返佣利率
     */
    private BigDecimal rebateRate;
    /**
     * 资产类型 1=平台资产 2=理财资产 3=合约账户
     */
    private String type;
    /**
     * $column.columnComment
     */
    private String searchValue;

}
