package com.ruoyi.system.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TAppuserLoginLogMapper;
import com.ruoyi.system.domain.TAppuserLoginLog;
import com.ruoyi.system.service.ITAppuserLoginLogService;

/**
 * 系统访问记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TAppuserLoginLogServiceImpl extends ServiceImpl<TAppuserLoginLogMapper,TAppuserLoginLog> implements ITAppuserLoginLogService
{
    @Autowired
    private TAppuserLoginLogMapper tAppuserLoginLogMapper;

    /**
     * 查询系统访问记录
     * 
     * @param id 系统访问记录主键
     * @return 系统访问记录
     */
    @Override
    public TAppuserLoginLog selectTAppuserLoginLogById(Long id)
    {
        return tAppuserLoginLogMapper.selectTAppuserLoginLogById(id);
    }

    /**
     * 查询系统访问记录列表
     * 
     * @param tAppuserLoginLog 系统访问记录
     * @return 系统访问记录
     */
    @Override
    public List<TAppuserLoginLog> selectTAppuserLoginLogList(TAppuserLoginLog tAppuserLoginLog)
    {
        return tAppuserLoginLogMapper.selectTAppuserLoginLogList(tAppuserLoginLog);
    }

    /**
     * 新增系统访问记录
     * 
     * @param tAppuserLoginLog 系统访问记录
     * @return 结果
     */
    @Override
    public int insertTAppuserLoginLog(TAppuserLoginLog tAppuserLoginLog)
    {
        return tAppuserLoginLogMapper.insertTAppuserLoginLog(tAppuserLoginLog);
    }

    /**
     * 修改系统访问记录
     * 
     * @param tAppuserLoginLog 系统访问记录
     * @return 结果
     */
    @Override
    public int updateTAppuserLoginLog(TAppuserLoginLog tAppuserLoginLog)
    {
        return tAppuserLoginLogMapper.updateTAppuserLoginLog(tAppuserLoginLog);
    }

    /**
     * 批量删除系统访问记录
     * 
     * @param ids 需要删除的系统访问记录主键
     * @return 结果
     */
    @Override
    public int deleteTAppuserLoginLogByIds(Long[] ids)
    {
        return tAppuserLoginLogMapper.deleteTAppuserLoginLogByIds(ids);
    }

    /**
     * 删除系统访问记录信息
     * 
     * @param id 系统访问记录主键
     * @return 结果
     */
    @Override
    public int deleteTAppuserLoginLogById(Long id)
    {
        return tAppuserLoginLogMapper.deleteTAppuserLoginLogById(id);
    }
}
