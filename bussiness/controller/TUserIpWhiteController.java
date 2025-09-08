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
import com.ruoyi.bussiness.domain.TUserIpWhite;
import com.ruoyi.bussiness.service.ITUserIpWhiteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户端登录IP白名单Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/bussiness/tUserIpWhite")
public class TUserIpWhiteController extends BaseController
{
    @Autowired
    private ITUserIpWhiteService tUserIpWhiteService;

    /**
     * 查询客户端登录IP白名单列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tUserIpWhite:list')")
    @GetMapping("/list")
    public TableDataInfo list(TUserIpWhite tUserIpWhite)
    {
        startPage();
        List<TUserIpWhite> list = tUserIpWhiteService.selectTUserIpWhiteList(tUserIpWhite);
        return getDataTable(list);
    }

    /**
     * 导出客户端登录IP白名单列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tUserIpWhite:export')")
    @Log(title = "客户端登录IP白名单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TUserIpWhite tUserIpWhite)
    {
        List<TUserIpWhite> list = tUserIpWhiteService.selectTUserIpWhiteList(tUserIpWhite);
        ExcelUtil<TUserIpWhite> util = new ExcelUtil<TUserIpWhite>(TUserIpWhite.class);
        util.exportExcel(response, list, "客户端登录IP白名单数据");
    }

    /**
     * 获取客户端登录IP白名单详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tUserIpWhite:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tUserIpWhiteService.selectTUserIpWhiteById(id));
    }

    /**
     * 新增客户端登录IP白名单
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tUserIpWhite:add')")
    @Log(title = "客户端登录IP白名单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TUserIpWhite tUserIpWhite)
    {
        return toAjax(tUserIpWhiteService.insertTUserIpWhite(tUserIpWhite));
    }

    /**
     * 修改客户端登录IP白名单
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tUserIpWhite:edit')")
    @Log(title = "客户端登录IP白名单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TUserIpWhite tUserIpWhite)
    {
        return toAjax(tUserIpWhiteService.updateTUserIpWhite(tUserIpWhite));
    }

    /**
     * 删除客户端登录IP白名单
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tUserIpWhite:remove')")
    @Log(title = "客户端登录IP白名单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tUserIpWhiteService.deleteTUserIpWhiteByIds(ids));
    }
}
