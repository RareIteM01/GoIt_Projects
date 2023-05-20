package com.example.Project_Module08;

class Square extends Shape {
    private int width;
    private int height;

    public Square(String name, int width, int height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public void printSize() {
        String size;
        if (width >= 25 && height >= 25) {
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
