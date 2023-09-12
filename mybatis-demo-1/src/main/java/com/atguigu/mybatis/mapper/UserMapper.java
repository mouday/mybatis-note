package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 更新用户信息
     * @return
     */
    int updateUser();

    /**
     * 删除用户数据
     * @return
     */
    int deleteUser();

    /**
     * 查询单个用户
     * @return
     */
    User getUserById();

    /**
     * 查询所有用户
     * @return
     */
    List<User> getAllUser();
}
