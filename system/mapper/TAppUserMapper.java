package com.ruoyi.system.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import com.ruoyi.system.domain.TAppUser;

/**
 * 玩家用户Mapper接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface TAppUserMapper extends BaseMapper<TAppUser>
{
    /**
     * 查询玩家用户
     * 
     * @param userId 玩家用户主键
     * @return 玩家用户
     */
    public TAppUser selectTAppUserByUserId(Long userId);

    /**
     * 查询玩家用户列表
     * 
     * @param tAppUser 玩家用户
     * @return 玩家用户集合
     */
    public List<TAppUser> selectTAppUserList(TAppUser tAppUser);

    /**
     * 新增玩家用户
     * 
     * @param tAppUser 玩家用户
     * @return 结果
     */
    public int insertTAppUser(TAppUser tAppUser);

    /**
     * 修改玩家用户
     * 
     * @param tAppUser 玩家用户
     * @return 结果
     */
    public int updateTAppUser(TAppUser tAppUser);

    /**
     * 删除玩家用户
     * 
     * @param userId 玩家用户主键
     * @return 结果
     */
    public int deleteTAppUserByUserId(Long userId);

    /**
     * 批量删除玩家用户
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTAppUserByUserIds(Long[] userIds);
}
