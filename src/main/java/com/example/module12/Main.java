package com.example.module12;

public class Main {
    public static void main(String[] args) {
        int n = 15;
        Task02 task02 = new Task02(n);

        Thread threadA = new Thread(task02::fizz);
        Thread threadB = new Thread(task02::buzz);
        Thread threadC = new Thread(task02::fizzbuzz);
        Thread threadD = new Thread(task02::number);
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("end of program");
    }
}
