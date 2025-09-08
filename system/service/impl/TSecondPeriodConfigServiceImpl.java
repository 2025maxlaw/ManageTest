package com.ruoyi.system.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TSecondPeriodConfigMapper;
import com.ruoyi.system.domain.TSecondPeriodConfig;
import com.ruoyi.system.service.ITSecondPeriodConfigService;

/**
 * 秒合约币种周期配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TSecondPeriodConfigServiceImpl extends ServiceImpl<TSecondPeriodConfigMapper,TSecondPeriodConfig> implements ITSecondPeriodConfigService
{
    @Autowired
    private TSecondPeriodConfigMapper tSecondPeriodConfigMapper;

    /**
     * 查询秒合约币种周期配置
     * 
     * @param id 秒合约币种周期配置主键
     * @return 秒合约币种周期配置
     */
    @Override
    public TSecondPeriodConfig selectTSecondPeriodConfigById(Long id)
    {
        return tSecondPeriodConfigMapper.selectTSecondPeriodConfigById(id);
    }

    /**
     * 查询秒合约币种周期配置列表
     * 
     * @param tSecondPeriodConfig 秒合约币种周期配置
     * @return 秒合约币种周期配置
     */
    @Override
    public List<TSecondPeriodConfig> selectTSecondPeriodConfigList(TSecondPeriodConfig tSecondPeriodConfig)
    {
        return tSecondPeriodConfigMapper.selectTSecondPeriodConfigList(tSecondPeriodConfig);
    }

    /**
     * 新增秒合约币种周期配置
     * 
     * @param tSecondPeriodConfig 秒合约币种周期配置
     * @return 结果
     */
    @Override
    public int insertTSecondPeriodConfig(TSecondPeriodConfig tSecondPeriodConfig)
    {
        tSecondPeriodConfig.setCreateTime(DateUtils.getNowDate());
        return tSecondPeriodConfigMapper.insertTSecondPeriodConfig(tSecondPeriodConfig);
    }

    /**
     * 修改秒合约币种周期配置
     * 
     * @param tSecondPeriodConfig 秒合约币种周期配置
     * @return 结果
     */
    @Override
    public int updateTSecondPeriodConfig(TSecondPeriodConfig tSecondPeriodConfig)
    {
        tSecondPeriodConfig.setUpdateTime(DateUtils.getNowDate());
        return tSecondPeriodConfigMapper.updateTSecondPeriodConfig(tSecondPeriodConfig);
    }

    /**
     * 批量删除秒合约币种周期配置
     * 
     * @param ids 需要删除的秒合约币种周期配置主键
     * @return 结果
     */
    @Override
    public int deleteTSecondPeriodConfigByIds(Long[] ids)
    {
        return tSecondPeriodConfigMapper.deleteTSecondPeriodConfigByIds(ids);
    }

    /**
     * 删除秒合约币种周期配置信息
     * 
     * @param id 秒合约币种周期配置主键
     * @return 结果
     */
    @Override
    public int deleteTSecondPeriodConfigById(Long id)
    {
        return tSecondPeriodConfigMapper.deleteTSecondPeriodConfigById(id);
    }
}
