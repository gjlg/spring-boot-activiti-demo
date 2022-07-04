package com.fini.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yun_kai
 * @date 2022年07月04日, 0004
 */
@SpringBootTest
class FloatActivitiDemoTest {

    @Autowired
    private FloatActivitiDemo floatActivitiDemo;

    @Test
    void deployment() {
        floatActivitiDemo.deployment();
    }

    @Test
    void startProcess() {
        Map<String, Object> map = new HashMap<>();
        map.put("assignee0", "张三");
        floatActivitiDemo.startProcess("applyEvectionPlus", map);
    }

    @Test
    void findPersonalTaskList() {
        floatActivitiDemo.findPersonalTaskList("applyEvectionPlus", "张三");
    }

    @Test
    void completeTask() {
        Map<String, Object> map = new HashMap<>();
        //map.put("assignee1", "李四");
        //floatActivitiDemo.completeTask("9c1f5525-fb7f-11ec-aee3-18c04d9e97ac", map);
        //map.put("assignee2", "王五");
        //floatActivitiDemo.completeTask("eecb5044-fb80-11ec-bf8e-18c04d9e97ac", map);
        //map.put("assignee3", "赵六");
        //floatActivitiDemo.completeTask("3b902ccf-fb81-11ec-9ff4-18c04d9e97ac", map);
        floatActivitiDemo.completeTask("04f46b4f-fb82-11ec-9cd1-18c04d9e97ac", map);
    }
}