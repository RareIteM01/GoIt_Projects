package com.example.Project_Module08;

abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }


    public abstract void printSize();

    public abstract void movingFigure(int x, int y);

    public String getName() {
        return name;
    }
}
