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

import java.util.List;

/**
 * 固定Assignee分配人
 *
 * @author : yun_kai
 * @date : 2022年06月30日, 0030 19:06
 */
@Slf4j
@Component
public class FixedActivitiDemo {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    /** 任务流程部署 */
    public void deployment(){
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("processes/evection.bpmn20.xml")
                .addClasspathResource("img/evection.bpmn20.png")
                .name("出差申请流程")
                .deploy();
        log.info("流程部署id:{}", deployment.getId());
        log.info("流程部署名称:{}", deployment.getName());
    }

    /** 启动流程实例 */
    public void startProcess(String processDefinitionKey) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
        log.info("流程定义id:{}",processInstance.getProcessDefinitionId());
        log.info("流程实例id:{}",processInstance.getId());
        log.info("当前活动id:{}",processInstance.getActivityId());
    }

    /** 查询个人代办任务 */
    public void findPersonalTaskList(String processDefinitionKey, String assignee) {
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey(processDefinitionKey)
                .taskAssignee(assignee)
                .list();
        for (Task task : list) {
            log.info("流程实例id:{}",task.getProcessInstanceId());
            log.info("任务id:{}",task.getId());
            log.info("任务负责人:{}",task.getAssignee());
            log.info("任务名称:{}",task.getName());
        }
    }

    /** 流程任务处理 */
    public void completeTask(String processDefinitionKey, String assignee) {
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(processDefinitionKey)
                .taskAssignee(assignee)
                .singleResult();
        taskService.complete(task.getId());
    }
}
