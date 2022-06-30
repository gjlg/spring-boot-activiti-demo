package com.fini.demo;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : yun_kai
 * @date : 2022年06月30日, 0030 19:06
 */
public class ActivitiDemo {

    @Autowired
    private RepositoryService repositoryService;

    public void testDeployment() {
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("img/evection.bpmn20.png")
                .addClasspathResource("processes/evection.bpmn20.xml")
                .name("出差申请流程")
                .deploy();

        System.out.println("流程部署id:" + deployment.getId());
        System.out.println("流程部署名称:" + deployment.getName());
    }
}
