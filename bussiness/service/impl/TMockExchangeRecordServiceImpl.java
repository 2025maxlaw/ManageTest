package com.ruoyi.bussiness.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bussiness.mapper.TMockExchangeRecordMapper;
import com.ruoyi.bussiness.domain.TMockExchangeRecord;
import com.ruoyi.bussiness.service.ITMockExchangeRecordService;

/**
 * 账户切换记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TMockExchangeRecordServiceImpl extends ServiceImpl<TMockExchangeRecordMapper,TMockExchangeRecord> implements ITMockExchangeRecordService
{
    @Autowired
    private TMockExchangeRecordMapper tMockExchangeRecordMapper;

    /**
     * 查询账户切换记录
     * 
     * @param id 账户切换记录主键
     * @return 账户切换记录
     */
    @Override
    public TMockExchangeRecord selectTMockExchangeRecordById(Long id)
    {
        return tMockExchangeRecordMapper.selectTMockExchangeRecordById(id);
    }

    /**
     * 查询账户切换记录列表
     * 
     * @param tMockExchangeRecord 账户切换记录
     * @return 账户切换记录
     */
    @Override
    public List<TMockExchangeRecord> selectTMockExchangeRecordList(TMockExchangeRecord tMockExchangeRecord)
    {
        return tMockExchangeRecordMapper.selectTMockExchangeRecordList(tMockExchangeRecord);
    }

    /**
     * 新增账户切换记录
     * 
     * @param tMockExchangeRecord 账户切换记录
     * @return 结果
     */
    @Override
    public int insertTMockExchangeRecord(TMockExchangeRecord tMockExchangeRecord)
    {
        tMockExchangeRecord.setCreateTime(DateUtils.getNowDate());
        return tMockExchangeRecordMapper.insertTMockExchangeRecord(tMockExchangeRecord);
    }

    /**
     * 修改账户切换记录
     * 
     * @param tMockExchangeRecord 账户切换记录
     * @return 结果
     */
    @Override
    public int updateTMockExchangeRecord(TMockExchangeRecord tMockExchangeRecord)
    {
        tMockExchangeRecord.setUpdateTime(DateUtils.getNowDate());
        return tMockExchangeRecordMapper.updateTMockExchangeRecord(tMockExchangeRecord);
    }

    /**
     * 批量删除账户切换记录
     * 
     * @param ids 需要删除的账户切换记录主键
     * @return 结果
     */
    @Override
    public int deleteTMockExchangeRecordByIds(Long[] ids)
    {
        return tMockExchangeRecordMapper.deleteTMockExchangeRecordByIds(ids);
    }

    /**
     * 删除账户切换记录信息
     * 
     * @param id 账户切换记录主键
     * @return 结果
     */
    @Override
    public int deleteTMockExchangeRecordById(Long id)
    {
        return tMockExchangeRecordMapper.deleteTMockExchangeRecordById(id);
    }
}
