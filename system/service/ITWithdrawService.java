package com.ruoyi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.ruoyi.system.domain.TWithdraw;

/**
 * 用户提现Service接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface ITWithdrawService extends IService<TWithdraw>
{
    /**
     * 查询用户提现
     * 
     * @param id 用户提现主键
     * @return 用户提现
     */
    public TWithdraw selectTWithdrawById(Long id);

    /**
     * 查询用户提现列表
     * 
     * @param tWithdraw 用户提现
     * @return 用户提现集合
     */
    public List<TWithdraw> selectTWithdrawList(TWithdraw tWithdraw);

    /**
     * 新增用户提现
     * 
     * @param tWithdraw 用户提现
     * @return 结果
     */
    public int insertTWithdraw(TWithdraw tWithdraw);

    /**
     * 修改用户提现
     * 
     * @param tWithdraw 用户提现
     * @return 结果
     */
    public int updateTWithdraw(TWithdraw tWithdraw);

    /**
     * 批量删除用户提现
     * 
     * @param ids 需要删除的用户提现主键集合
     * @return 结果
     */
    public int deleteTWithdrawByIds(Long[] ids);

    /**
     * 删除用户提现信息
     * 
     * @param id 用户提现主键
     * @return 结果
     */
    public int deleteTWithdrawById(Long id);
}
