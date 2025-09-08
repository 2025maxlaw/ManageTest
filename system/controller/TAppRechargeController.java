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
import com.ruoyi.system.domain.TAppRecharge;
import com.ruoyi.system.service.ITAppRechargeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户充值Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/system/recharge")
public class TAppRechargeController extends BaseController
{
    @Autowired
    private ITAppRechargeService tAppRechargeService;

    /**
     * 查询用户充值列表
     */
    @PreAuthorize("@ss.hasPermi('system:recharge:list')")
    @GetMapping("/list")
    public TableDataInfo list(TAppRecharge tAppRecharge)
    {
        startPage();
        List<TAppRecharge> list = tAppRechargeService.selectTAppRechargeList(tAppRecharge);
        return getDataTable(list);
    }

    /**
     * 导出用户充值列表
     */
    @PreAuthorize("@ss.hasPermi('system:recharge:export')")
    @Log(title = "用户充值", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TAppRecharge tAppRecharge)
    {
        List<TAppRecharge> list = tAppRechargeService.selectTAppRechargeList(tAppRecharge);
        ExcelUtil<TAppRecharge> util = new ExcelUtil<TAppRecharge>(TAppRecharge.class);
        util.exportExcel(response, list, "用户充值数据");
    }

    /**
     * 获取用户充值详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:recharge:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tAppRechargeService.selectTAppRechargeById(id));
    }

    /**
     * 新增用户充值
     */
    @PreAuthorize("@ss.hasPermi('system:recharge:add')")
    @Log(title = "用户充值", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TAppRecharge tAppRecharge)
    {
        return toAjax(tAppRechargeService.insertTAppRecharge(tAppRecharge));
    }

    /**
     * 修改用户充值
     */
    @PreAuthorize("@ss.hasPermi('system:recharge:edit')")
    @Log(title = "用户充值", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TAppRecharge tAppRecharge)
    {
        return toAjax(tAppRechargeService.updateTAppRecharge(tAppRecharge));
    }

    /**
     * 删除用户充值
     */
    @PreAuthorize("@ss.hasPermi('system:recharge:remove')")
    @Log(title = "用户充值", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tAppRechargeService.deleteTAppRechargeByIds(ids));
    }
}
