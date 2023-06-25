package com.example.module13;

import static com.example.module13.UserCrudApp.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(createUser());
        System.out.println(updateUser(1));
        System.out.println(deleteUser(1));
        System.out.println(getUsers());
        System.out.println(getUserById(1));
        System.out.println(getUserByUsername("Karianne"));
        printOpenTasksForUser(1);
        getCommentsForPostAndWriteToFile(1, 10);
    }
}