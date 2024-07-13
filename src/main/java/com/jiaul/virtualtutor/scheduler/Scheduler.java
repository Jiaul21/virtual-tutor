package com.jiaul.virtualtutor.scheduler;

import com.jiaul.virtualtutor.authconfig.JwtService;
import com.jiaul.virtualtutor.entities.jwt.JwtToken;
import com.jiaul.virtualtutor.entities.jwt.JwtTokenRepository;
import com.jiaul.virtualtutor.entities.jwt.JwtTokenService;
import com.jiaul.virtualtutor.entities.task.Task;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Data
public class Scheduler {

    public List<Task> incompleteTasks;

    @Autowired
    private JwtTokenRepository jwtTokenRepository;
    @Autowired
    private JwtService jwtService;

    private boolean isChanged=true;     /// initially true, so it will call automatically call after restarting server

//    @Scheduled(fixedRate = 3000)
//    public void job(){
//        System.out.println("scheduled 1: "+new Date());
//        if(isChanged){
//            System.out.println("new test is coming");
//            isChanged=false;
//        }
//    }
//    @Scheduled(fixedRate = 30000)
//    public void job2(){
//        List<JwtToken> jwtTokens=jwtTokenRepository.findAll();
//        jwtTokens.forEach((jwtToken ->{
//            if(jwtService.isTokenExpired(jwtToken.getTokenValue())){
//                jwtToken.setNonRevoked(false);
//                jwtTokenRepository.save(jwtToken);
//            }
//        }));
//    }
}
