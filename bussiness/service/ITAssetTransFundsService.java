package com.ruoyi.bussiness.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.ruoyi.bussiness.domain.TAssetTransFunds;

/**
 * 划转记录Service接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface ITAssetTransFundsService extends IService<TAssetTransFunds>
{
    /**
     * 查询划转记录
     * 
     * @param id 划转记录主键
     * @return 划转记录
     */
    public TAssetTransFunds selectTAssetTransFundsById(Long id);

    /**
     * 查询划转记录列表
     * 
     * @param tAssetTransFunds 划转记录
     * @return 划转记录集合
     */
    public List<TAssetTransFunds> selectTAssetTransFundsList(TAssetTransFunds tAssetTransFunds);

    /**
     * 新增划转记录
     * 
     * @param tAssetTransFunds 划转记录
     * @return 结果
     */
    public int insertTAssetTransFunds(TAssetTransFunds tAssetTransFunds);

    /**
     * 修改划转记录
     * 
     * @param tAssetTransFunds 划转记录
     * @return 结果
     */
    public int updateTAssetTransFunds(TAssetTransFunds tAssetTransFunds);

    /**
     * 批量删除划转记录
     * 
     * @param ids 需要删除的划转记录主键集合
     * @return 结果
     */
    public int deleteTAssetTransFundsByIds(Long[] ids);

    /**
     * 删除划转记录信息
     * 
     * @param id 划转记录主键
     * @return 结果
     */
    public int deleteTAssetTransFundsById(Long id);
}
