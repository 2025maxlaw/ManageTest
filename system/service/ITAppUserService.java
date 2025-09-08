package com.ruoyi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.ruoyi.system.domain.TAppUser;

/**
 * 玩家用户Service接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface ITAppUserService extends IService<TAppUser>
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
     * 批量删除玩家用户
     * 
     * @param userIds 需要删除的玩家用户主键集合
     * @return 结果
     */
    public int deleteTAppUserByUserIds(Long[] userIds);

    /**
     * 删除玩家用户信息
     * 
     * @param userId 玩家用户主键
     * @return 结果
     */
    public int deleteTAppUserByUserId(Long userId);
}
