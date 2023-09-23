package org.example;

import org.example.service.SortService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SecondLabApplication {
    public static void main(String[] args ) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Паша");
        stringList.add("Костя");
        stringList.add("Андрей");
        stringList.add("Ян");
        stringList.add("Кирилл");

        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        SortService sortService = context.getBean(SortService.class);

        System.out.println(sortService.doSort(stringList));
    }
}
