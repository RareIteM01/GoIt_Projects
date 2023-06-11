package com.example.module10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class GsonTest {
    private static final String INPUT_FILE = "src/main/resources/file2.txt";
    private static final String OUTPUT_FILE = "src/main/resources/user.json";
    public static final int NAME_INDEX = 0;
    public static final int AGE_INDEX = 1;
    public static final String SEPARATOR = "\\s+";
    public static final int HEADER_LINE = 1;

    public static void main(String[] args) {
        List<String> allLines = readLinesFromTxtFile();
        List<User> allUsers = parseUsers(allLines);
        saveUsersToJsonFile(allUsers);
    }

    private static List<String> readLinesFromTxtFile() {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Path.of(INPUT_FILE));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return lines;
    }

    private static List<User> parseUsers(List<String> lines) {
        List<User> allUsers = new ArrayList<>();
        for (int i = HEADER_LINE; i < lines.size(); i++) {
            String[] data = lines.get(i).split(SEPARATOR);

            String name = data[NAME_INDEX];
            int age = Integer.parseInt(data[AGE_INDEX]);
            User user = new User(name, age);
            allUsers.add(user);
        }
        return allUsers;
    }

    private static void saveUsersToJsonFile(List<User> users) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}