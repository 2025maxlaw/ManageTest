package com.ruoyi.bussiness.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bussiness.mapper.TAppAssetRebateMapper;
import com.ruoyi.bussiness.domain.TAppAssetRebate;
import com.ruoyi.bussiness.service.ITAppAssetRebateService;

/**
 * 用户资产返佣Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TAppAssetRebateServiceImpl extends ServiceImpl<TAppAssetRebateMapper,TAppAssetRebate> implements ITAppAssetRebateService
{
    @Autowired
    private TAppAssetRebateMapper tAppAssetRebateMapper;

    /**
     * 查询用户资产返佣
     * 
     * @param id 用户资产返佣主键
     * @return 用户资产返佣
     */
    @Override
    public TAppAssetRebate selectTAppAssetRebateById(Long id)
    {
        return tAppAssetRebateMapper.selectTAppAssetRebateById(id);
    }

    /**
     * 查询用户资产返佣列表
     * 
     * @param tAppAssetRebate 用户资产返佣
     * @return 用户资产返佣
     */
    @Override
    public List<TAppAssetRebate> selectTAppAssetRebateList(TAppAssetRebate tAppAssetRebate)
    {
        return tAppAssetRebateMapper.selectTAppAssetRebateList(tAppAssetRebate);
    }

    /**
     * 新增用户资产返佣
     * 
     * @param tAppAssetRebate 用户资产返佣
     * @return 结果
     */
    @Override
    public int insertTAppAssetRebate(TAppAssetRebate tAppAssetRebate)
    {
        tAppAssetRebate.setCreateTime(DateUtils.getNowDate());
        return tAppAssetRebateMapper.insertTAppAssetRebate(tAppAssetRebate);
    }

    /**
     * 修改用户资产返佣
     * 
     * @param tAppAssetRebate 用户资产返佣
     * @return 结果
     */
    @Override
    public int updateTAppAssetRebate(TAppAssetRebate tAppAssetRebate)
    {
        tAppAssetRebate.setUpdateTime(DateUtils.getNowDate());
        return tAppAssetRebateMapper.updateTAppAssetRebate(tAppAssetRebate);
    }

    /**
     * 批量删除用户资产返佣
     * 
     * @param ids 需要删除的用户资产返佣主键
     * @return 结果
     */
    @Override
    public int deleteTAppAssetRebateByIds(Long[] ids)
    {
        return tAppAssetRebateMapper.deleteTAppAssetRebateByIds(ids);
    }

    /**
     * 删除用户资产返佣信息
     * 
     * @param id 用户资产返佣主键
     * @return 结果
     */
    @Override
    public int deleteTAppAssetRebateById(Long id)
    {
        return tAppAssetRebateMapper.deleteTAppAssetRebateById(id);
    }
}
