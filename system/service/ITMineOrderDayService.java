package com.ruoyi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.ruoyi.system.domain.TMineOrderDay;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface ITMineOrderDayService extends IService<TMineOrderDay>
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param amount 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TMineOrderDay selectTMineOrderDayByAmount(BigDecimal amount);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tMineOrderDay 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TMineOrderDay> selectTMineOrderDayList(TMineOrderDay tMineOrderDay);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tMineOrderDay 【请填写功能名称】
     * @return 结果
     */
    public int insertTMineOrderDay(TMineOrderDay tMineOrderDay);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tMineOrderDay 【请填写功能名称】
     * @return 结果
     */
    public int updateTMineOrderDay(TMineOrderDay tMineOrderDay);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param amounts 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteTMineOrderDayByAmounts(BigDecimal[] amounts);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param amount 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTMineOrderDayByAmount(BigDecimal amount);
}
