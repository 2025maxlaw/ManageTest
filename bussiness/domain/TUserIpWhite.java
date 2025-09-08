package com.ruoyi.bussiness.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户端登录IP白名单对象 t_user_ip_white
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_user_ip_white")
public class TUserIpWhite extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
        @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 用户ID
     */
    private Long uid;
    /**
     * IP地址
     */
    private String ip;

}
