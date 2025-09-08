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
import com.ruoyi.bussiness.domain.TActivityInfo;
import com.ruoyi.bussiness.service.ITActivityInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 侧边栏内容Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/bussiness/activity_info")
public class TActivityInfoController extends BaseController
{
    @Autowired
    private ITActivityInfoService tActivityInfoService;

    /**
     * 查询侧边栏内容列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:activity_info:list')")
    @GetMapping("/list")
    public TableDataInfo list(TActivityInfo tActivityInfo)
    {
        startPage();
        List<TActivityInfo> list = tActivityInfoService.selectTActivityInfoList(tActivityInfo);
        return getDataTable(list);
    }

    /**
     * 导出侧边栏内容列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:activity_info:export')")
    @Log(title = "侧边栏内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TActivityInfo tActivityInfo)
    {
        List<TActivityInfo> list = tActivityInfoService.selectTActivityInfoList(tActivityInfo);
        ExcelUtil<TActivityInfo> util = new ExcelUtil<TActivityInfo>(TActivityInfo.class);
        util.exportExcel(response, list, "侧边栏内容数据");
    }

    /**
     * 获取侧边栏内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:activity_info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tActivityInfoService.selectTActivityInfoById(id));
    }

    /**
     * 新增侧边栏内容
     */
    @PreAuthorize("@ss.hasPermi('bussiness:activity_info:add')")
    @Log(title = "侧边栏内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TActivityInfo tActivityInfo)
    {
        return toAjax(tActivityInfoService.insertTActivityInfo(tActivityInfo));
    }

    /**
     * 修改侧边栏内容
     */
    @PreAuthorize("@ss.hasPermi('bussiness:activity_info:edit')")
    @Log(title = "侧边栏内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TActivityInfo tActivityInfo)
    {
        return toAjax(tActivityInfoService.updateTActivityInfo(tActivityInfo));
    }

    /**
     * 删除侧边栏内容
     */
    @PreAuthorize("@ss.hasPermi('bussiness:activity_info:remove')")
    @Log(title = "侧边栏内容", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tActivityInfoService.deleteTActivityInfoByIds(ids));
    }
}
