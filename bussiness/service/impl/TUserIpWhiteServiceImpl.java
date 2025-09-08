package com.ruoyi.bussiness.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bussiness.mapper.TUserIpWhiteMapper;
import com.ruoyi.bussiness.domain.TUserIpWhite;
import com.ruoyi.bussiness.service.ITUserIpWhiteService;

/**
 * 客户端登录IP白名单Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TUserIpWhiteServiceImpl extends ServiceImpl<TUserIpWhiteMapper,TUserIpWhite> implements ITUserIpWhiteService
{
    @Autowired
    private TUserIpWhiteMapper tUserIpWhiteMapper;

    /**
     * 查询客户端登录IP白名单
     * 
     * @param id 客户端登录IP白名单主键
     * @return 客户端登录IP白名单
     */
    @Override
    public TUserIpWhite selectTUserIpWhiteById(Long id)
    {
        return tUserIpWhiteMapper.selectTUserIpWhiteById(id);
    }

    /**
     * 查询客户端登录IP白名单列表
     * 
     * @param tUserIpWhite 客户端登录IP白名单
     * @return 客户端登录IP白名单
     */
    @Override
    public List<TUserIpWhite> selectTUserIpWhiteList(TUserIpWhite tUserIpWhite)
    {
        return tUserIpWhiteMapper.selectTUserIpWhiteList(tUserIpWhite);
    }

    /**
     * 新增客户端登录IP白名单
     * 
     * @param tUserIpWhite 客户端登录IP白名单
     * @return 结果
     */
    @Override
    public int insertTUserIpWhite(TUserIpWhite tUserIpWhite)
    {
        tUserIpWhite.setCreateTime(DateUtils.getNowDate());
        return tUserIpWhiteMapper.insertTUserIpWhite(tUserIpWhite);
    }

    /**
     * 修改客户端登录IP白名单
     * 
     * @param tUserIpWhite 客户端登录IP白名单
     * @return 结果
     */
    @Override
    public int updateTUserIpWhite(TUserIpWhite tUserIpWhite)
    {
        tUserIpWhite.setUpdateTime(DateUtils.getNowDate());
        return tUserIpWhiteMapper.updateTUserIpWhite(tUserIpWhite);
    }

    /**
     * 批量删除客户端登录IP白名单
     * 
     * @param ids 需要删除的客户端登录IP白名单主键
     * @return 结果
     */
    @Override
    public int deleteTUserIpWhiteByIds(Long[] ids)
    {
        return tUserIpWhiteMapper.deleteTUserIpWhiteByIds(ids);
    }

    /**
     * 删除客户端登录IP白名单信息
     * 
     * @param id 客户端登录IP白名单主键
     * @return 结果
     */
    @Override
    public int deleteTUserIpWhiteById(Long id)
    {
        return tUserIpWhiteMapper.deleteTUserIpWhiteById(id);
    }
}
