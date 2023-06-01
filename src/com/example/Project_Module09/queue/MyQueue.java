package com.example.Project_Module09.queue;

public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;


    public void add(T value) {
        Node newNode = new Node(value, null);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        T firstElenent = head.value;
        head = head.next;
        size--;
        return firstElenent;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if(head == null) {
            return null;
        }
        return head.value;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
