package com.yjg123.projectmanager.config;
import com.yjg123.projectmanager.mapper.CronMapper;
import com.yjg123.projectmanager.mapper.StudentTaskMapper;
import com.yjg123.projectmanager.mapper.TeamTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
/**
 * @author JackYjg
 * @date 2020/12/8 13:13
 */


@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class DynamicScheduleTask implements SchedulingConfigurer {


    @Autowired
    private CronMapper cronMapper;

    @Autowired
    StudentTaskMapper studentTaskMapper;

    @Autowired
    TeamTaskMapper teamTaskMapper;

    /**
     * 执行定时任务.
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        studentTaskMapper.updateState();
        teamTaskMapper.updateState();
        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> {System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime()+"更新任务状态");
                    studentTaskMapper.updateState();
                    teamTaskMapper.updateState();
                },
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = cronMapper.getCron();
                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(cron)) {
                        System.out.println("定时器数据库数据为空或格式错误");
                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }

}



//        每隔5秒执行一次：*/5 * * * * ?
//
//        每隔1分钟执行一次：0 */1 * * * ?
//
//        每天23点执行一次：0 0 23 * * ?
//
//        每天凌晨1点执行一次：0 0 1 * * ?
//
//        每月1号凌晨1点执行一次：0 0 1 1 * ?
//
//        每月最后一天23点执行一次：0 0 23 L * ?
//
//        每周星期天凌晨1点实行一次：0 0 1 ? * L
//
//        在26分、29分、33分执行一次：0 26,29,33 * * * ?
//
//        每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?
