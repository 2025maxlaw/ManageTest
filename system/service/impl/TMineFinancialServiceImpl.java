package com.ruoyi.system.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMineFinancialMapper;
import com.ruoyi.system.domain.TMineFinancial;
import com.ruoyi.system.service.ITMineFinancialService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TMineFinancialServiceImpl extends ServiceImpl<TMineFinancialMapper,TMineFinancial> implements ITMineFinancialService
{
    @Autowired
    private TMineFinancialMapper tMineFinancialMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TMineFinancial selectTMineFinancialById(Long id)
    {
        return tMineFinancialMapper.selectTMineFinancialById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tMineFinancial 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TMineFinancial> selectTMineFinancialList(TMineFinancial tMineFinancial)
    {
        return tMineFinancialMapper.selectTMineFinancialList(tMineFinancial);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tMineFinancial 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTMineFinancial(TMineFinancial tMineFinancial)
    {
        tMineFinancial.setCreateTime(DateUtils.getNowDate());
        return tMineFinancialMapper.insertTMineFinancial(tMineFinancial);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tMineFinancial 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTMineFinancial(TMineFinancial tMineFinancial)
    {
        tMineFinancial.setUpdateTime(DateUtils.getNowDate());
        return tMineFinancialMapper.updateTMineFinancial(tMineFinancial);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTMineFinancialByIds(Long[] ids)
    {
        return tMineFinancialMapper.deleteTMineFinancialByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTMineFinancialById(Long id)
    {
        return tMineFinancialMapper.deleteTMineFinancialById(id);
    }
}
