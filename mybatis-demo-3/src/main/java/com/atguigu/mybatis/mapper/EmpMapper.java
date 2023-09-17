package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 查询所有员工
     * 用起别名的方式保证字段名与属性名一致
     * @return
     */
    List<Emp> getAllEmp();

    /**
     * 通过自定义映射返回字段
     * @return
     */
    List<Emp> getAllEmpFromResultMap();


    /**
     * 查询员工及其所对应的部门信息
     * @param eid
     * @return
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);


    /**
     * 通过分步查询，员工及所对应的部门信息
     * 分步查询第一步：查询员工信息
     * @param eid
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 分步查询 查询部门及其所有的员工信息
     * 第一步  查询部门信息
     * 第二步  根据查询员工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);

}
