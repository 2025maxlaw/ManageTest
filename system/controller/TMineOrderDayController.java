package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.TMineOrderDay;
import com.ruoyi.system.service.ITMineOrderDayService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/system/day")
public class TMineOrderDayController extends BaseController
{
    @Autowired
    private ITMineOrderDayService tMineOrderDayService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:day:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMineOrderDay tMineOrderDay)
    {
        startPage();
        List<TMineOrderDay> list = tMineOrderDayService.selectTMineOrderDayList(tMineOrderDay);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:day:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMineOrderDay tMineOrderDay)
    {
        List<TMineOrderDay> list = tMineOrderDayService.selectTMineOrderDayList(tMineOrderDay);
        ExcelUtil<TMineOrderDay> util = new ExcelUtil<TMineOrderDay>(TMineOrderDay.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:day:query')")
    @GetMapping(value = "/{amount}")
    public AjaxResult getInfo(@PathVariable("amount") BigDecimal amount)
    {
        return success(tMineOrderDayService.selectTMineOrderDayByAmount(amount));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:day:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMineOrderDay tMineOrderDay)
    {
        return toAjax(tMineOrderDayService.insertTMineOrderDay(tMineOrderDay));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:day:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMineOrderDay tMineOrderDay)
    {
        return toAjax(tMineOrderDayService.updateTMineOrderDay(tMineOrderDay));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:day:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{amounts}")
    public AjaxResult remove(@PathVariable BigDecimal[] amounts)
    {
        return toAjax(tMineOrderDayService.deleteTMineOrderDayByAmounts(amounts));
    }
}
