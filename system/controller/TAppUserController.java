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
import com.ruoyi.system.domain.TAppUser;
import com.ruoyi.system.service.ITAppUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 玩家用户Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/system/user")
public class TAppUserController extends BaseController
{
    @Autowired
    private ITAppUserService tAppUserService;

    /**
     * 查询玩家用户列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(TAppUser tAppUser)
    {
        startPage();
        List<TAppUser> list = tAppUserService.selectTAppUserList(tAppUser);
        return getDataTable(list);
    }

    /**
     * 导出玩家用户列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:export')")
    @Log(title = "玩家用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TAppUser tAppUser)
    {
        List<TAppUser> list = tAppUserService.selectTAppUserList(tAppUser);
        ExcelUtil<TAppUser> util = new ExcelUtil<TAppUser>(TAppUser.class);
        util.exportExcel(response, list, "玩家用户数据");
    }

    /**
     * 获取玩家用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(tAppUserService.selectTAppUserByUserId(userId));
    }

    /**
     * 新增玩家用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @Log(title = "玩家用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TAppUser tAppUser)
    {
        return toAjax(tAppUserService.insertTAppUser(tAppUser));
    }

    /**
     * 修改玩家用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "玩家用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TAppUser tAppUser)
    {
        return toAjax(tAppUserService.updateTAppUser(tAppUser));
    }

    /**
     * 删除玩家用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:remove')")
    @Log(title = "玩家用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(tAppUserService.deleteTAppUserByUserIds(userIds));
    }
}
