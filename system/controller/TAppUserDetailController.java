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
import com.ruoyi.system.domain.TAppUserDetail;
import com.ruoyi.system.service.ITAppUserDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户详细信息Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/bussiness/detail")
public class TAppUserDetailController extends BaseController
{
    @Autowired
    private ITAppUserDetailService tAppUserDetailService;

    /**
     * 查询用户详细信息列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(TAppUserDetail tAppUserDetail)
    {
        startPage();
        List<TAppUserDetail> list = tAppUserDetailService.selectTAppUserDetailList(tAppUserDetail);
        return getDataTable(list);
    }

    /**
     * 导出用户详细信息列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:detail:export')")
    @Log(title = "用户详细信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TAppUserDetail tAppUserDetail)
    {
        List<TAppUserDetail> list = tAppUserDetailService.selectTAppUserDetailList(tAppUserDetail);
        ExcelUtil<TAppUserDetail> util = new ExcelUtil<TAppUserDetail>(TAppUserDetail.class);
        util.exportExcel(response, list, "用户详细信息数据");
    }

    /**
     * 获取用户详细信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tAppUserDetailService.selectTAppUserDetailById(id));
    }

    /**
     * 新增用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:detail:add')")
    @Log(title = "用户详细信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TAppUserDetail tAppUserDetail)
    {
        return toAjax(tAppUserDetailService.insertTAppUserDetail(tAppUserDetail));
    }

    /**
     * 修改用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:detail:edit')")
    @Log(title = "用户详细信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TAppUserDetail tAppUserDetail)
    {
        return toAjax(tAppUserDetailService.updateTAppUserDetail(tAppUserDetail));
    }

    /**
     * 删除用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:detail:remove')")
    @Log(title = "用户详细信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tAppUserDetailService.deleteTAppUserDetailByIds(ids));
    }
}
