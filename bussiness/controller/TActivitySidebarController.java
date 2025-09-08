package com.ruoyi.bussiness.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.bussiness.domain.TActivitySidebar;
import com.ruoyi.bussiness.service.ITActivitySidebarService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动侧边栏Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/bussiness/activity_sidebar")
public class TActivitySidebarController extends BaseController
{
    @Autowired
    private ITActivitySidebarService tActivitySidebarService;

    /**
     * 查询活动侧边栏列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:activity_sidebar:list')")
    @GetMapping("/list")
    public TableDataInfo list(TActivitySidebar tActivitySidebar)
    {
        startPage();
        List<TActivitySidebar> list = tActivitySidebarService.selectTActivitySidebarList(tActivitySidebar);
        return getDataTable(list);
    }

    /**
     * 导出活动侧边栏列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:activity_sidebar:export')")
    @Log(title = "活动侧边栏", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TActivitySidebar tActivitySidebar)
    {
        List<TActivitySidebar> list = tActivitySidebarService.selectTActivitySidebarList(tActivitySidebar);
        ExcelUtil<TActivitySidebar> util = new ExcelUtil<TActivitySidebar>(TActivitySidebar.class);
        util.exportExcel(response, list, "活动侧边栏数据");
    }

    /**
     * 获取活动侧边栏详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:activity_sidebar:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tActivitySidebarService.selectTActivitySidebarById(id));
    }

    /**
     * 新增活动侧边栏
     */
    @PreAuthorize("@ss.hasPermi('bussiness:activity_sidebar:add')")
    @Log(title = "活动侧边栏", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TActivitySidebar tActivitySidebar)
    {
        return toAjax(tActivitySidebarService.insertTActivitySidebar(tActivitySidebar));
    }

    /**
     * 修改活动侧边栏
     */
    @PreAuthorize("@ss.hasPermi('bussiness:activity_sidebar:edit')")
    @Log(title = "活动侧边栏", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TActivitySidebar tActivitySidebar)
    {
        return toAjax(tActivitySidebarService.updateTActivitySidebar(tActivitySidebar));
    }

    /**
     * 删除活动侧边栏
     */
    @PreAuthorize("@ss.hasPermi('bussiness:activity_sidebar:remove')")
    @Log(title = "活动侧边栏", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tActivitySidebarService.deleteTActivitySidebarByIds(ids));
    }
}
