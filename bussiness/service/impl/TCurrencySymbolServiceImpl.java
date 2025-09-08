package com.ruoyi.bussiness.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bussiness.mapper.TCurrencySymbolMapper;
import com.ruoyi.bussiness.domain.TCurrencySymbol;
import com.ruoyi.bussiness.service.ITCurrencySymbolService;

/**
 * 币币交易币种配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TCurrencySymbolServiceImpl extends ServiceImpl<TCurrencySymbolMapper,TCurrencySymbol> implements ITCurrencySymbolService
{
    @Autowired
    private TCurrencySymbolMapper tCurrencySymbolMapper;

    /**
     * 查询币币交易币种配置
     * 
     * @param id 币币交易币种配置主键
     * @return 币币交易币种配置
     */
    @Override
    public TCurrencySymbol selectTCurrencySymbolById(Long id)
    {
        return tCurrencySymbolMapper.selectTCurrencySymbolById(id);
    }

    /**
     * 查询币币交易币种配置列表
     * 
     * @param tCurrencySymbol 币币交易币种配置
     * @return 币币交易币种配置
     */
    @Override
    public List<TCurrencySymbol> selectTCurrencySymbolList(TCurrencySymbol tCurrencySymbol)
    {
        return tCurrencySymbolMapper.selectTCurrencySymbolList(tCurrencySymbol);
    }

    /**
     * 新增币币交易币种配置
     * 
     * @param tCurrencySymbol 币币交易币种配置
     * @return 结果
     */
    @Override
    public int insertTCurrencySymbol(TCurrencySymbol tCurrencySymbol)
    {
        return tCurrencySymbolMapper.insertTCurrencySymbol(tCurrencySymbol);
    }

    /**
     * 修改币币交易币种配置
     * 
     * @param tCurrencySymbol 币币交易币种配置
     * @return 结果
     */
    @Override
    public int updateTCurrencySymbol(TCurrencySymbol tCurrencySymbol)
    {
        return tCurrencySymbolMapper.updateTCurrencySymbol(tCurrencySymbol);
    }

    /**
     * 批量删除币币交易币种配置
     * 
     * @param ids 需要删除的币币交易币种配置主键
     * @return 结果
     */
    @Override
    public int deleteTCurrencySymbolByIds(Long[] ids)
    {
        return tCurrencySymbolMapper.deleteTCurrencySymbolByIds(ids);
    }

    /**
     * 删除币币交易币种配置信息
     * 
     * @param id 币币交易币种配置主键
     * @return 结果
     */
    @Override
    public int deleteTCurrencySymbolById(Long id)
    {
        return tCurrencySymbolMapper.deleteTCurrencySymbolById(id);
    }
}
