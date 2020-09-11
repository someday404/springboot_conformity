package com.cloud.mack.springboot.dao;

import com.cloud.mack.springboot.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentDao {
    List<Department> getall();
}
