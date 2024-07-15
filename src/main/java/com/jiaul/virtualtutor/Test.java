package com.jiaul.virtualtutor;

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

        String path="D:/java spring/University/Backend/virtual-tutor/target/classes/files/pic/";

        String b= Base64.getEncoder().encodeToString(path.getBytes());

        System.out.println(b);

        String s= Arrays.toString(Base64.getDecoder().decode(b.toString()));


        System.out.println("new String is: ");
        System.out.println(s);

    }
}
