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
import com.ruoyi.bussiness.domain.TAssetTransFunds;
import com.ruoyi.bussiness.service.ITAssetTransFundsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 划转记录Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/bussiness/tAssetTransFunds")
public class TAssetTransFundsController extends BaseController
{
    @Autowired
    private ITAssetTransFundsService tAssetTransFundsService;

    /**
     * 查询划转记录列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tAssetTransFunds:list')")
    @GetMapping("/list")
    public TableDataInfo list(TAssetTransFunds tAssetTransFunds)
    {
        startPage();
        List<TAssetTransFunds> list = tAssetTransFundsService.selectTAssetTransFundsList(tAssetTransFunds);
        return getDataTable(list);
    }

    /**
     * 导出划转记录列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tAssetTransFunds:export')")
    @Log(title = "划转记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TAssetTransFunds tAssetTransFunds)
    {
        List<TAssetTransFunds> list = tAssetTransFundsService.selectTAssetTransFundsList(tAssetTransFunds);
        ExcelUtil<TAssetTransFunds> util = new ExcelUtil<TAssetTransFunds>(TAssetTransFunds.class);
        util.exportExcel(response, list, "划转记录数据");
    }

    /**
     * 获取划转记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tAssetTransFunds:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tAssetTransFundsService.selectTAssetTransFundsById(id));
    }

    /**
     * 新增划转记录
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tAssetTransFunds:add')")
    @Log(title = "划转记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TAssetTransFunds tAssetTransFunds)
    {
        return toAjax(tAssetTransFundsService.insertTAssetTransFunds(tAssetTransFunds));
    }

    /**
     * 修改划转记录
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tAssetTransFunds:edit')")
    @Log(title = "划转记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TAssetTransFunds tAssetTransFunds)
    {
        return toAjax(tAssetTransFundsService.updateTAssetTransFunds(tAssetTransFunds));
    }

    /**
     * 删除划转记录
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tAssetTransFunds:remove')")
    @Log(title = "划转记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tAssetTransFundsService.deleteTAssetTransFundsByIds(ids));
    }
}
