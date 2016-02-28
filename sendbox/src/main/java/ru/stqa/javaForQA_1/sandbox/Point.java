package ru.stqa.javaForQA_1.sandbox;

public class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  // Метод вычисления расстояния между точками в классе Point
  public Point(Point p1, Point p2) {
  }

  public double distanceObject(Point p1, Point p2) {

    return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));

  }
}
