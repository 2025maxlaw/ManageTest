package com.ruoyi.bussiness.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bussiness.mapper.TUserSymbolAddressMapper;
import com.ruoyi.bussiness.domain.TUserSymbolAddress;
import com.ruoyi.bussiness.service.ITUserSymbolAddressService;

/**
 * 用户币种充值地址Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TUserSymbolAddressServiceImpl extends ServiceImpl<TUserSymbolAddressMapper,TUserSymbolAddress> implements ITUserSymbolAddressService
{
    @Autowired
    private TUserSymbolAddressMapper tUserSymbolAddressMapper;

    /**
     * 查询用户币种充值地址
     * 
     * @param id 用户币种充值地址主键
     * @return 用户币种充值地址
     */
    @Override
    public TUserSymbolAddress selectTUserSymbolAddressById(Long id)
    {
        return tUserSymbolAddressMapper.selectTUserSymbolAddressById(id);
    }

    /**
     * 查询用户币种充值地址列表
     * 
     * @param tUserSymbolAddress 用户币种充值地址
     * @return 用户币种充值地址
     */
    @Override
    public List<TUserSymbolAddress> selectTUserSymbolAddressList(TUserSymbolAddress tUserSymbolAddress)
    {
        return tUserSymbolAddressMapper.selectTUserSymbolAddressList(tUserSymbolAddress);
    }

    /**
     * 新增用户币种充值地址
     * 
     * @param tUserSymbolAddress 用户币种充值地址
     * @return 结果
     */
    @Override
    public int insertTUserSymbolAddress(TUserSymbolAddress tUserSymbolAddress)
    {
        return tUserSymbolAddressMapper.insertTUserSymbolAddress(tUserSymbolAddress);
    }

    /**
     * 修改用户币种充值地址
     * 
     * @param tUserSymbolAddress 用户币种充值地址
     * @return 结果
     */
    @Override
    public int updateTUserSymbolAddress(TUserSymbolAddress tUserSymbolAddress)
    {
        return tUserSymbolAddressMapper.updateTUserSymbolAddress(tUserSymbolAddress);
    }

    /**
     * 批量删除用户币种充值地址
     * 
     * @param ids 需要删除的用户币种充值地址主键
     * @return 结果
     */
    @Override
    public int deleteTUserSymbolAddressByIds(Long[] ids)
    {
        return tUserSymbolAddressMapper.deleteTUserSymbolAddressByIds(ids);
    }

    /**
     * 删除用户币种充值地址信息
     * 
     * @param id 用户币种充值地址主键
     * @return 结果
     */
    @Override
    public int deleteTUserSymbolAddressById(Long id)
    {
        return tUserSymbolAddressMapper.deleteTUserSymbolAddressById(id);
    }
}
