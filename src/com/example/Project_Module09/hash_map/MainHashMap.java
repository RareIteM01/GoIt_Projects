package com.example.Project_Module09.hash_map;

public class MainHashMap {
    public static void main(String[] args) {
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();

        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        System.out.println("Value for key 'two': " + hashMap.get("two"));
        hashMap.put("two", 20);
        System.out.println("Value for key 'two' after update: " + hashMap.get("two"));
        hashMap.remove("two");
        System.out.println("Value for key 'two' after removal: " + hashMap.get("two"));
        System.out.println("HashMap size: " + hashMap.size());
        hashMap.clear();
        System.out.println("HashMap size after clear: " + hashMap.size());
    }
}
