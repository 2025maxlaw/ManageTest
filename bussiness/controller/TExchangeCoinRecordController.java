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
import com.ruoyi.bussiness.domain.TExchangeCoinRecord;
import com.ruoyi.bussiness.service.ITExchangeCoinRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 币种兑换记录Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/bussiness/record")
public class TExchangeCoinRecordController extends BaseController
{
    @Autowired
    private ITExchangeCoinRecordService tExchangeCoinRecordService;

    /**
     * 查询币种兑换记录列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(TExchangeCoinRecord tExchangeCoinRecord)
    {
        startPage();
        List<TExchangeCoinRecord> list = tExchangeCoinRecordService.selectTExchangeCoinRecordList(tExchangeCoinRecord);
        return getDataTable(list);
    }

    /**
     * 导出币种兑换记录列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:record:export')")
    @Log(title = "币种兑换记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TExchangeCoinRecord tExchangeCoinRecord)
    {
        List<TExchangeCoinRecord> list = tExchangeCoinRecordService.selectTExchangeCoinRecordList(tExchangeCoinRecord);
        ExcelUtil<TExchangeCoinRecord> util = new ExcelUtil<TExchangeCoinRecord>(TExchangeCoinRecord.class);
        util.exportExcel(response, list, "币种兑换记录数据");
    }

    /**
     * 获取币种兑换记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:record:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tExchangeCoinRecordService.selectTExchangeCoinRecordById(id));
    }

    /**
     * 新增币种兑换记录
     */
    @PreAuthorize("@ss.hasPermi('bussiness:record:add')")
    @Log(title = "币种兑换记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TExchangeCoinRecord tExchangeCoinRecord)
    {
        return toAjax(tExchangeCoinRecordService.insertTExchangeCoinRecord(tExchangeCoinRecord));
    }

    /**
     * 修改币种兑换记录
     */
    @PreAuthorize("@ss.hasPermi('bussiness:record:edit')")
    @Log(title = "币种兑换记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TExchangeCoinRecord tExchangeCoinRecord)
    {
        return toAjax(tExchangeCoinRecordService.updateTExchangeCoinRecord(tExchangeCoinRecord));
    }

    /**
     * 删除币种兑换记录
     */
    @PreAuthorize("@ss.hasPermi('bussiness:record:remove')")
    @Log(title = "币种兑换记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tExchangeCoinRecordService.deleteTExchangeCoinRecordByIds(ids));
    }
}
