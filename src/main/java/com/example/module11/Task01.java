package com.example.module11;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task01 {
    public static void main(String[] args) {
        List<String> names = List.of("Nazar", "Danil", "Masha", "Sergey", "Vlad", "Sofia", "Oleksandr");
        String sortedOddNames = returnOddNames(names);
        System.out.println(sortedOddNames);
    }

    public static String returnOddNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> (i) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }
}
