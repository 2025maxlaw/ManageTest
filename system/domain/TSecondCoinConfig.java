package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 秒合约币种配置对象 t_second_coin_config
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_second_coin_config")
public class TSecondCoinConfig extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * id
     */
        @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 合约交易对
     */
    private String symbol;
    /**
     * 是否启用 2关闭 1启用
     */
    private Long status;
    /**
     * 是否展示 2不展示 1展示
     */
    private Long showFlag;
    /**
     * 币种
     */
    private String coin;
    /**
     * 排序
     */
    private Long sort;
    /**
     * $column.columnComment
     */
    private String searchValue;

}
