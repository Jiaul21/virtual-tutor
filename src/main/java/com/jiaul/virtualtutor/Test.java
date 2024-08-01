package com.jiaul.virtualtutor;

import com.jiaul.virtualtutor.entities.dashbord.DashboardService;

import java.util.Arrays;
import java.util.Base64;


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


        DashboardService dashboardService=new DashboardService();

        System.out.println(dashboardService.DisplayCount(1000));
        System.out.println(dashboardService.DisplayCount(1001));
        System.out.println(dashboardService.DisplayCount(1009));
        System.out.println(dashboardService.DisplayCount(1010));
        System.out.println(dashboardService.DisplayCount(1110));
        System.out.println(dashboardService.DisplayCount(1111));
        System.out.println(dashboardService.DisplayCount(1100));
        System.out.println(dashboardService.DisplayCount(9999));
        System.out.println(dashboardService.DisplayCount(10000));
        System.out.println(dashboardService.DisplayCount(10001));
        System.out.println(dashboardService.DisplayCount(10010));
        System.out.println(dashboardService.DisplayCount(10999));

    }
}
