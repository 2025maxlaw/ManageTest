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
import com.ruoyi.bussiness.domain.TAppAssetRebate;
import com.ruoyi.bussiness.service.ITAppAssetRebateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户资产返佣Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/bussiness/assetrebate")
public class TAppAssetRebateController extends BaseController
{
    @Autowired
    private ITAppAssetRebateService tAppAssetRebateService;

    /**
     * 查询用户资产返佣列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:assetrebate:list')")
    @GetMapping("/list")
    public TableDataInfo list(TAppAssetRebate tAppAssetRebate)
    {
        startPage();
        List<TAppAssetRebate> list = tAppAssetRebateService.selectTAppAssetRebateList(tAppAssetRebate);
        return getDataTable(list);
    }

    /**
     * 导出用户资产返佣列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:assetrebate:export')")
    @Log(title = "用户资产返佣", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TAppAssetRebate tAppAssetRebate)
    {
        List<TAppAssetRebate> list = tAppAssetRebateService.selectTAppAssetRebateList(tAppAssetRebate);
        ExcelUtil<TAppAssetRebate> util = new ExcelUtil<TAppAssetRebate>(TAppAssetRebate.class);
        util.exportExcel(response, list, "用户资产返佣数据");
    }

    /**
     * 获取用户资产返佣详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:assetrebate:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tAppAssetRebateService.selectTAppAssetRebateById(id));
    }

    /**
     * 新增用户资产返佣
     */
    @PreAuthorize("@ss.hasPermi('bussiness:assetrebate:add')")
    @Log(title = "用户资产返佣", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TAppAssetRebate tAppAssetRebate)
    {
        return toAjax(tAppAssetRebateService.insertTAppAssetRebate(tAppAssetRebate));
    }

    /**
     * 修改用户资产返佣
     */
    @PreAuthorize("@ss.hasPermi('bussiness:assetrebate:edit')")
    @Log(title = "用户资产返佣", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TAppAssetRebate tAppAssetRebate)
    {
        return toAjax(tAppAssetRebateService.updateTAppAssetRebate(tAppAssetRebate));
    }

    /**
     * 删除用户资产返佣
     */
    @PreAuthorize("@ss.hasPermi('bussiness:assetrebate:remove')")
    @Log(title = "用户资产返佣", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tAppAssetRebateService.deleteTAppAssetRebateByIds(ids));
    }
}
