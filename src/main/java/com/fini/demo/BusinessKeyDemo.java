package com.fini.demo;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 添加业务标识BusinessKey
 *
 * @author yun_kai
 * @date 2022/7/4
 */
@Component
@Slf4j
public class BusinessKeyDemo {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    /** 流程部署 */
    public void deployment() {
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("processes/evection-business-key.bpmn20.xml")
                .addClasspathResource("img/evection-business-key.bpmn20.png")
                .name("出差申请流程BUSINESS_KEY")
                .deploy();
        log.info("流程部署id:{}", deployment.getId());
        log.info("流程部署名称:{}", deployment.getName());
    }

    /** 启动流程实例 */
    public void startProcess(String processInstanceKey, String businessKey, Map<String, Object> map) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processInstanceKey, businessKey, map);
        log.info("流程定义id:{}",processInstance.getProcessDefinitionId());
        log.info("流程实例id:{}",processInstance.getId());
        log.info("当前活动id:{}",processInstance.getActivityId());
    }

    /** 查询任务 */
    public void queryTask(String processInstanceKey, String businessKey, String assignee) {
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(processInstanceKey)
                .processInstanceBusinessKey(businessKey)
                .taskAssignee(assignee)
                .singleResult();
        log.info("流程实例id:{}",task.getProcessInstanceId());
        log.info("任务id:{}",task.getId());
        log.info("任务负责人:{}",task.getAssignee());
        log.info("任务名称:{}",task.getName());
        log.info("任务类型:{}",task.getCategory());
    }

    /** 完成任务 */
    public void completeTask(String taskId, Map<String, Object> map) {
        taskService.complete(taskId, map);
    }

}
