package com.example.module12;

public class Task01 {
    public static void main(String[] args) {
        displayTimeFromStart();

        displayMessageAfterFiveSec();
    }

    private static void displayTimeFromStart() {
        Thread firstThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();

            while (true) {
                long expiredTime = System.currentTimeMillis() - startTime;
                System.out.println("Elapsed time is: " + expiredTime / 1000 + " seconds");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        });
        firstThread.start();
    }

    private static void displayMessageAfterFiveSec() {
        Thread secondThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("5 seconds have passed");
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        });
        secondThread.start();
    }
}
