package com.ruoyi.system.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TAppRechargeMapper;
import com.ruoyi.system.domain.TAppRecharge;
import com.ruoyi.system.service.ITAppRechargeService;

/**
 * 用户充值Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TAppRechargeServiceImpl extends ServiceImpl<TAppRechargeMapper,TAppRecharge> implements ITAppRechargeService
{
    @Autowired
    private TAppRechargeMapper tAppRechargeMapper;

    /**
     * 查询用户充值
     * 
     * @param id 用户充值主键
     * @return 用户充值
     */
    @Override
    public TAppRecharge selectTAppRechargeById(Long id)
    {
        return tAppRechargeMapper.selectTAppRechargeById(id);
    }

    /**
     * 查询用户充值列表
     * 
     * @param tAppRecharge 用户充值
     * @return 用户充值
     */
    @Override
    public List<TAppRecharge> selectTAppRechargeList(TAppRecharge tAppRecharge)
    {
        return tAppRechargeMapper.selectTAppRechargeList(tAppRecharge);
    }

    /**
     * 新增用户充值
     * 
     * @param tAppRecharge 用户充值
     * @return 结果
     */
    @Override
    public int insertTAppRecharge(TAppRecharge tAppRecharge)
    {
        tAppRecharge.setCreateTime(DateUtils.getNowDate());
        return tAppRechargeMapper.insertTAppRecharge(tAppRecharge);
    }

    /**
     * 修改用户充值
     * 
     * @param tAppRecharge 用户充值
     * @return 结果
     */
    @Override
    public int updateTAppRecharge(TAppRecharge tAppRecharge)
    {
        tAppRecharge.setUpdateTime(DateUtils.getNowDate());
        return tAppRechargeMapper.updateTAppRecharge(tAppRecharge);
    }

    /**
     * 批量删除用户充值
     * 
     * @param ids 需要删除的用户充值主键
     * @return 结果
     */
    @Override
    public int deleteTAppRechargeByIds(Long[] ids)
    {
        return tAppRechargeMapper.deleteTAppRechargeByIds(ids);
    }

    /**
     * 删除用户充值信息
     * 
     * @param id 用户充值主键
     * @return 结果
     */
    @Override
    public int deleteTAppRechargeById(Long id)
    {
        return tAppRechargeMapper.deleteTAppRechargeById(id);
    }
}
