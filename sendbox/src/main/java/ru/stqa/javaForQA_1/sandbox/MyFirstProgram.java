package ru.stqa.javaForQA_1.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {

    //Координаты точек
    double x1 = 4;
    double y1 = 4;
    double x2 = 8;
    double y2 = 8;

    Point p1 = new Point(x1, y1);
    Point p2 = new Point(x2, y2);


    System.out.println("");
    System.out.println("Bычисление расстояния между двумя точками при помощи функции:");
    System.out.println("Pасстояние между двумя точками (X=" + x1 + " Y=" + y1 + ") и (X=" + x2 + " Y=" + y2 + ") равно " + distance(p1, p2));


    Point p = new Point(x1, y1, x2, y2);
    System.out.println("");
    System.out.println("Bычисление расстояния между двумя точками при помощи метода в классе Point:");
    System.out.println("Pасстояние между двумя точками (X=" + x1 + " Y=" + y1 + ") и (X=" + x2 + " Y=" + y2 + ") равно " + p.distanceObject());

  }

  //Функция вычисление расстояния между двумя точками
  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
  }


}