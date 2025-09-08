package com.ruoyi.system.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TAppUserMapper;
import com.ruoyi.system.domain.TAppUser;
import com.ruoyi.system.service.ITAppUserService;

/**
 * 玩家用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class TAppUserServiceImpl extends ServiceImpl<TAppUserMapper,TAppUser> implements ITAppUserService
{
    @Autowired
    private TAppUserMapper tAppUserMapper;

    /**
     * 查询玩家用户
     * 
     * @param userId 玩家用户主键
     * @return 玩家用户
     */
    @Override
    public TAppUser selectTAppUserByUserId(Long userId)
    {
        return tAppUserMapper.selectTAppUserByUserId(userId);
    }

    /**
     * 查询玩家用户列表
     * 
     * @param tAppUser 玩家用户
     * @return 玩家用户
     */
    @Override
    public List<TAppUser> selectTAppUserList(TAppUser tAppUser)
    {
        return tAppUserMapper.selectTAppUserList(tAppUser);
    }

    /**
     * 新增玩家用户
     * 
     * @param tAppUser 玩家用户
     * @return 结果
     */
    @Override
    public int insertTAppUser(TAppUser tAppUser)
    {
        tAppUser.setCreateTime(DateUtils.getNowDate());
        return tAppUserMapper.insertTAppUser(tAppUser);
    }

    /**
     * 修改玩家用户
     * 
     * @param tAppUser 玩家用户
     * @return 结果
     */
    @Override
    public int updateTAppUser(TAppUser tAppUser)
    {
        tAppUser.setUpdateTime(DateUtils.getNowDate());
        return tAppUserMapper.updateTAppUser(tAppUser);
    }

    /**
     * 批量删除玩家用户
     * 
     * @param userIds 需要删除的玩家用户主键
     * @return 结果
     */
    @Override
    public int deleteTAppUserByUserIds(Long[] userIds)
    {
        return tAppUserMapper.deleteTAppUserByUserIds(userIds);
    }

    /**
     * 删除玩家用户信息
     * 
     * @param userId 玩家用户主键
     * @return 结果
     */
    @Override
    public int deleteTAppUserByUserId(Long userId)
    {
        return tAppUserMapper.deleteTAppUserByUserId(userId);
    }
}
