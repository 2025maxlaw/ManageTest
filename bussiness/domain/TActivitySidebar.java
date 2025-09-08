package com.ruoyi.bussiness.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 活动侧边栏对象 t_activity_sidebar
 *
 * @author ruoyi
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_activity_sidebar")
public class TActivitySidebar extends BaseEntity {

private static final long serialVersionUID=1L;

    /**
     * ID
     */
        @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * logo
     */
    private String logo;
    /**
     * 多语言
     */
    private String lang;
    /**
     * 排序
     */
    private Long sorted;
    /**
     * 0不展示 1展示
     */
    private Integer status;

}
