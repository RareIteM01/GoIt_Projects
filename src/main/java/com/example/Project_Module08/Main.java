package com.example.Project_Module08;

class Main {
    public static void main(String[] args) {
        ShapePrinter shapePrinter = new ShapePrinter();

        Circle circle = new Circle("Circle", 30);
        circle.movingFigure(-10, 20);
        circle.printSize();
        shapePrinter.printShapeName(circle);
        System.out.println();

        Square square = new Square("Square", 13, 45);
        square.movingFigure(23, 2);
        square.printSize();
        shapePrinter.printShapeName(square);
        System.out.println();

        Parallelogram parallelogram = new Parallelogram("Parellelogram", 15, 15);
        parallelogram.movingFigure(8, -9);
        parallelogram.printSize();
        shapePrinter.printShapeName(parallelogram);
        System.out.println();

        Trapezoid trapezoid = new Trapezoid("Trapezoid", 12, 6, 21);
        trapezoid.movingFigure(1, 7);
        trapezoid.printSize();
        shapePrinter.printShapeName(trapezoid);
        System.out.println();

        Triangle triangle = new Triangle("Triangle", 50);
        triangle.movingFigure(5, -7);
        triangle.printSize();
        shapePrinter.printShapeName(triangle);

    }
}

