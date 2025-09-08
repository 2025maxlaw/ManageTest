package com.ruoyi.bussiness.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bussiness.mapper.TSecondContractOrderMapper;
import com.ruoyi.bussiness.domain.TSecondContractOrder;
import com.ruoyi.bussiness.service.ITSecondContractOrderService;

/**
 * 秒合约订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TSecondContractOrderServiceImpl extends ServiceImpl<TSecondContractOrderMapper,TSecondContractOrder> implements ITSecondContractOrderService
{
    @Autowired
    private TSecondContractOrderMapper tSecondContractOrderMapper;

    /**
     * 查询秒合约订单
     * 
     * @param id 秒合约订单主键
     * @return 秒合约订单
     */
    @Override
    public TSecondContractOrder selectTSecondContractOrderById(Long id)
    {
        return tSecondContractOrderMapper.selectTSecondContractOrderById(id);
    }

    /**
     * 查询秒合约订单列表
     * 
     * @param tSecondContractOrder 秒合约订单
     * @return 秒合约订单
     */
    @Override
    public List<TSecondContractOrder> selectTSecondContractOrderList(TSecondContractOrder tSecondContractOrder)
    {
        return tSecondContractOrderMapper.selectTSecondContractOrderList(tSecondContractOrder);
    }

    /**
     * 新增秒合约订单
     * 
     * @param tSecondContractOrder 秒合约订单
     * @return 结果
     */
    @Override
    public int insertTSecondContractOrder(TSecondContractOrder tSecondContractOrder)
    {
        tSecondContractOrder.setCreateTime(DateUtils.getNowDate());
        return tSecondContractOrderMapper.insertTSecondContractOrder(tSecondContractOrder);
    }

    /**
     * 修改秒合约订单
     * 
     * @param tSecondContractOrder 秒合约订单
     * @return 结果
     */
    @Override
    public int updateTSecondContractOrder(TSecondContractOrder tSecondContractOrder)
    {
        return tSecondContractOrderMapper.updateTSecondContractOrder(tSecondContractOrder);
    }

    /**
     * 批量删除秒合约订单
     * 
     * @param ids 需要删除的秒合约订单主键
     * @return 结果
     */
    @Override
    public int deleteTSecondContractOrderByIds(Long[] ids)
    {
        return tSecondContractOrderMapper.deleteTSecondContractOrderByIds(ids);
    }

    /**
     * 删除秒合约订单信息
     * 
     * @param id 秒合约订单主键
     * @return 结果
     */
    @Override
    public int deleteTSecondContractOrderById(Long id)
    {
        return tSecondContractOrderMapper.deleteTSecondContractOrderById(id);
    }
}
