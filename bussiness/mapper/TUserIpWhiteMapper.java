package com.ruoyi.bussiness.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import com.ruoyi.bussiness.domain.TUserIpWhite;

/**
 * 客户端登录IP白名单Mapper接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface TUserIpWhiteMapper extends BaseMapper<TUserIpWhite>
{
    /**
     * 查询客户端登录IP白名单
     * 
     * @param id 客户端登录IP白名单主键
     * @return 客户端登录IP白名单
     */
    public TUserIpWhite selectTUserIpWhiteById(Long id);

    /**
     * 查询客户端登录IP白名单列表
     * 
     * @param tUserIpWhite 客户端登录IP白名单
     * @return 客户端登录IP白名单集合
     */
    public List<TUserIpWhite> selectTUserIpWhiteList(TUserIpWhite tUserIpWhite);

    /**
     * 新增客户端登录IP白名单
     * 
     * @param tUserIpWhite 客户端登录IP白名单
     * @return 结果
     */
    public int insertTUserIpWhite(TUserIpWhite tUserIpWhite);

    /**
     * 修改客户端登录IP白名单
     * 
     * @param tUserIpWhite 客户端登录IP白名单
     * @return 结果
     */
    public int updateTUserIpWhite(TUserIpWhite tUserIpWhite);

    /**
     * 删除客户端登录IP白名单
     * 
     * @param id 客户端登录IP白名单主键
     * @return 结果
     */
    public int deleteTUserIpWhiteById(Long id);

    /**
     * 批量删除客户端登录IP白名单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTUserIpWhiteByIds(Long[] ids);
}
