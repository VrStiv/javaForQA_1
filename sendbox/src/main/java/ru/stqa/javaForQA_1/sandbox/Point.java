package ru.stqa.javaForQA_1.sandbox;

public class Point {

  public double x;
  public double y;

  public double x1;
  public double y1;
  public double x2;
  public double y2;


  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Point(double x1, double y1, double x2, double y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }
  // Метод вычисления расстояния между точками в классе Point
  public double distanceObject() {

    return Math.sqrt(Math.pow(this.x2 - this.x1, 2) + Math.pow(this.y2 - this.y1, 2));

  }

}
