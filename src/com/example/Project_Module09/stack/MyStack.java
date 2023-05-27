package com.example.Project_Module09.stack;

public class MyStack<T> {
    private Node<T> top;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node<>(value, top);
        top = newNode;
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return pop();
        }

        Node<T> prevNode = null;
        Node<T> currentNode = top;
        for (int i = 0; i < index; i++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        T removedValue = currentNode.value;
        prevNode.next = currentNode.next;
        size--;
        return removedValue;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (top == null) {
            throw new IllegalStateException();
        }
        return top.value;
    }

    public T pop() {
        if (top == null) {
            throw new IllegalStateException();
        }

        T poppedValue = top.value;
        top = top.next;
        size--;
        return poppedValue;
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
