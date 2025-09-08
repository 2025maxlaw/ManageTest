package com.ruoyi.bussiness.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.ruoyi.bussiness.domain.TMingOrder;

/**
 * mingService接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface ITMingOrderService extends IService<TMingOrder>
{
    /**
     * 查询ming
     * 
     * @param id ming主键
     * @return ming
     */
    public TMingOrder selectTMingOrderById(Long id);

    /**
     * 查询ming列表
     * 
     * @param tMingOrder ming
     * @return ming集合
     */
    public List<TMingOrder> selectTMingOrderList(TMingOrder tMingOrder);

    /**
     * 新增ming
     * 
     * @param tMingOrder ming
     * @return 结果
     */
    public int insertTMingOrder(TMingOrder tMingOrder);

    /**
     * 修改ming
     * 
     * @param tMingOrder ming
     * @return 结果
     */
    public int updateTMingOrder(TMingOrder tMingOrder);

    /**
     * 批量删除ming
     * 
     * @param ids 需要删除的ming主键集合
     * @return 结果
     */
    public int deleteTMingOrderByIds(Long[] ids);

    /**
     * 删除ming信息
     * 
     * @param id ming主键
     * @return 结果
     */
    public int deleteTMingOrderById(Long id);
}
