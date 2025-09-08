package com.ruoyi.bussiness.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import com.ruoyi.bussiness.domain.TMockExchangeRecord;

/**
 * 账户切换记录Mapper接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface TMockExchangeRecordMapper extends BaseMapper<TMockExchangeRecord>
{
    /**
     * 查询账户切换记录
     * 
     * @param id 账户切换记录主键
     * @return 账户切换记录
     */
    public TMockExchangeRecord selectTMockExchangeRecordById(Long id);

    /**
     * 查询账户切换记录列表
     * 
     * @param tMockExchangeRecord 账户切换记录
     * @return 账户切换记录集合
     */
    public List<TMockExchangeRecord> selectTMockExchangeRecordList(TMockExchangeRecord tMockExchangeRecord);

    /**
     * 新增账户切换记录
     * 
     * @param tMockExchangeRecord 账户切换记录
     * @return 结果
     */
    public int insertTMockExchangeRecord(TMockExchangeRecord tMockExchangeRecord);

    /**
     * 修改账户切换记录
     * 
     * @param tMockExchangeRecord 账户切换记录
     * @return 结果
     */
    public int updateTMockExchangeRecord(TMockExchangeRecord tMockExchangeRecord);

    /**
     * 删除账户切换记录
     * 
     * @param id 账户切换记录主键
     * @return 结果
     */
    public int deleteTMockExchangeRecordById(Long id);

    /**
     * 批量删除账户切换记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTMockExchangeRecordByIds(Long[] ids);
}
