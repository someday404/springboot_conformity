package com.cloud.mack.springboot.controller;

import com.cloud.mack.springboot.dao.DepartmentDao;
import com.cloud.mack.springboot.entity.Department;
import com.cloud.mack.springboot.service.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private List<Test>  tests;


    @PostConstruct
    public  void tesss(){
        for (Test test : tests) {
            System.out.println(test.getall());
        }


    }

    @ResponseBody
    @RequestMapping("/hell")
    public List<Department> getall(){
        List<Department> getall = departmentDao.getall();
        return getall;
    }




}
