package com.ruoyi.bussiness.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bussiness.mapper.TActivitySidebarMapper;
import com.ruoyi.bussiness.domain.TActivitySidebar;
import com.ruoyi.bussiness.service.ITActivitySidebarService;

/**
 * 活动侧边栏Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TActivitySidebarServiceImpl extends ServiceImpl<TActivitySidebarMapper,TActivitySidebar> implements ITActivitySidebarService
{
    @Autowired
    private TActivitySidebarMapper tActivitySidebarMapper;

    /**
     * 查询活动侧边栏
     * 
     * @param id 活动侧边栏主键
     * @return 活动侧边栏
     */
    @Override
    public TActivitySidebar selectTActivitySidebarById(Long id)
    {
        return tActivitySidebarMapper.selectTActivitySidebarById(id);
    }

    /**
     * 查询活动侧边栏列表
     * 
     * @param tActivitySidebar 活动侧边栏
     * @return 活动侧边栏
     */
    @Override
    public List<TActivitySidebar> selectTActivitySidebarList(TActivitySidebar tActivitySidebar)
    {
        return tActivitySidebarMapper.selectTActivitySidebarList(tActivitySidebar);
    }

    /**
     * 新增活动侧边栏
     * 
     * @param tActivitySidebar 活动侧边栏
     * @return 结果
     */
    @Override
    public int insertTActivitySidebar(TActivitySidebar tActivitySidebar)
    {
        tActivitySidebar.setCreateTime(DateUtils.getNowDate());
        return tActivitySidebarMapper.insertTActivitySidebar(tActivitySidebar);
    }

    /**
     * 修改活动侧边栏
     * 
     * @param tActivitySidebar 活动侧边栏
     * @return 结果
     */
    @Override
    public int updateTActivitySidebar(TActivitySidebar tActivitySidebar)
    {
        tActivitySidebar.setUpdateTime(DateUtils.getNowDate());
        return tActivitySidebarMapper.updateTActivitySidebar(tActivitySidebar);
    }

    /**
     * 批量删除活动侧边栏
     * 
     * @param ids 需要删除的活动侧边栏主键
     * @return 结果
     */
    @Override
    public int deleteTActivitySidebarByIds(Long[] ids)
    {
        return tActivitySidebarMapper.deleteTActivitySidebarByIds(ids);
    }

    /**
     * 删除活动侧边栏信息
     * 
     * @param id 活动侧边栏主键
     * @return 结果
     */
    @Override
    public int deleteTActivitySidebarById(Long id)
    {
        return tActivitySidebarMapper.deleteTActivitySidebarById(id);
    }
}
