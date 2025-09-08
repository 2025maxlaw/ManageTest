package com.ruoyi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.ruoyi.system.domain.TAppWalletRecord;

/**
 * 用户信息Service接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface ITAppWalletRecordService extends IService<TAppWalletRecord>
{
    /**
     * 查询用户信息
     * 
     * @param id 用户信息主键
     * @return 用户信息
     */
    public TAppWalletRecord selectTAppWalletRecordById(Long id);

    /**
     * 查询用户信息列表
     * 
     * @param tAppWalletRecord 用户信息
     * @return 用户信息集合
     */
    public List<TAppWalletRecord> selectTAppWalletRecordList(TAppWalletRecord tAppWalletRecord);

    /**
     * 新增用户信息
     * 
     * @param tAppWalletRecord 用户信息
     * @return 结果
     */
    public int insertTAppWalletRecord(TAppWalletRecord tAppWalletRecord);

    /**
     * 修改用户信息
     * 
     * @param tAppWalletRecord 用户信息
     * @return 结果
     */
    public int updateTAppWalletRecord(TAppWalletRecord tAppWalletRecord);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的用户信息主键集合
     * @return 结果
     */
    public int deleteTAppWalletRecordByIds(Long[] ids);

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息主键
     * @return 结果
     */
    public int deleteTAppWalletRecordById(Long id);
}
