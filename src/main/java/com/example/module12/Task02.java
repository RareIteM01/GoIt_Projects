package com.example.module12;

public class Task02 {
    private int n;
    private int current;

    public Task02(int n) {
        this.n = n;
        this.current = 1;
    }

    public synchronized void fizz() {
        while (current <= n) {
            if (current % 3 == 0 && current % 5 != 0) {
                System.out.println("fizz");
                current++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public synchronized void buzz() {
        while (current <= n) {
            if (current % 3 != 0 && current % 5 == 0) {
                System.out.println("buzz");
                current++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public synchronized void fizzbuzz() {
        while (current <= n) {
            if (current % 3 == 0 && current % 5 == 0) {
                System.out.println("buzz");
                current++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public synchronized void number() {
        while (current <= n) {
            if (current % 3 != 0 && current % 5 != 0) {
                System.out.println(current);
                current++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
