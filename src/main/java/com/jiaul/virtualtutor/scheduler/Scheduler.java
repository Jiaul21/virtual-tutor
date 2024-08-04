package com.jiaul.virtualtutor.scheduler;

import com.jiaul.virtualtutor.authconfig.JwtService;
import com.jiaul.virtualtutor.entities.jwt.JwtTokenRepository;
import com.jiaul.virtualtutor.entities.task.Task;
import com.jiaul.virtualtutor.entities.task.TaskService;
import com.jiaul.virtualtutor.enums.TaskType;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
@Data
public class Scheduler {

    public Set<Task> incompleteTasks = new HashSet<>();

    @Autowired
    private JwtTokenRepository jwtTokenRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ScheduledService scheduledService;

    private boolean isChanged = true;     /// initially true, so it will call automatically call after restarting server

    @Scheduled(fixedDelay = 1000)
    public void job() {
        if (isChanged) {
            incompleteTasks.addAll(taskService.getAllIncompleteTask());     // add only unique task
            isChanged = false;
        }
        incompleteTasks.forEach(task -> {
            if (task.getDateTime().before(new Date())) {
                executeTask(task);
                incompleteTasks.remove(task);
            }
        });
    }

    public void executeTask(Task task) {
        if (task.getTaskType().equals(TaskType.ADD_MODULE_NOTIFY.toString()) && scheduledService.isADD_MODULE_NOTIFY_EmailSent(task)) {
            task.setDone(true);
            taskService.updateTask(task);
        } else if (task.getTaskType().equals(TaskType.MEETING_NOTIFY.toString()) && scheduledService.isMEETING_NOTIFY_EmailSent(task)) {
            task.setDone(true);
            taskService.updateTask(task);
        }
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
