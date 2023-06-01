package com.example.Project_Module09.stack;

public class MainStack {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();

        stack.push("El 1");
        stack.push("El 2");
        stack.push("El 3");

        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack size after pop: " + stack.size());
        stack.remove(0);
        System.out.println("Stack size after remove: " + stack.size());
        stack.clear();
        System.out.println("Stack size after clear is " + stack.size());
    }
}
