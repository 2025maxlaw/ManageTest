package com.ruoyi.system.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TAppUserDetailMapper;
import com.ruoyi.system.domain.TAppUserDetail;
import com.ruoyi.system.service.ITAppUserDetailService;

/**
 * 用户详细信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TAppUserDetailServiceImpl extends ServiceImpl<TAppUserDetailMapper,TAppUserDetail> implements ITAppUserDetailService
{
    @Autowired
    private TAppUserDetailMapper tAppUserDetailMapper;

    /**
     * 查询用户详细信息
     * 
     * @param id 用户详细信息主键
     * @return 用户详细信息
     */
    @Override
    public TAppUserDetail selectTAppUserDetailById(Long id)
    {
        return tAppUserDetailMapper.selectTAppUserDetailById(id);
    }

    /**
     * 查询用户详细信息列表
     * 
     * @param tAppUserDetail 用户详细信息
     * @return 用户详细信息
     */
    @Override
    public List<TAppUserDetail> selectTAppUserDetailList(TAppUserDetail tAppUserDetail)
    {
        return tAppUserDetailMapper.selectTAppUserDetailList(tAppUserDetail);
    }

    /**
     * 新增用户详细信息
     * 
     * @param tAppUserDetail 用户详细信息
     * @return 结果
     */
    @Override
    public int insertTAppUserDetail(TAppUserDetail tAppUserDetail)
    {
        tAppUserDetail.setCreateTime(DateUtils.getNowDate());
        return tAppUserDetailMapper.insertTAppUserDetail(tAppUserDetail);
    }

    /**
     * 修改用户详细信息
     * 
     * @param tAppUserDetail 用户详细信息
     * @return 结果
     */
    @Override
    public int updateTAppUserDetail(TAppUserDetail tAppUserDetail)
    {
        tAppUserDetail.setUpdateTime(DateUtils.getNowDate());
        return tAppUserDetailMapper.updateTAppUserDetail(tAppUserDetail);
    }

    /**
     * 批量删除用户详细信息
     * 
     * @param ids 需要删除的用户详细信息主键
     * @return 结果
     */
    @Override
    public int deleteTAppUserDetailByIds(Long[] ids)
    {
        return tAppUserDetailMapper.deleteTAppUserDetailByIds(ids);
    }

    /**
     * 删除用户详细信息信息
     * 
     * @param id 用户详细信息主键
     * @return 结果
     */
    @Override
    public int deleteTAppUserDetailById(Long id)
    {
        return tAppUserDetailMapper.deleteTAppUserDetailById(id);
    }
}
