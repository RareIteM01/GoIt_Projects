package com.example.Project_Module08;

class Circle extends Shape {
    private int diameter;

    public Circle(String name, int diameter) {
        super(name);
        this.diameter = diameter;
    }

    @Override
    public void printSize() {
        String size;
        if (diameter / 2 < 25) {
            size = "Small";
        } else {
            size = "Big";
        }
        System.out.println(size);
    }

    @Override
    public void movingFigure(int x, int y) {
        String resultOfMovingByX = "";
        String resultOfMovingByY = "";
        if (x < 0) {
            resultOfMovingByX = "Figure moved to left side by " + x + " units";
        } else {
            resultOfMovingByX = "Figure moved to right side by " + x + " units";
        }
        if (y < 0) {
            resultOfMovingByY = "Figure moved down by " + y + " units";
        } else {
            resultOfMovingByY = "Figure moved up by " + y + " units";
        }
        System.out.println(resultOfMovingByX + " " + resultOfMovingByY);
    }

    public int getDiameter() {
        return diameter;
    }
}
