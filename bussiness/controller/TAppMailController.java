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
import com.ruoyi.bussiness.domain.TAppMail;
import com.ruoyi.bussiness.service.ITAppMailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 1v1站内信Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/bussiness/mail")
public class TAppMailController extends BaseController
{
    @Autowired
    private ITAppMailService tAppMailService;

    /**
     * 查询1v1站内信列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:mail:list')")
    @GetMapping("/list")
    public TableDataInfo list(TAppMail tAppMail)
    {
        startPage();
        List<TAppMail> list = tAppMailService.selectTAppMailList(tAppMail);
        return getDataTable(list);
    }

    /**
     * 导出1v1站内信列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:mail:export')")
    @Log(title = "1v1站内信", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TAppMail tAppMail)
    {
        List<TAppMail> list = tAppMailService.selectTAppMailList(tAppMail);
        ExcelUtil<TAppMail> util = new ExcelUtil<TAppMail>(TAppMail.class);
        util.exportExcel(response, list, "1v1站内信数据");
    }

    /**
     * 获取1v1站内信详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:mail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tAppMailService.selectTAppMailById(id));
    }

    /**
     * 新增1v1站内信
     */
    @PreAuthorize("@ss.hasPermi('bussiness:mail:add')")
    @Log(title = "1v1站内信", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TAppMail tAppMail)
    {
        return toAjax(tAppMailService.insertTAppMail(tAppMail));
    }

    /**
     * 修改1v1站内信
     */
    @PreAuthorize("@ss.hasPermi('bussiness:mail:edit')")
    @Log(title = "1v1站内信", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TAppMail tAppMail)
    {
        return toAjax(tAppMailService.updateTAppMail(tAppMail));
    }

    /**
     * 删除1v1站内信
     */
    @PreAuthorize("@ss.hasPermi('bussiness:mail:remove')")
    @Log(title = "1v1站内信", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tAppMailService.deleteTAppMailByIds(ids));
    }
}
