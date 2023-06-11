package com.example.Project_Module08;

class Parallelogram extends Shape {
    private int firstDiagonal;
    private int secondDiagonal;

    public Parallelogram(String name, int firstDiagonal, int secondDiagonal) {
        super(name);
        this.firstDiagonal = firstDiagonal;
        this.secondDiagonal = secondDiagonal;
    }

    @Override
    public void printSize() {
        String size;
        if (firstDiagonal <= 25 && secondDiagonal <= 25) {
            size = "Small";
        } else {
            size = "Big";
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

    public int getFirstDiagonal() {
        return firstDiagonal;
    }

    public int getSecondDiagonal() {
        return secondDiagonal;
    }
}
