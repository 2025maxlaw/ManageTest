package com.ruoyi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.ruoyi.system.domain.TSecondCoinConfig;

/**
 * 秒合约币种配置Service接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface ITSecondCoinConfigService extends IService<TSecondCoinConfig>
{
    /**
     * 查询秒合约币种配置
     * 
     * @param id 秒合约币种配置主键
     * @return 秒合约币种配置
     */
    public TSecondCoinConfig selectTSecondCoinConfigById(Long id);

    /**
     * 查询秒合约币种配置列表
     * 
     * @param tSecondCoinConfig 秒合约币种配置
     * @return 秒合约币种配置集合
     */
    public List<TSecondCoinConfig> selectTSecondCoinConfigList(TSecondCoinConfig tSecondCoinConfig);

    /**
     * 新增秒合约币种配置
     * 
     * @param tSecondCoinConfig 秒合约币种配置
     * @return 结果
     */
    public int insertTSecondCoinConfig(TSecondCoinConfig tSecondCoinConfig);

    /**
     * 修改秒合约币种配置
     * 
     * @param tSecondCoinConfig 秒合约币种配置
     * @return 结果
     */
    public int updateTSecondCoinConfig(TSecondCoinConfig tSecondCoinConfig);

    /**
     * 批量删除秒合约币种配置
     * 
     * @param ids 需要删除的秒合约币种配置主键集合
     * @return 结果
     */
    public int deleteTSecondCoinConfigByIds(Long[] ids);

    /**
     * 删除秒合约币种配置信息
     * 
     * @param id 秒合约币种配置主键
     * @return 结果
     */
    public int deleteTSecondCoinConfigById(Long id);
}
