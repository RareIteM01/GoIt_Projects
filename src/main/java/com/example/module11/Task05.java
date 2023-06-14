package com.example.module11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task05 {

    public static void main(String[] args) {
        List<String> subjectArr = Arrays.asList("aa", "bb", "cc");
        List<String> numArr = Arrays.asList("2L", "6L", "4L", "5L");
        System.out.println(zipJava9(subjectArr, numArr));
    }

    public static <A> List<A> zipJava9(List<A> as, List<A> bs) {
        return IntStream.range(0, Math.min(as.size(), bs.size()))
                .mapToObj(i -> List.of(as.get(i), bs.get(i)))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
