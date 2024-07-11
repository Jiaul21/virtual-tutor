package com.jiaul.virtualtutor;

import com.jiaul.virtualtutor.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

//@Configuration
public class Test {

//    @Value("${openai.api.key}")
//    private String openaiApiKey;
//
//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getInterceptors().add(((request, body, execution) -> {
////            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
//            return execution.execute(request, body);
//        }));
//        return restTemplate;
//    }



//    public static void c(){
//        System.out.println((char)34);
//    }

    public static void main(String[] args) {


       RoleEnum s= RoleEnum.valueOf("STUDENT");
        System.out.println(RoleEnum.STUDENT);

       if(s.equals(RoleEnum.STUDENT)){
           System.out.println("matched");
       }
       else{
           System.out.println("not matched");
       }
        System.out.println("finished");

    }


}
