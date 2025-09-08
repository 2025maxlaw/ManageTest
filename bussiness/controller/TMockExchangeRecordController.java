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
import com.ruoyi.bussiness.domain.TMockExchangeRecord;
import com.ruoyi.bussiness.service.ITMockExchangeRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 账户切换记录Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/bussiness/tMockExchangeRecord")
public class TMockExchangeRecordController extends BaseController
{
    @Autowired
    private ITMockExchangeRecordService tMockExchangeRecordService;

    /**
     * 查询账户切换记录列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tMockExchangeRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMockExchangeRecord tMockExchangeRecord)
    {
        startPage();
        List<TMockExchangeRecord> list = tMockExchangeRecordService.selectTMockExchangeRecordList(tMockExchangeRecord);
        return getDataTable(list);
    }

    /**
     * 导出账户切换记录列表
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tMockExchangeRecord:export')")
    @Log(title = "账户切换记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMockExchangeRecord tMockExchangeRecord)
    {
        List<TMockExchangeRecord> list = tMockExchangeRecordService.selectTMockExchangeRecordList(tMockExchangeRecord);
        ExcelUtil<TMockExchangeRecord> util = new ExcelUtil<TMockExchangeRecord>(TMockExchangeRecord.class);
        util.exportExcel(response, list, "账户切换记录数据");
    }

    /**
     * 获取账户切换记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tMockExchangeRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tMockExchangeRecordService.selectTMockExchangeRecordById(id));
    }

    /**
     * 新增账户切换记录
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tMockExchangeRecord:add')")
    @Log(title = "账户切换记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMockExchangeRecord tMockExchangeRecord)
    {
        return toAjax(tMockExchangeRecordService.insertTMockExchangeRecord(tMockExchangeRecord));
    }

    /**
     * 修改账户切换记录
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tMockExchangeRecord:edit')")
    @Log(title = "账户切换记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMockExchangeRecord tMockExchangeRecord)
    {
        return toAjax(tMockExchangeRecordService.updateTMockExchangeRecord(tMockExchangeRecord));
    }

    /**
     * 删除账户切换记录
     */
    @PreAuthorize("@ss.hasPermi('bussiness:tMockExchangeRecord:remove')")
    @Log(title = "账户切换记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tMockExchangeRecordService.deleteTMockExchangeRecordByIds(ids));
    }
}
