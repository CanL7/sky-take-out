package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.sky.vo.UserLoginVO;
import org.springframework.stereotype.Service;

/**
 * 用户服务接口
 */


public interface UserService {

    /**
     * 用户登录
     *
     * @param userLoginDTO
     * @return
     */
    UserLoginVO login(UserLoginDTO userLoginDTO);

    /**
     * 根据openid查询用户
     *
     * @param openid
     * @return
     */
    User findByOpenid(String openid);

    /**
     * 新增用户
     *
     * @param user
     */
    void save(User user);
}