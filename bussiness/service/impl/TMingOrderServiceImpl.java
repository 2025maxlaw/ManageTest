package com.ruoyi.bussiness.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bussiness.mapper.TMingOrderMapper;
import com.ruoyi.bussiness.domain.TMingOrder;
import com.ruoyi.bussiness.service.ITMingOrderService;

/**
 * mingService业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TMingOrderServiceImpl extends ServiceImpl<TMingOrderMapper,TMingOrder> implements ITMingOrderService
{
    @Autowired
    private TMingOrderMapper tMingOrderMapper;

    /**
     * 查询ming
     * 
     * @param id ming主键
     * @return ming
     */
    @Override
    public TMingOrder selectTMingOrderById(Long id)
    {
        return tMingOrderMapper.selectTMingOrderById(id);
    }

    /**
     * 查询ming列表
     * 
     * @param tMingOrder ming
     * @return ming
     */
    @Override
    public List<TMingOrder> selectTMingOrderList(TMingOrder tMingOrder)
    {
        return tMingOrderMapper.selectTMingOrderList(tMingOrder);
    }

    /**
     * 新增ming
     * 
     * @param tMingOrder ming
     * @return 结果
     */
    @Override
    public int insertTMingOrder(TMingOrder tMingOrder)
    {
        tMingOrder.setCreateTime(DateUtils.getNowDate());
        return tMingOrderMapper.insertTMingOrder(tMingOrder);
    }

    /**
     * 修改ming
     * 
     * @param tMingOrder ming
     * @return 结果
     */
    @Override
    public int updateTMingOrder(TMingOrder tMingOrder)
    {
        tMingOrder.setUpdateTime(DateUtils.getNowDate());
        return tMingOrderMapper.updateTMingOrder(tMingOrder);
    }

    /**
     * 批量删除ming
     * 
     * @param ids 需要删除的ming主键
     * @return 结果
     */
    @Override
    public int deleteTMingOrderByIds(Long[] ids)
    {
        return tMingOrderMapper.deleteTMingOrderByIds(ids);
    }

    /**
     * 删除ming信息
     * 
     * @param id ming主键
     * @return 结果
     */
    @Override
    public int deleteTMingOrderById(Long id)
    {
        return tMingOrderMapper.deleteTMingOrderById(id);
    }
}
