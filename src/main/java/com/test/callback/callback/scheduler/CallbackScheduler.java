package com.test.callback.callback.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;

@Service
public class CallbackScheduler {

    @PostConstruct
    void initScheduler() {
        JobDetail refreshTokenJob = JobBuilder.newJob(RefreshTokenJob.class)
                .withIdentity("refreshTokenJob")
                .build();
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE, 1);
        tomorrow.set(Calendar.HOUR_OF_DAY, 0);
        tomorrow.set(Calendar.MINUTE, 0);
        tomorrow.set(Calendar.SECOND, 0);
        tomorrow.set(Calendar.MILLISECOND, 0);
        Trigger refreshTokenTrigger = TriggerBuilder.newTrigger()
                .withIdentity("refreshTokenTrigger")
                .startAt(tomorrow.getTime())
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInHours(24)
                        .repeatForever())
                .forJob("refreshTokenJob")
                .build();
        try {
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(refreshTokenJob, refreshTokenTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
