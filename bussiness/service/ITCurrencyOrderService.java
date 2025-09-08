package com.ruoyi.bussiness.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.ruoyi.bussiness.domain.TCurrencyOrder;

/**
 * 币币交易订单Service接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface ITCurrencyOrderService extends IService<TCurrencyOrder>
{
    /**
     * 查询币币交易订单
     * 
     * @param id 币币交易订单主键
     * @return 币币交易订单
     */
    public TCurrencyOrder selectTCurrencyOrderById(Long id);

    /**
     * 查询币币交易订单列表
     * 
     * @param tCurrencyOrder 币币交易订单
     * @return 币币交易订单集合
     */
    public List<TCurrencyOrder> selectTCurrencyOrderList(TCurrencyOrder tCurrencyOrder);

    /**
     * 新增币币交易订单
     * 
     * @param tCurrencyOrder 币币交易订单
     * @return 结果
     */
    public int insertTCurrencyOrder(TCurrencyOrder tCurrencyOrder);

    /**
     * 修改币币交易订单
     * 
     * @param tCurrencyOrder 币币交易订单
     * @return 结果
     */
    public int updateTCurrencyOrder(TCurrencyOrder tCurrencyOrder);

    /**
     * 批量删除币币交易订单
     * 
     * @param ids 需要删除的币币交易订单主键集合
     * @return 结果
     */
    public int deleteTCurrencyOrderByIds(Long[] ids);

    /**
     * 删除币币交易订单信息
     * 
     * @param id 币币交易订单主键
     * @return 结果
     */
    public int deleteTCurrencyOrderById(Long id);
}
