package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SqlMapper {
    /**
     * 根据用户名进行模糊查询
     * @param username
     * @return
     */
    List<User> getUserByLikeUsername(@Param("username") String username);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteBatch(@Param("ids") String ids);

    /**
     * 查询指定表中的数据
     * @param tableName
     * @return
     */
    List<User> getUserByTable(@Param("tableName") String tableName);

    /**
     * 新增数据
     * @param user
     */
    void insertUser(User user);
}
