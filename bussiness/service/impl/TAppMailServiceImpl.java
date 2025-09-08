package com.ruoyi.bussiness.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bussiness.mapper.TAppMailMapper;
import com.ruoyi.bussiness.domain.TAppMail;
import com.ruoyi.bussiness.service.ITAppMailService;

/**
 * 1v1站内信Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TAppMailServiceImpl extends ServiceImpl<TAppMailMapper,TAppMail> implements ITAppMailService
{
    @Autowired
    private TAppMailMapper tAppMailMapper;

    /**
     * 查询1v1站内信
     * 
     * @param id 1v1站内信主键
     * @return 1v1站内信
     */
    @Override
    public TAppMail selectTAppMailById(Long id)
    {
        return tAppMailMapper.selectTAppMailById(id);
    }

    /**
     * 查询1v1站内信列表
     * 
     * @param tAppMail 1v1站内信
     * @return 1v1站内信
     */
    @Override
    public List<TAppMail> selectTAppMailList(TAppMail tAppMail)
    {
        return tAppMailMapper.selectTAppMailList(tAppMail);
    }

    /**
     * 新增1v1站内信
     * 
     * @param tAppMail 1v1站内信
     * @return 结果
     */
    @Override
    public int insertTAppMail(TAppMail tAppMail)
    {
        tAppMail.setCreateTime(DateUtils.getNowDate());
        return tAppMailMapper.insertTAppMail(tAppMail);
    }

    /**
     * 修改1v1站内信
     * 
     * @param tAppMail 1v1站内信
     * @return 结果
     */
    @Override
    public int updateTAppMail(TAppMail tAppMail)
    {
        tAppMail.setUpdateTime(DateUtils.getNowDate());
        return tAppMailMapper.updateTAppMail(tAppMail);
    }

    /**
     * 批量删除1v1站内信
     * 
     * @param ids 需要删除的1v1站内信主键
     * @return 结果
     */
    @Override
    public int deleteTAppMailByIds(Long[] ids)
    {
        return tAppMailMapper.deleteTAppMailByIds(ids);
    }

    /**
     * 删除1v1站内信信息
     * 
     * @param id 1v1站内信主键
     * @return 结果
     */
    @Override
    public int deleteTAppMailById(Long id)
    {
        return tAppMailMapper.deleteTAppMailById(id);
    }
}
