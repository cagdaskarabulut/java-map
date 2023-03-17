package com.karabulut.javamap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class JavaMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaMapApplication.class, args);
        exerciseMap();
    }

    public static void exerciseMap(){
        //create map
        System.out.println("Java Map Examples");
        Map<String ,Integer> map=new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);
        map.put("E",5);

        //sum with for loop before 1.8
        Collection<Integer> values = map.values();
        int total=0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            total+=map.get(entry.getKey());
        }
        System.out.println("before 1.8 sum = " + total);

        //sum with for loop after 1.8
        List<Integer> list = new ArrayList(map.values());
        Integer total2 = list.stream().reduce(0, Integer::sum);
        System.out.println("after 1.8 sum = " + total);


    }
}
