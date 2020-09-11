package com.cloud.mack.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class TestImpl1 implements Test {
    @Override
    public String getall() {
        return "test1";
    }
}
