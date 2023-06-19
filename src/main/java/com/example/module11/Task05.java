package com.example.module11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task05 {

    public static void main(String[] args) {
        List<String> subjectArr = Arrays.asList("aa", "bb", "cc", "ss");
        List<String> numArr = Arrays.asList("2L", "4L", "5L");
//        System.out.println(zipJava9(subjectArr, numArr));
        zipJava9(subjectArr.stream(), numArr.stream())
                .forEach(System.out::println);
    }

//    public static <A> List<A> zipJava9(List<A> as, List<A> bs) {
//        return IntStream.range(0, Math.min(as.size(), bs.size()))
//                .mapToObj(i -> List.of(as.get(i), bs.get(i)))
//                .flatMap(List::stream)
//                .collect(Collectors.toList());
//    }

    public static <A> Stream<A> zipJava9(Stream<A> as, Stream<A> bs) {
        List<A> asList = as.toList();
        List<A> bsList = bs.toList();
        return IntStream.range(0, Math.min(asList.size(), bsList.size()))
                .mapToObj(i -> List.of(asList.get(i), bsList.get(i)))
                .flatMap(List::stream);
    }
}
