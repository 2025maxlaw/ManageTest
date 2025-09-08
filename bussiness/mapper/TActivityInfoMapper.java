package com.ruoyi.bussiness.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import com.ruoyi.bussiness.domain.TActivityInfo;

/**
 * 侧边栏内容Mapper接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface TActivityInfoMapper extends BaseMapper<TActivityInfo>
{
    /**
     * 查询侧边栏内容
     * 
     * @param id 侧边栏内容主键
     * @return 侧边栏内容
     */
    public TActivityInfo selectTActivityInfoById(Long id);

    /**
     * 查询侧边栏内容列表
     * 
     * @param tActivityInfo 侧边栏内容
     * @return 侧边栏内容集合
     */
    public List<TActivityInfo> selectTActivityInfoList(TActivityInfo tActivityInfo);

    /**
     * 新增侧边栏内容
     * 
     * @param tActivityInfo 侧边栏内容
     * @return 结果
     */
    public int insertTActivityInfo(TActivityInfo tActivityInfo);

    /**
     * 修改侧边栏内容
     * 
     * @param tActivityInfo 侧边栏内容
     * @return 结果
     */
    public int updateTActivityInfo(TActivityInfo tActivityInfo);

    /**
     * 删除侧边栏内容
     * 
     * @param id 侧边栏内容主键
     * @return 结果
     */
    public int deleteTActivityInfoById(Long id);

    /**
     * 批量删除侧边栏内容
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTActivityInfoByIds(Long[] ids);
}
