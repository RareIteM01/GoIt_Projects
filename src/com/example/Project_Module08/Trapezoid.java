package com.example.Project_Module08;

class Trapezoid extends Shape {
    private int topSide;
    private int bottomSide;
    private int midleLine;

    public Trapezoid(String name, int topSide, int bottomSide, int midleLine) {
        super(name);
        this.topSide = topSide;
        this.bottomSide = bottomSide;
        this.midleLine = midleLine;
    }

    @Override
    public void printSize() {
        String size;
        if (midleLine * 2 < topSide + bottomSide) {
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

    public int getTopSide() {
        return topSide;
    }

    public int getBottomSide() {
        return bottomSide;
    }

    public int getMidleLine() {
        return midleLine;
    }
}
