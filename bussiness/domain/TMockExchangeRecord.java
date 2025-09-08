package com.ruoyi.bussiness.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 账户切换记录对象 t_mock_exchange_record
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_mock_exchange_record")
public class TMockExchangeRecord extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 操作用户ID
     */
    private Long userId;
    /**
     * 真实用户ID
     */
    private Long realId;
    /**
     * 模拟用户ID
     */
    private Long mockId;
    /**
     * 0:真实切换模拟 1:模拟切换真实
     */
    private Long type;
    /**
     * 上级后台用户IDS
     */
    private String adminParentIds;

}
