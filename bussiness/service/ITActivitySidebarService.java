package com.ruoyi.bussiness.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.ruoyi.bussiness.domain.TActivitySidebar;

/**
 * 活动侧边栏Service接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface ITActivitySidebarService extends IService<TActivitySidebar>
{
    /**
     * 查询活动侧边栏
     * 
     * @param id 活动侧边栏主键
     * @return 活动侧边栏
     */
    public TActivitySidebar selectTActivitySidebarById(Long id);

    /**
     * 查询活动侧边栏列表
     * 
     * @param tActivitySidebar 活动侧边栏
     * @return 活动侧边栏集合
     */
    public List<TActivitySidebar> selectTActivitySidebarList(TActivitySidebar tActivitySidebar);

    /**
     * 新增活动侧边栏
     * 
     * @param tActivitySidebar 活动侧边栏
     * @return 结果
     */
    public int insertTActivitySidebar(TActivitySidebar tActivitySidebar);

    /**
     * 修改活动侧边栏
     * 
     * @param tActivitySidebar 活动侧边栏
     * @return 结果
     */
    public int updateTActivitySidebar(TActivitySidebar tActivitySidebar);

    /**
     * 批量删除活动侧边栏
     * 
     * @param ids 需要删除的活动侧边栏主键集合
     * @return 结果
     */
    public int deleteTActivitySidebarByIds(Long[] ids);

    /**
     * 删除活动侧边栏信息
     * 
     * @param id 活动侧边栏主键
     * @return 结果
     */
    public int deleteTActivitySidebarById(Long id);
}
