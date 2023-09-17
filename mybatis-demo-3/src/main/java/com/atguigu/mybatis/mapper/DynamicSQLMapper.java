package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    /**
     * 多条件查询
     */
    List<Emp> getEmpByIfCondition(Emp emp);

    List<Emp> getEmpByWhereCondition(Emp emp);

    List<Emp> getEmpByTrimCondition(Emp emp);

    List<Emp> getEmpByChooseCondition(Emp emp);

    List<Emp> getEmpByForeachCondition(@Param("eids") List<Integer> ids);

    List<Emp> getEmpByForeachOrCondition(@Param("eids") List<Integer> ids);

    int insertMoreByList(@Param("emps") List<Emp> emps);

    List<Emp> getAllEmp();
}
