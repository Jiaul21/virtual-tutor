package com.jiaul.virtualtutor.scheduler;

import com.jiaul.virtualtutor.entities.task.Task;
import lombok.Data;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Data
public class Scheduler {

    public List<Task> incompleteTasks;

    private boolean isChanged=true;     /// initially true, so it will call automatically call after restarting server

//    @Scheduled(fixedRate = 3000)
//    public void job(){
//        System.out.println("scheduled 1: "+new Date());
//        if(isChanged){
//            System.out.println("new test is coming");
//            isChanged=false;
//        }
//    }
//    @Scheduled(fixedRate = 500)
//    public void job2(){
//        System.out.println("scheduled 2: "+new Date());
//    }
}
