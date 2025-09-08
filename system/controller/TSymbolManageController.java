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
import com.ruoyi.system.domain.TSymbolManage;
import com.ruoyi.system.service.ITSymbolManageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 币种管理Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/bussiness/manage")
public class TSymbolManageController extends BaseController
{
    @Autowired
    private ITSymbolManageService tSymbolManageService;

    /**
     * 查询币种管理列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:manage:list')")
    @GetMapping("/list")
    public TableDataInfo list(TSymbolManage tSymbolManage)
    {
        startPage();
        List<TSymbolManage> list = tSymbolManageService.selectTSymbolManageList(tSymbolManage);
        return getDataTable(list);
    }

    /**
     * 导出币种管理列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:manage:export')")
    @Log(title = "币种管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSymbolManage tSymbolManage)
    {
        List<TSymbolManage> list = tSymbolManageService.selectTSymbolManageList(tSymbolManage);
        ExcelUtil<TSymbolManage> util = new ExcelUtil<TSymbolManage>(TSymbolManage.class);
        util.exportExcel(response, list, "币种管理数据");
    }

    /**
     * 获取币种管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:manage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tSymbolManageService.selectTSymbolManageById(id));
    }

    /**
     * 新增币种管理
     */
    @PreAuthorize("@ss.hasPermi('bussiness:manage:add')")
    @Log(title = "币种管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSymbolManage tSymbolManage)
    {
        return toAjax(tSymbolManageService.insertTSymbolManage(tSymbolManage));
    }

    /**
     * 修改币种管理
     */
    @PreAuthorize("@ss.hasPermi('bussiness:manage:edit')")
    @Log(title = "币种管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSymbolManage tSymbolManage)
    {
        return toAjax(tSymbolManageService.updateTSymbolManage(tSymbolManage));
    }

    /**
     * 删除币种管理
     */
    @PreAuthorize("@ss.hasPermi('bussiness:manage:remove')")
    @Log(title = "币种管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tSymbolManageService.deleteTSymbolManageByIds(ids));
    }
}
