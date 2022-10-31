package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        String[]words = new String[]{                 //task1
                "rabbit",
                "cat",
                "dog",
                "cat",
                "cat",
                "zebra",
                "hippopotamus",
                "hippopotamus",
                "hippopotamus",
                "unicorn",
                "turtle",
                "cat",
                "hare"
        };
        List<String> listWords = new ArrayList<>(Arrays.asList(words));

        Map<String,Long> wordsByCount = listWords.stream()
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

        String prevalentWord = wordsByCount.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();

        System.out.println(prevalentWord);


        Employee[] employees = new Employee[]{                   //task2
                new Employee("Вася", 44, 12000),
                new Employee("Пётр", 45, 100000),
                new Employee("Егор", 68, 8500),
                new Employee("Илья", 19, 100),
                new Employee("Фёдор", 32, 80000),
                new Employee("Директор Герасим", 56, 2000000),
                new Employee("Александр", 40, 20000),
        };
        Stream<Employee> stream1 = Stream.of(employees);
        List<Employee> list1 = Arrays.asList(employees);
        double sum = stream1.collect(Collectors.averagingInt(Employee::getMoney));

        System.out.println("Среднее арифметическое зарплат: " + Math.round(sum));

        int n = 3;
        System.out.println(list1.stream().sorted((e1, e2) -> e2.getAge() - e1.getAge())  //task 3
                .limit(n)
                .map(Employee::getName)
                .collect(Collectors.toList()));
    }
}
