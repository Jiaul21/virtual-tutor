package com.jiaul.virtualtutor;

import com.jiaul.virtualtutor.test.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.sql.Time;
import java.util.*;

public class Test {

    public static void c(){
        System.out.println((char)34);
    }

    public static void main(String[] args) throws IOException {








        /*
        String type[]={"Skills","Academic"};
        String topic[][]={
                {"Java","Java Script","Html","CSS","React","Spring","Spring Boot","MySQL"},
                {"Math","Physics","Chemistry","Biology","English","Bangla","ICT"}
        };
        int id=0,rand=0;

        int itemFoEachTopic=10;
        for(int t=0;t< type.length;t++){
            for(int m=0;m<topic[t].length;m++){
                for(int i=0;i<itemFoEachTopic;i++){
                    id++;
                    rand=(int)(Math.random()*1000);
                    System.out.println(
                            "{\n\t"
                                    +(char)34+"id"+(char)34+":"+id+",\n\t"
                                    +(char)34+"title"+(char)34+":"+(char)34+"title "+id+(char)34+",\n\t"
                                    +(char)34+"topic"+(char)34+":"+(char)34+topic[t][m]+(char)34+",\n\t"
                                    +(char)34+"type"+(char)34+":"+(char)34+type[t]+(char)34+",\n\t"
                                    +(char)34+"description"+(char)34+":"+(char)34+"description "+id+(char)34+",\n\t"
                                    +(char)34+"mentor"+(char)34+":"+(char)34+"mentor "+id+(char)34+",\n\t"
                                    +(char)34+"price"+(char)34+":"+ rand+",\n\t"
                                    +(char)34+"offer"+(char)34+":"+ rand/10+",\n\t"
                                    +(char)34+"contentType"+(char)34+":"+(char)34+"video"+(char)34+",\n\t"
                                    +(char)34+"content"+(char)34+":"+"{\n\t\t"
                                    +(char)34+"id"+(char)34+":"+id+",\n\t\t"
                                    +(char)34+"name"+(char)34+":"+(char)34+"name "+id+(char)34+",\n"
                            +"},"
                    );
                }
            }
        }*/
    }


}
