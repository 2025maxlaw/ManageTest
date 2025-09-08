package com.ruoyi.system.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TSymbolManageMapper;
import com.ruoyi.system.domain.TSymbolManage;
import com.ruoyi.system.service.ITSymbolManageService;

/**
 * 币种管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TSymbolManageServiceImpl extends ServiceImpl<TSymbolManageMapper,TSymbolManage> implements ITSymbolManageService
{
    @Autowired
    private TSymbolManageMapper tSymbolManageMapper;

    /**
     * 查询币种管理
     * 
     * @param id 币种管理主键
     * @return 币种管理
     */
    @Override
    public TSymbolManage selectTSymbolManageById(Long id)
    {
        return tSymbolManageMapper.selectTSymbolManageById(id);
    }

    /**
     * 查询币种管理列表
     * 
     * @param tSymbolManage 币种管理
     * @return 币种管理
     */
    @Override
    public List<TSymbolManage> selectTSymbolManageList(TSymbolManage tSymbolManage)
    {
        return tSymbolManageMapper.selectTSymbolManageList(tSymbolManage);
    }

    /**
     * 新增币种管理
     * 
     * @param tSymbolManage 币种管理
     * @return 结果
     */
    @Override
    public int insertTSymbolManage(TSymbolManage tSymbolManage)
    {
        tSymbolManage.setCreateTime(DateUtils.getNowDate());
        return tSymbolManageMapper.insertTSymbolManage(tSymbolManage);
    }

    /**
     * 修改币种管理
     * 
     * @param tSymbolManage 币种管理
     * @return 结果
     */
    @Override
    public int updateTSymbolManage(TSymbolManage tSymbolManage)
    {
        tSymbolManage.setUpdateTime(DateUtils.getNowDate());
        return tSymbolManageMapper.updateTSymbolManage(tSymbolManage);
    }

    /**
     * 批量删除币种管理
     * 
     * @param ids 需要删除的币种管理主键
     * @return 结果
     */
    @Override
    public int deleteTSymbolManageByIds(Long[] ids)
    {
        return tSymbolManageMapper.deleteTSymbolManageByIds(ids);
    }

    /**
     * 删除币种管理信息
     * 
     * @param id 币种管理主键
     * @return 结果
     */
    @Override
    public int deleteTSymbolManageById(Long id)
    {
        return tSymbolManageMapper.deleteTSymbolManageById(id);
    }
}
