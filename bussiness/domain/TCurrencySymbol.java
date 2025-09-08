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
 * 币币交易币种配置对象 t_currency_symbol
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_currency_symbol")
public class TCurrencySymbol extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
        @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 交易对
     */
    private String pairTrading;
    /**
     * 交易币种
     */
    private String symbol;
    /**
     * 结算币种
     */
    private String coin;
    /**
     * 手续费率
     */
    private BigDecimal feeRate;
    /**
     * 交易币种精度
     */
    private Long symbolPrecision;
    /**
     * 结算币种精度
     */
    private Long coinPrecision;
    /**
     * 最低卖单价
     */
    private BigDecimal sellMin;
    /**
     * 最高买单价
     */
    private BigDecimal buyMax;
    /**
     * 最小下单量
     */
    private Long orderMin;
    /**
     * 最大下单量
     */
    private Long orderMax;
    /**
     * 启用禁用  1=启用 2=禁用
     */
    private String enable;
    /**
     * 前端是否显示 1=显示  2=隐藏
     */
    private String isShow;
    /**
     * 是否可交易 1=是 2=否
     */
    private String isDeal;
    /**
     * 市价买 1=可以 2=不可以
     */
    private String marketBuy;
    /**
     * 市价卖 1=可以 2=不可以
     */
    private String marketSell;
    /**
     * 限价买 1=可以 2=不可以
     */
    private String limitedBuy;
    /**
     * 限价卖 1=可以 2=不可以
     */
    private String limitedSell;
    /**
     * $column.columnComment
     */
    private Date createDate;
    /**
     * $column.columnComment
     */
    private Date updateDate;
    /**
     * $column.columnComment
     */
    private String searchValue;

}
