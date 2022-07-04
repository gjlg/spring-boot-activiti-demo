package com.fini.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yun_kai
 * @date 2022年07月04日, 0004
 */
@SpringBootTest
class FixedActivitiDemoTest {

    @Autowired
    private FixedActivitiDemo fixedActivitiDemo;

    @Test
    void deployment() {
        fixedActivitiDemo.deployment();
    }

    @Test
    void startProcess() {
        fixedActivitiDemo.startProcess("applyEvection");
    }

    @Test
    void findPersonalTaskList() {
        //fixedActivitiDemo.findPersonalTaskList("applyEvection", "yun_kai");
        //fixedActivitiDemo.findPersonalTaskList("applyEvection", "jerry");
    }

    @Test
    void completeTask() {
        //fixedActivitiDemo.completeTask("applyEvection", "yun_kai");
        fixedActivitiDemo.completeTask("applyEvection", "rose");
    }
}