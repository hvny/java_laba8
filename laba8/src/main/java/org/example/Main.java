package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> listWords = Arrays.asList( //task1
                "rabbit",
                "rabbit",
                "rabbit",
                "rabbit",
                "ant",
                "ant",
                "ant",
                "ant",
                "dog",
                "cat",
                "cat",
                "cat",
                "cat",
                "zebra",
                "unicorn",
                "turtle",
                "hare"
        );

        String mostFrequentWord = listWords.stream().sorted()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .stream()
                .collect(Collectors.joining(", ", "Самое часто повторяющееся слово: ", ""));


        System.out.println(mostFrequentWord);


        Contact[] contacts = {                                   //task2
                new Contact("Вася", "Васин", 50, "1111"),
                new Contact("Борис", "Гребенщиков", 69, "2222"),
                new Contact("SpongeBob", "SquarePants ", 30, "3333"),
                new Contact("Алла", "Пугачёва", 100, "2222"),
                new Contact("Фёдор", "Конюхов",100, "5555"),
                new Contact("Пеппа", "Свинка", 9, "2222")
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ряд цифр: ");
        String pnoneNumber = scanner.nextLine();

        List<String> matchingContacts = Arrays.stream(contacts)
                .filter(contact -> contact.getPhone().equals(pnoneNumber))
                .map(Contact::getFirstName)
                .sorted()
                .collect(Collectors.toList()); //добавить вывод в консоль внутри stream

        if (matchingContacts.isEmpty()) {
            System.out.println("Такого номера нет в массиве.");
        } else {
            System.out.println(matchingContacts.size() + " контактов зовут: " + String.join(", ", matchingContacts));
        }
    }
}
