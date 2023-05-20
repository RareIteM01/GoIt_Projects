package com.example.Project_Module08;

class Triangle extends Shape {
    private int area;


    public Triangle(String name, int area) {
        super(name);
        this.area = area;
    }

    @Override
    public void printSize() {
        String size;
        if (area >= 25) {
            size = "Big";
        } else {
            size = "Small";
        }
        System.out.println(size);
    }

    @Override
    public void movingFigure(int x, int y) {
        String resultOfMovingByX;
        String resultOfMovingByY;
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

    public int getArea() {
        return area;
    }
}
