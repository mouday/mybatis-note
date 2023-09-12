package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 根据id查询用户信息
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有用户信息
     */
    List<User> getAllUser();

    /**
     * 查询用户信息的总记录数
     */
    Integer getCount();

    /**
     * 根据用户id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有用户信息为map集合
     * @return
     */
    List<Map<String, Object>> getAllUserToMap();

    /**
     * 查询所有用户信息为MapKey集合
     * @return
     */
    @MapKey("id")
    Map<String, Object> getAllUserToMapKey();
}

