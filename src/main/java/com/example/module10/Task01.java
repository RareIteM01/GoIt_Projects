package com.example.module10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task01 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/file.txt"))) {
            String line = reader.readLine();

            while (line != null) {
                if (isValid(line)) {
                    System.out.println(line);
                }
                line = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isValid(String line) {
        return line.matches("^[0-9]{3}-[0-9]{3}-[0-9]{4}$")
                || line.matches("^\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}$");
    }
}
