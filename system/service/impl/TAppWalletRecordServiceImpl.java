package com.ruoyi.system.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TAppWalletRecordMapper;
import com.ruoyi.system.domain.TAppWalletRecord;
import com.ruoyi.system.service.ITAppWalletRecordService;

/**
 * 用户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TAppWalletRecordServiceImpl extends ServiceImpl<TAppWalletRecordMapper,TAppWalletRecord> implements ITAppWalletRecordService
{
    @Autowired
    private TAppWalletRecordMapper tAppWalletRecordMapper;

    /**
     * 查询用户信息
     * 
     * @param id 用户信息主键
     * @return 用户信息
     */
    @Override
    public TAppWalletRecord selectTAppWalletRecordById(Long id)
    {
        return tAppWalletRecordMapper.selectTAppWalletRecordById(id);
    }

    /**
     * 查询用户信息列表
     * 
     * @param tAppWalletRecord 用户信息
     * @return 用户信息
     */
    @Override
    public List<TAppWalletRecord> selectTAppWalletRecordList(TAppWalletRecord tAppWalletRecord)
    {
        return tAppWalletRecordMapper.selectTAppWalletRecordList(tAppWalletRecord);
    }

    /**
     * 新增用户信息
     * 
     * @param tAppWalletRecord 用户信息
     * @return 结果
     */
    @Override
    public int insertTAppWalletRecord(TAppWalletRecord tAppWalletRecord)
    {
        tAppWalletRecord.setCreateTime(DateUtils.getNowDate());
        return tAppWalletRecordMapper.insertTAppWalletRecord(tAppWalletRecord);
    }

    /**
     * 修改用户信息
     * 
     * @param tAppWalletRecord 用户信息
     * @return 结果
     */
    @Override
    public int updateTAppWalletRecord(TAppWalletRecord tAppWalletRecord)
    {
        tAppWalletRecord.setUpdateTime(DateUtils.getNowDate());
        return tAppWalletRecordMapper.updateTAppWalletRecord(tAppWalletRecord);
    }

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的用户信息主键
     * @return 结果
     */
    @Override
    public int deleteTAppWalletRecordByIds(Long[] ids)
    {
        return tAppWalletRecordMapper.deleteTAppWalletRecordByIds(ids);
    }

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息主键
     * @return 结果
     */
    @Override
    public int deleteTAppWalletRecordById(Long id)
    {
        return tAppWalletRecordMapper.deleteTAppWalletRecordById(id);
    }
}
