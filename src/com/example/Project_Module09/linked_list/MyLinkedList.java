package com.example.Project_Module09.linked_list;

public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> newNode;
        if (tail != null) {
            newNode = new Node<>(value, tail, null);
            tail.next = newNode;
        } else {
            newNode = new Node<>(value, null, null);
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> nodeToRemove;
        if (index == 0) {
            nodeToRemove = head;
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
        } else if (index == size - 1) {
            nodeToRemove = tail;
            tail = tail.previous;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            Node<T> previousNode = head;
            for (int i = 0; i < index - 1; i++) {
                previousNode = previousNode.next;
            }
            nodeToRemove = previousNode.next;
            previousNode.next = nodeToRemove.next;
            nodeToRemove.next.previous = previousNode;
        }
        size--;
        return nodeToRemove.value;
    }


    private static class Node<T> {
        private T value;
        private Node<T> previous;
        private Node<T> next;

        public Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
}
