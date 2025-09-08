package com.ruoyi.bussiness.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bussiness.mapper.TLoadOrderMapper;
import com.ruoyi.bussiness.domain.TLoadOrder;
import com.ruoyi.bussiness.service.ITLoadOrderService;

/**
 * 贷款订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TLoadOrderServiceImpl extends ServiceImpl<TLoadOrderMapper,TLoadOrder> implements ITLoadOrderService
{
    @Autowired
    private TLoadOrderMapper tLoadOrderMapper;

    /**
     * 查询贷款订单
     * 
     * @param id 贷款订单主键
     * @return 贷款订单
     */
    @Override
    public TLoadOrder selectTLoadOrderById(Long id)
    {
        return tLoadOrderMapper.selectTLoadOrderById(id);
    }

    /**
     * 查询贷款订单列表
     * 
     * @param tLoadOrder 贷款订单
     * @return 贷款订单
     */
    @Override
    public List<TLoadOrder> selectTLoadOrderList(TLoadOrder tLoadOrder)
    {
        return tLoadOrderMapper.selectTLoadOrderList(tLoadOrder);
    }

    /**
     * 新增贷款订单
     * 
     * @param tLoadOrder 贷款订单
     * @return 结果
     */
    @Override
    public int insertTLoadOrder(TLoadOrder tLoadOrder)
    {
        tLoadOrder.setCreateTime(DateUtils.getNowDate());
        return tLoadOrderMapper.insertTLoadOrder(tLoadOrder);
    }

    /**
     * 修改贷款订单
     * 
     * @param tLoadOrder 贷款订单
     * @return 结果
     */
    @Override
    public int updateTLoadOrder(TLoadOrder tLoadOrder)
    {
        tLoadOrder.setUpdateTime(DateUtils.getNowDate());
        return tLoadOrderMapper.updateTLoadOrder(tLoadOrder);
    }

    /**
     * 批量删除贷款订单
     * 
     * @param ids 需要删除的贷款订单主键
     * @return 结果
     */
    @Override
    public int deleteTLoadOrderByIds(Long[] ids)
    {
        return tLoadOrderMapper.deleteTLoadOrderByIds(ids);
    }

    /**
     * 删除贷款订单信息
     * 
     * @param id 贷款订单主键
     * @return 结果
     */
    @Override
    public int deleteTLoadOrderById(Long id)
    {
        return tLoadOrderMapper.deleteTLoadOrderById(id);
    }
}
