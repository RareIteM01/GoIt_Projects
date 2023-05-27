package com.example.Project_Module09.array_list;

import com.example.Project_Module09.array_list.MyArrayList;

public class MainArrayList {
    public static void main(String[] args) {
        MyArrayList<String > myArrayList = new MyArrayList<>();
        for(int i = 0; i < 15; i++) {
            myArrayList.add("A" + i);
        }

        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }

        System.out.println();
        System.out.println("Size of collection " + myArrayList.size());
        int getIndex = 2;
        System.out.println("Getting an element by index " + getIndex + ": " + myArrayList.get(getIndex));
        int index = 4;
        System.out.println("Removing " + index + " element");
        myArrayList.remove(index);
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
        System.out.println();
        System.out.println("Size of collection after removing an element " + myArrayList.size());
        myArrayList.clear();
        System.out.println("Size of collection after clearing " + myArrayList.size());
    }
}
