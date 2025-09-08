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
import com.ruoyi.system.domain.TSecondCoinConfig;
import com.ruoyi.system.service.ITSecondCoinConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 秒合约币种配置Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/system/config")
public class TSecondCoinConfigController extends BaseController
{
    @Autowired
    private ITSecondCoinConfigService tSecondCoinConfigService;

    /**
     * 查询秒合约币种配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(TSecondCoinConfig tSecondCoinConfig)
    {
        startPage();
        List<TSecondCoinConfig> list = tSecondCoinConfigService.selectTSecondCoinConfigList(tSecondCoinConfig);
        return getDataTable(list);
    }

    /**
     * 导出秒合约币种配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:config:export')")
    @Log(title = "秒合约币种配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSecondCoinConfig tSecondCoinConfig)
    {
        List<TSecondCoinConfig> list = tSecondCoinConfigService.selectTSecondCoinConfigList(tSecondCoinConfig);
        ExcelUtil<TSecondCoinConfig> util = new ExcelUtil<TSecondCoinConfig>(TSecondCoinConfig.class);
        util.exportExcel(response, list, "秒合约币种配置数据");
    }

    /**
     * 获取秒合约币种配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tSecondCoinConfigService.selectTSecondCoinConfigById(id));
    }

    /**
     * 新增秒合约币种配置
     */
    @PreAuthorize("@ss.hasPermi('system:config:add')")
    @Log(title = "秒合约币种配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSecondCoinConfig tSecondCoinConfig)
    {
        return toAjax(tSecondCoinConfigService.insertTSecondCoinConfig(tSecondCoinConfig));
    }

    /**
     * 修改秒合约币种配置
     */
    @PreAuthorize("@ss.hasPermi('system:config:edit')")
    @Log(title = "秒合约币种配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSecondCoinConfig tSecondCoinConfig)
    {
        return toAjax(tSecondCoinConfigService.updateTSecondCoinConfig(tSecondCoinConfig));
    }

    /**
     * 删除秒合约币种配置
     */
    @PreAuthorize("@ss.hasPermi('system:config:remove')")
    @Log(title = "秒合约币种配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tSecondCoinConfigService.deleteTSecondCoinConfigByIds(ids));
    }
}
