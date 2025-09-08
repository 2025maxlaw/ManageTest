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
 * mingProduct对象 t_ming_product
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_ming_product")
public class TMingProduct extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * $column.columnComment
     */
        @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 图标
     */
    private String icon;
    /**
     * 启用禁用(展示在前端)1开0关
     */
    private Long status;
    /**
     * 天数(如 7,10,30)
     */
    private String days;
    /**
     * 违约利率
     */
    private BigDecimal defaultOdds;
    /**
     * 最小日利率百分比
     */
    private BigDecimal minOdds;
    /**
     * 最大日利率百分比
     */
    private BigDecimal maxOdds;
    /**
     * 每人限购次数，0表示不限
     */
    private Long timeLimit;
    /**
     * 最小金额
     */
    private BigDecimal limitMin;
    /**
     * 最大金额
     */
    private BigDecimal limitMax;
    /**
     * 排序
     */
    private Long sort;
    /**
     *  购买次数
     */
    private Long buyPurchase;
    /**
     * 币种 
     */
    private String coin;

}
