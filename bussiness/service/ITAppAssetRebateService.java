package com.ruoyi.bussiness.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.ruoyi.bussiness.domain.TAppAssetRebate;

/**
 * 用户资产返佣Service接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface ITAppAssetRebateService extends IService<TAppAssetRebate>
{
    /**
     * 查询用户资产返佣
     * 
     * @param id 用户资产返佣主键
     * @return 用户资产返佣
     */
    public TAppAssetRebate selectTAppAssetRebateById(Long id);

    /**
     * 查询用户资产返佣列表
     * 
     * @param tAppAssetRebate 用户资产返佣
     * @return 用户资产返佣集合
     */
    public List<TAppAssetRebate> selectTAppAssetRebateList(TAppAssetRebate tAppAssetRebate);

    /**
     * 新增用户资产返佣
     * 
     * @param tAppAssetRebate 用户资产返佣
     * @return 结果
     */
    public int insertTAppAssetRebate(TAppAssetRebate tAppAssetRebate);

    /**
     * 修改用户资产返佣
     * 
     * @param tAppAssetRebate 用户资产返佣
     * @return 结果
     */
    public int updateTAppAssetRebate(TAppAssetRebate tAppAssetRebate);

    /**
     * 批量删除用户资产返佣
     * 
     * @param ids 需要删除的用户资产返佣主键集合
     * @return 结果
     */
    public int deleteTAppAssetRebateByIds(Long[] ids);

    /**
     * 删除用户资产返佣信息
     * 
     * @param id 用户资产返佣主键
     * @return 结果
     */
    public int deleteTAppAssetRebateById(Long id);
}
