package com.ruoyi.bussiness.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bussiness.mapper.TAssetTransFundsMapper;
import com.ruoyi.bussiness.domain.TAssetTransFunds;
import com.ruoyi.bussiness.service.ITAssetTransFundsService;

/**
 * 划转记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TAssetTransFundsServiceImpl extends ServiceImpl<TAssetTransFundsMapper,TAssetTransFunds> implements ITAssetTransFundsService
{
    @Autowired
    private TAssetTransFundsMapper tAssetTransFundsMapper;

    /**
     * 查询划转记录
     * 
     * @param id 划转记录主键
     * @return 划转记录
     */
    @Override
    public TAssetTransFunds selectTAssetTransFundsById(Long id)
    {
        return tAssetTransFundsMapper.selectTAssetTransFundsById(id);
    }

    /**
     * 查询划转记录列表
     * 
     * @param tAssetTransFunds 划转记录
     * @return 划转记录
     */
    @Override
    public List<TAssetTransFunds> selectTAssetTransFundsList(TAssetTransFunds tAssetTransFunds)
    {
        return tAssetTransFundsMapper.selectTAssetTransFundsList(tAssetTransFunds);
    }

    /**
     * 新增划转记录
     * 
     * @param tAssetTransFunds 划转记录
     * @return 结果
     */
    @Override
    public int insertTAssetTransFunds(TAssetTransFunds tAssetTransFunds)
    {
        tAssetTransFunds.setCreateTime(DateUtils.getNowDate());
        return tAssetTransFundsMapper.insertTAssetTransFunds(tAssetTransFunds);
    }

    /**
     * 修改划转记录
     * 
     * @param tAssetTransFunds 划转记录
     * @return 结果
     */
    @Override
    public int updateTAssetTransFunds(TAssetTransFunds tAssetTransFunds)
    {
        tAssetTransFunds.setUpdateTime(DateUtils.getNowDate());
        return tAssetTransFundsMapper.updateTAssetTransFunds(tAssetTransFunds);
    }

    /**
     * 批量删除划转记录
     * 
     * @param ids 需要删除的划转记录主键
     * @return 结果
     */
    @Override
    public int deleteTAssetTransFundsByIds(Long[] ids)
    {
        return tAssetTransFundsMapper.deleteTAssetTransFundsByIds(ids);
    }

    /**
     * 删除划转记录信息
     * 
     * @param id 划转记录主键
     * @return 结果
     */
    @Override
    public int deleteTAssetTransFundsById(Long id)
    {
        return tAssetTransFundsMapper.deleteTAssetTransFundsById(id);
    }
}
