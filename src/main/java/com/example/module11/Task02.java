package com.example.module11;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task02 {
    public static void main(String[] args) {
        List<String> names = List.of("Nazar", "Danil", "Masha", "Sergey", "Vlad", "Sofia", "Oleksandr");
        List<String> result = sortAndUpperCase(names);
        System.out.println(result);
    }

    public static List<String> sortAndUpperCase(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
