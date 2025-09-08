package com.ruoyi.bussiness.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bussiness.mapper.TCurrencyOrderMapper;
import com.ruoyi.bussiness.domain.TCurrencyOrder;
import com.ruoyi.bussiness.service.ITCurrencyOrderService;

/**
 * 币币交易订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TCurrencyOrderServiceImpl extends ServiceImpl<TCurrencyOrderMapper,TCurrencyOrder> implements ITCurrencyOrderService
{
    @Autowired
    private TCurrencyOrderMapper tCurrencyOrderMapper;

    /**
     * 查询币币交易订单
     * 
     * @param id 币币交易订单主键
     * @return 币币交易订单
     */
    @Override
    public TCurrencyOrder selectTCurrencyOrderById(Long id)
    {
        return tCurrencyOrderMapper.selectTCurrencyOrderById(id);
    }

    /**
     * 查询币币交易订单列表
     * 
     * @param tCurrencyOrder 币币交易订单
     * @return 币币交易订单
     */
    @Override
    public List<TCurrencyOrder> selectTCurrencyOrderList(TCurrencyOrder tCurrencyOrder)
    {
        return tCurrencyOrderMapper.selectTCurrencyOrderList(tCurrencyOrder);
    }

    /**
     * 新增币币交易订单
     * 
     * @param tCurrencyOrder 币币交易订单
     * @return 结果
     */
    @Override
    public int insertTCurrencyOrder(TCurrencyOrder tCurrencyOrder)
    {
        tCurrencyOrder.setCreateTime(DateUtils.getNowDate());
        return tCurrencyOrderMapper.insertTCurrencyOrder(tCurrencyOrder);
    }

    /**
     * 修改币币交易订单
     * 
     * @param tCurrencyOrder 币币交易订单
     * @return 结果
     */
    @Override
    public int updateTCurrencyOrder(TCurrencyOrder tCurrencyOrder)
    {
        tCurrencyOrder.setUpdateTime(DateUtils.getNowDate());
        return tCurrencyOrderMapper.updateTCurrencyOrder(tCurrencyOrder);
    }

    /**
     * 批量删除币币交易订单
     * 
     * @param ids 需要删除的币币交易订单主键
     * @return 结果
     */
    @Override
    public int deleteTCurrencyOrderByIds(Long[] ids)
    {
        return tCurrencyOrderMapper.deleteTCurrencyOrderByIds(ids);
    }

    /**
     * 删除币币交易订单信息
     * 
     * @param id 币币交易订单主键
     * @return 结果
     */
    @Override
    public int deleteTCurrencyOrderById(Long id)
    {
        return tCurrencyOrderMapper.deleteTCurrencyOrderById(id);
    }
}
