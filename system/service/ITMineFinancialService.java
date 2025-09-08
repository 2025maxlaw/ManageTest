package com.ruoyi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.ruoyi.system.domain.TMineFinancial;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface ITMineFinancialService extends IService<TMineFinancial>
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TMineFinancial selectTMineFinancialById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tMineFinancial 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TMineFinancial> selectTMineFinancialList(TMineFinancial tMineFinancial);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tMineFinancial 【请填写功能名称】
     * @return 结果
     */
    public int insertTMineFinancial(TMineFinancial tMineFinancial);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tMineFinancial 【请填写功能名称】
     * @return 结果
     */
    public int updateTMineFinancial(TMineFinancial tMineFinancial);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteTMineFinancialByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTMineFinancialById(Long id);
}
