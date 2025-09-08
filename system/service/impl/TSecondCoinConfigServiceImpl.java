package com.ruoyi.system.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TSecondCoinConfigMapper;
import com.ruoyi.system.domain.TSecondCoinConfig;
import com.ruoyi.system.service.ITSecondCoinConfigService;

/**
 * 秒合约币种配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TSecondCoinConfigServiceImpl extends ServiceImpl<TSecondCoinConfigMapper,TSecondCoinConfig> implements ITSecondCoinConfigService
{
    @Autowired
    private TSecondCoinConfigMapper tSecondCoinConfigMapper;

    /**
     * 查询秒合约币种配置
     * 
     * @param id 秒合约币种配置主键
     * @return 秒合约币种配置
     */
    @Override
    public TSecondCoinConfig selectTSecondCoinConfigById(Long id)
    {
        return tSecondCoinConfigMapper.selectTSecondCoinConfigById(id);
    }

    /**
     * 查询秒合约币种配置列表
     * 
     * @param tSecondCoinConfig 秒合约币种配置
     * @return 秒合约币种配置
     */
    @Override
    public List<TSecondCoinConfig> selectTSecondCoinConfigList(TSecondCoinConfig tSecondCoinConfig)
    {
        return tSecondCoinConfigMapper.selectTSecondCoinConfigList(tSecondCoinConfig);
    }

    /**
     * 新增秒合约币种配置
     * 
     * @param tSecondCoinConfig 秒合约币种配置
     * @return 结果
     */
    @Override
    public int insertTSecondCoinConfig(TSecondCoinConfig tSecondCoinConfig)
    {
        tSecondCoinConfig.setCreateTime(DateUtils.getNowDate());
        return tSecondCoinConfigMapper.insertTSecondCoinConfig(tSecondCoinConfig);
    }

    /**
     * 修改秒合约币种配置
     * 
     * @param tSecondCoinConfig 秒合约币种配置
     * @return 结果
     */
    @Override
    public int updateTSecondCoinConfig(TSecondCoinConfig tSecondCoinConfig)
    {
        tSecondCoinConfig.setUpdateTime(DateUtils.getNowDate());
        return tSecondCoinConfigMapper.updateTSecondCoinConfig(tSecondCoinConfig);
    }

    /**
     * 批量删除秒合约币种配置
     * 
     * @param ids 需要删除的秒合约币种配置主键
     * @return 结果
     */
    @Override
    public int deleteTSecondCoinConfigByIds(Long[] ids)
    {
        return tSecondCoinConfigMapper.deleteTSecondCoinConfigByIds(ids);
    }

    /**
     * 删除秒合约币种配置信息
     * 
     * @param id 秒合约币种配置主键
     * @return 结果
     */
    @Override
    public int deleteTSecondCoinConfigById(Long id)
    {
        return tSecondCoinConfigMapper.deleteTSecondCoinConfigById(id);
    }
}
