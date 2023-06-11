package com.example.module10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task03 {
    public static void main(String[] args) {
        String path = "src/resources/words.txt";
        Map<String, Integer> wordFrequency = countWord(path);

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            String word = entry.getKey();
            int number = entry.getValue();
            System.out.println(word + " " + number);
        }
    }

    public static Map<String, Integer> countWord(String path) {
        Map<String, Integer> wordFreq = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.trim().split("\s++");
                for (String word : words) {
                    wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
                }

            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return wordFreq;
    }
}
