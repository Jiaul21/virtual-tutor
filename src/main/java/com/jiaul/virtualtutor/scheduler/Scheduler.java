package com.jiaul.virtualtutor.scheduler;

import com.jiaul.virtualtutor.authconfig.JwtService;
import com.jiaul.virtualtutor.entities.jwt.JwtToken;
import com.jiaul.virtualtutor.entities.jwt.JwtTokenRepository;
import com.jiaul.virtualtutor.entities.task.Task;
import com.jiaul.virtualtutor.entities.task.TaskService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Data
public class Scheduler {

    @Autowired
    private JwtTokenRepository jwtTokenRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ScheduledService scheduledService;

    public Set<Task> incompleteTasks = new HashSet<>();
    private boolean isChanged = true;     /// initially true, so it will call automatically call after restarting server

    @Scheduled(fixedDelay = 1000)
    public void job() {
        if (isChanged) {
            incompleteTasks.addAll(taskService.getAllIncompleteTask());
            isChanged = false;
        }
        incompleteTasks.forEach(task -> {
            if (task.getDateTime().before(new Date())) {
                if (task.getTaskType().equals("ADD_MODULE_NOTIFY") && scheduledService.isEmailSent(task)) {
                    taskService.updateTask(task);
                    incompleteTasks.remove(task);
                }
            }
        });

    }

//    @Scheduled(fixedRate = 10000)
//    public void job2() {
//        List<JwtToken> jwtTokens = jwtTokenRepository.findAll();
//        jwtTokens.forEach((jwtToken -> {
//            if (jwtService.isTokenExpired(jwtToken.getTokenValue())) {
//                jwtToken.setNonRevoked(false);
//                jwtTokenRepository.save(jwtToken);
//            }
//        }));
//    }
}
