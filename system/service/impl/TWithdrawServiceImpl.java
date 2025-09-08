package com.ruoyi.system.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TWithdrawMapper;
import com.ruoyi.system.domain.TWithdraw;
import com.ruoyi.system.service.ITWithdrawService;

/**
 * 用户提现Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TWithdrawServiceImpl extends ServiceImpl<TWithdrawMapper,TWithdraw> implements ITWithdrawService
{
    @Autowired
    private TWithdrawMapper tWithdrawMapper;

    /**
     * 查询用户提现
     * 
     * @param id 用户提现主键
     * @return 用户提现
     */
    @Override
    public TWithdraw selectTWithdrawById(Long id)
    {
        return tWithdrawMapper.selectTWithdrawById(id);
    }

    /**
     * 查询用户提现列表
     * 
     * @param tWithdraw 用户提现
     * @return 用户提现
     */
    @Override
    public List<TWithdraw> selectTWithdrawList(TWithdraw tWithdraw)
    {
        return tWithdrawMapper.selectTWithdrawList(tWithdraw);
    }

    /**
     * 新增用户提现
     * 
     * @param tWithdraw 用户提现
     * @return 结果
     */
    @Override
    public int insertTWithdraw(TWithdraw tWithdraw)
    {
        tWithdraw.setCreateTime(DateUtils.getNowDate());
        return tWithdrawMapper.insertTWithdraw(tWithdraw);
    }

    /**
     * 修改用户提现
     * 
     * @param tWithdraw 用户提现
     * @return 结果
     */
    @Override
    public int updateTWithdraw(TWithdraw tWithdraw)
    {
        tWithdraw.setUpdateTime(DateUtils.getNowDate());
        return tWithdrawMapper.updateTWithdraw(tWithdraw);
    }

    /**
     * 批量删除用户提现
     * 
     * @param ids 需要删除的用户提现主键
     * @return 结果
     */
    @Override
    public int deleteTWithdrawByIds(Long[] ids)
    {
        return tWithdrawMapper.deleteTWithdrawByIds(ids);
    }

    /**
     * 删除用户提现信息
     * 
     * @param id 用户提现主键
     * @return 结果
     */
    @Override
    public int deleteTWithdrawById(Long id)
    {
        return tWithdrawMapper.deleteTWithdrawById(id);
    }
}
