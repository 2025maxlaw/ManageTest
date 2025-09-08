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
import com.ruoyi.bussiness.domain.TLoadOrder;
import com.ruoyi.bussiness.service.ITLoadOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 贷款订单Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/bussiness/loadOrder")
public class TLoadOrderController extends BaseController
{
    @Autowired
    private ITLoadOrderService tLoadOrderService;

    /**
     * 查询贷款订单列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:loadOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(TLoadOrder tLoadOrder)
    {
        startPage();
        List<TLoadOrder> list = tLoadOrderService.selectTLoadOrderList(tLoadOrder);
        return getDataTable(list);
    }

    /**
     * 导出贷款订单列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:loadOrder:export')")
    @Log(title = "贷款订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TLoadOrder tLoadOrder)
    {
        List<TLoadOrder> list = tLoadOrderService.selectTLoadOrderList(tLoadOrder);
        ExcelUtil<TLoadOrder> util = new ExcelUtil<TLoadOrder>(TLoadOrder.class);
        util.exportExcel(response, list, "贷款订单数据");
    }

    /**
     * 获取贷款订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:loadOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tLoadOrderService.selectTLoadOrderById(id));
    }

    /**
     * 新增贷款订单
     */
    @PreAuthorize("@ss.hasPermi('bussiness:loadOrder:add')")
    @Log(title = "贷款订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TLoadOrder tLoadOrder)
    {
        return toAjax(tLoadOrderService.insertTLoadOrder(tLoadOrder));
    }

    /**
     * 修改贷款订单
     */
    @PreAuthorize("@ss.hasPermi('bussiness:loadOrder:edit')")
    @Log(title = "贷款订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TLoadOrder tLoadOrder)
    {
        return toAjax(tLoadOrderService.updateTLoadOrder(tLoadOrder));
    }

    /**
     * 删除贷款订单
     */
    @PreAuthorize("@ss.hasPermi('bussiness:loadOrder:remove')")
    @Log(title = "贷款订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tLoadOrderService.deleteTLoadOrderByIds(ids));
    }
}
