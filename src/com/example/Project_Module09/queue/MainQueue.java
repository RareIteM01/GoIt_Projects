package com.example.Project_Module09.queue;

public class MainQueue {
    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("element 1");
        myQueue.add("element 2");
        myQueue.add("element 3");
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println();
        myQueue.add("element 3");
        myQueue.add("element 4");
        System.out.println("Size of collection is " + myQueue.size());
        System.out.println("First element is " + myQueue.peek());
        System.out.println();
        myQueue.clear();
        System.out.println("Size if collection after deleting all elements is " + myQueue.size());
    }
}
