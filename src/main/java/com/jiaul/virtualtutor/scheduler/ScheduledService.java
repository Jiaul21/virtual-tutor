package com.jiaul.virtualtutor.scheduler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ScheduledService {

    @Autowired
    private Scheduler scheduler;

    @GetMapping("/scheduler")
    public void scheduler(){
        scheduler.setChanged(true);
    }
}
