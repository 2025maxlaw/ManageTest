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
import com.ruoyi.system.domain.TAppWalletRecord;
import com.ruoyi.system.service.ITAppWalletRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户信息Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/system/record")
public class TAppWalletRecordController extends BaseController
{
    @Autowired
    private ITAppWalletRecordService tAppWalletRecordService;

    /**
     * 查询用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(TAppWalletRecord tAppWalletRecord)
    {
        startPage();
        List<TAppWalletRecord> list = tAppWalletRecordService.selectTAppWalletRecordList(tAppWalletRecord);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:export')")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TAppWalletRecord tAppWalletRecord)
    {
        List<TAppWalletRecord> list = tAppWalletRecordService.selectTAppWalletRecordList(tAppWalletRecord);
        ExcelUtil<TAppWalletRecord> util = new ExcelUtil<TAppWalletRecord>(TAppWalletRecord.class);
        util.exportExcel(response, list, "用户信息数据");
    }

    /**
     * 获取用户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tAppWalletRecordService.selectTAppWalletRecordById(id));
    }

    /**
     * 新增用户信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:add')")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TAppWalletRecord tAppWalletRecord)
    {
        return toAjax(tAppWalletRecordService.insertTAppWalletRecord(tAppWalletRecord));
    }

    /**
     * 修改用户信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:edit')")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TAppWalletRecord tAppWalletRecord)
    {
        return toAjax(tAppWalletRecordService.updateTAppWalletRecord(tAppWalletRecord));
    }

    /**
     * 删除用户信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:remove')")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tAppWalletRecordService.deleteTAppWalletRecordByIds(ids));
    }
}
