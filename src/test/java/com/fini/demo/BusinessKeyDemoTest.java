package com.fini.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yun_kai
 * @date 2022/7/4
 */
@SpringBootTest
class BusinessKeyDemoTest {

    @Autowired
    private BusinessKeyDemo businessKeyDemo;

    @Test
    void deployment() {
        businessKeyDemo.deployment();
    }

    @Test
    void startProcess() {
        Map<String, Object> map = new HashMap<>();
        map.put("assignee0", "zhangsan");
        businessKeyDemo.startProcess("applyEvectionBusiness"
        , "1001", map);
    }

    @Test
    void queryTask() {
        businessKeyDemo.queryTask("applyEvectionBusiness"
                , "1001", "zhangsan");
    }

    @Test
    void completeTask() {
        Map<String, Object> map = new HashMap<>();
        //map.put("assignee1", "lisi");
        //businessKeyDemo.completeTask("30739492-fba1-11ec-a49c-c2991ec55727", map);
        //map.put("assignee2", "wangwu");
        //businessKeyDemo.completeTask("ffad3333-fba1-11ec-a98c-c2991ec55727", map);
        //map.put("assignee3", "zhaoliu");
        //businessKeyDemo.completeTask("41b5cd98-fba2-11ec-951d-c2991ec55727", map);
        businessKeyDemo.completeTask("59c1cf6e-fba2-11ec-9e2e-c2991ec55727", map);
    }
}