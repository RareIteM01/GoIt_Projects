package com.example.module11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task03 {
    public static void main(String[] args) {
        String[] strings = {"1, 2, 0, 9, 0", "6, 8", "4, 5"};
        String digits = "5 6 7";
        String[] array = digits.split(" ");
        String result = Arrays.stream(strings)
                .flatMap(element -> Arrays.stream(element.split(", ")))
                .sorted()
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
