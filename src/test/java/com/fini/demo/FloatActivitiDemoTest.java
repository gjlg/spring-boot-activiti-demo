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
        //floatActivitiDemo.completeTask("5d7c11a4-fb9a-11ec-a301-dafd1dca9926", map);
        //map.put("assignee2", "王五");
        //floatActivitiDemo.completeTask("d57b36a9-fb9a-11ec-861b-dafd1dca9926", map);
        //map.put("assignee3", "赵六");
        //floatActivitiDemo.completeTask("0cbda354-fb9b-11ec-9693-dafd1dca9926", map);
        floatActivitiDemo.completeTask("227af995-fb9b-11ec-8ffd-dafd1dca9926", map);
    }
}