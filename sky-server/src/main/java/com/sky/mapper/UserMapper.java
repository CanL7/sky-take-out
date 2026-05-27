package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;

/**
 * 用户数据访问接口
 */
@Mapper
public interface UserMapper {

    /**
     * 根据openid查询用户
     *
     * @param openid
     * @return
     */
    @Select("select * from user where openid = #{openid}")
    User findByOpenid(String openid);

    /**
     * 插入用户数据
     *
     * @param user
     */
    @Insert("insert into user (openid, create_time) values (#{openid}, #{createTime})")
    void insert(User user);

    @Select("select * from user where id = #{id}")
    User getById(Long id);
}