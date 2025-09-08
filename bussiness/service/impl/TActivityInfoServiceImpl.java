package com.ruoyi.bussiness.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bussiness.mapper.TActivityInfoMapper;
import com.ruoyi.bussiness.domain.TActivityInfo;
import com.ruoyi.bussiness.service.ITActivityInfoService;

/**
 * 侧边栏内容Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TActivityInfoServiceImpl extends ServiceImpl<TActivityInfoMapper,TActivityInfo> implements ITActivityInfoService
{
    @Autowired
    private TActivityInfoMapper tActivityInfoMapper;

    /**
     * 查询侧边栏内容
     * 
     * @param id 侧边栏内容主键
     * @return 侧边栏内容
     */
    @Override
    public TActivityInfo selectTActivityInfoById(Long id)
    {
        return tActivityInfoMapper.selectTActivityInfoById(id);
    }

    /**
     * 查询侧边栏内容列表
     * 
     * @param tActivityInfo 侧边栏内容
     * @return 侧边栏内容
     */
    @Override
    public List<TActivityInfo> selectTActivityInfoList(TActivityInfo tActivityInfo)
    {
        return tActivityInfoMapper.selectTActivityInfoList(tActivityInfo);
    }

    /**
     * 新增侧边栏内容
     * 
     * @param tActivityInfo 侧边栏内容
     * @return 结果
     */
    @Override
    public int insertTActivityInfo(TActivityInfo tActivityInfo)
    {
        tActivityInfo.setCreateTime(DateUtils.getNowDate());
        return tActivityInfoMapper.insertTActivityInfo(tActivityInfo);
    }

    /**
     * 修改侧边栏内容
     * 
     * @param tActivityInfo 侧边栏内容
     * @return 结果
     */
    @Override
    public int updateTActivityInfo(TActivityInfo tActivityInfo)
    {
        tActivityInfo.setUpdateTime(DateUtils.getNowDate());
        return tActivityInfoMapper.updateTActivityInfo(tActivityInfo);
    }

    /**
     * 批量删除侧边栏内容
     * 
     * @param ids 需要删除的侧边栏内容主键
     * @return 结果
     */
    @Override
    public int deleteTActivityInfoByIds(Long[] ids)
    {
        return tActivityInfoMapper.deleteTActivityInfoByIds(ids);
    }

    /**
     * 删除侧边栏内容信息
     * 
     * @param id 侧边栏内容主键
     * @return 结果
     */
    @Override
    public int deleteTActivityInfoById(Long id)
    {
        return tActivityInfoMapper.deleteTActivityInfoById(id);
    }
}
