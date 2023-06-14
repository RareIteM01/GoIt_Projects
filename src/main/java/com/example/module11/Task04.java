package com.example.module11;

import java.util.stream.Stream;

public class Task04 {
    public static void main(String[] args) {
        long seed = 3215L;
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        Stream<Long> longStream = infiniteStream(seed, a, c, m);
        longStream.limit(20)
                .forEach(element -> {
                    System.out.println("seed: " + seed + ", a: " + a + ", c: " + c + ",m: " + m + ",element: " + element);
                });
    }

    public static Stream<Long> infiniteStream(long seed, long a, long c, long m) {
        return Stream.iterate(seed, n -> (a * n + c) % m);
    }
}
