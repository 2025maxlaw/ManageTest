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
 * 划转记录对象 t_asset_trans_funds
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_asset_trans_funds")
public class TAssetTransFunds extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
        @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 转出账户
     */
    private Integer outAccount;
    /**
     * 转出币种
     */
    private String outCoin;
    /**
     * 转入账户
     */
    private Integer inAccount;
    /**
     * 转入币种
     */
    private String inCoin;
    /**
     * 划转金额
     */
    private BigDecimal amount;

}
