package com.jiaul.virtualtutor.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 2000)
    public void job(){
        System.out.print("scheduled: ");
//        System.out.println(new SimpleDateFormat());
    }
}
