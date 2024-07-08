package com.jiaul.virtualtutor.scheduler;

import com.jiaul.virtualtutor.entities.task.Task;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Scheduler {

    public List<Task> incompleteTasks;


    @Scheduled(fixedRate = 500)
    public void job(){
        System.out.println("scheduled 1: "+new Date());
    }
    @Scheduled(fixedRate = 500)
    public void job2(){
        System.out.println("scheduled 2: "+new Date());
    }
}
