package com.jiaul.virtualtutor;

import java.io.*;
import java.util.UUID;

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

        String str = "This a txt file";

        try {
            FileWriter file = new FileWriter(path+"hello.txt");
            file.write(str);
            System.out.println("File writing complete");

            file.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(path+"hello.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch(IOException e) {
            System.out.println("Error: " + e);
        }


//        char array[] = new char[100];
//        String s=new String();
//        try {
//            FileReader file = new FileReader(path+"hello.txt");
//            file.read(array);
//            file.close();
//
//            System.out.println(array);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//



    }


}
