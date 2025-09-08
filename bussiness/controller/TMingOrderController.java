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
import com.ruoyi.bussiness.domain.TMingOrder;
import com.ruoyi.bussiness.service.ITMingOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * mingController
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/bussiness/order")
public class TMingOrderController extends BaseController
{
    @Autowired
    private ITMingOrderService tMingOrderService;

    /**
     * 查询ming列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMingOrder tMingOrder)
    {
        startPage();
        List<TMingOrder> list = tMingOrderService.selectTMingOrderList(tMingOrder);
        return getDataTable(list);
    }

    /**
     * 导出ming列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:order:export')")
    @Log(title = "ming", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMingOrder tMingOrder)
    {
        List<TMingOrder> list = tMingOrderService.selectTMingOrderList(tMingOrder);
        ExcelUtil<TMingOrder> util = new ExcelUtil<TMingOrder>(TMingOrder.class);
        util.exportExcel(response, list, "ming数据");
    }

    /**
     * 获取ming详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tMingOrderService.selectTMingOrderById(id));
    }

    /**
     * 新增ming
     */
    @PreAuthorize("@ss.hasPermi('bussiness:order:add')")
    @Log(title = "ming", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMingOrder tMingOrder)
    {
        return toAjax(tMingOrderService.insertTMingOrder(tMingOrder));
    }

    /**
     * 修改ming
     */
    @PreAuthorize("@ss.hasPermi('bussiness:order:edit')")
    @Log(title = "ming", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMingOrder tMingOrder)
    {
        return toAjax(tMingOrderService.updateTMingOrder(tMingOrder));
    }

    /**
     * 删除ming
     */
    @PreAuthorize("@ss.hasPermi('bussiness:order:remove')")
    @Log(title = "ming", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tMingOrderService.deleteTMingOrderByIds(ids));
    }
}
