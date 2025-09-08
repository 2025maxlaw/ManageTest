package com.ruoyi.bussiness.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bussiness.mapper.TExchangeCoinRecordMapper;
import com.ruoyi.bussiness.domain.TExchangeCoinRecord;
import com.ruoyi.bussiness.service.ITExchangeCoinRecordService;

/**
 * 币种兑换记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TExchangeCoinRecordServiceImpl extends ServiceImpl<TExchangeCoinRecordMapper,TExchangeCoinRecord> implements ITExchangeCoinRecordService
{
    @Autowired
    private TExchangeCoinRecordMapper tExchangeCoinRecordMapper;

    /**
     * 查询币种兑换记录
     * 
     * @param id 币种兑换记录主键
     * @return 币种兑换记录
     */
    @Override
    public TExchangeCoinRecord selectTExchangeCoinRecordById(Long id)
    {
        return tExchangeCoinRecordMapper.selectTExchangeCoinRecordById(id);
    }

    /**
     * 查询币种兑换记录列表
     * 
     * @param tExchangeCoinRecord 币种兑换记录
     * @return 币种兑换记录
     */
    @Override
    public List<TExchangeCoinRecord> selectTExchangeCoinRecordList(TExchangeCoinRecord tExchangeCoinRecord)
    {
        return tExchangeCoinRecordMapper.selectTExchangeCoinRecordList(tExchangeCoinRecord);
    }

    /**
     * 新增币种兑换记录
     * 
     * @param tExchangeCoinRecord 币种兑换记录
     * @return 结果
     */
    @Override
    public int insertTExchangeCoinRecord(TExchangeCoinRecord tExchangeCoinRecord)
    {
        tExchangeCoinRecord.setCreateTime(DateUtils.getNowDate());
        return tExchangeCoinRecordMapper.insertTExchangeCoinRecord(tExchangeCoinRecord);
    }

    /**
     * 修改币种兑换记录
     * 
     * @param tExchangeCoinRecord 币种兑换记录
     * @return 结果
     */
    @Override
    public int updateTExchangeCoinRecord(TExchangeCoinRecord tExchangeCoinRecord)
    {
        tExchangeCoinRecord.setUpdateTime(DateUtils.getNowDate());
        return tExchangeCoinRecordMapper.updateTExchangeCoinRecord(tExchangeCoinRecord);
    }

    /**
     * 批量删除币种兑换记录
     * 
     * @param ids 需要删除的币种兑换记录主键
     * @return 结果
     */
    @Override
    public int deleteTExchangeCoinRecordByIds(Long[] ids)
    {
        return tExchangeCoinRecordMapper.deleteTExchangeCoinRecordByIds(ids);
    }

    /**
     * 删除币种兑换记录信息
     * 
     * @param id 币种兑换记录主键
     * @return 结果
     */
    @Override
    public int deleteTExchangeCoinRecordById(Long id)
    {
        return tExchangeCoinRecordMapper.deleteTExchangeCoinRecordById(id);
    }
}
