package ru.stqa.javaForQA_1.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {

  Point p1 = new Point(4, 4);
  Point p2 = new Point(8, 8);
  Point p3 = new Point(8, 4);

  @Test
  public void testArea() {
    Point p = new Point(p1, p2);
    Assert.assertEquals(p.distanceObject(p1, p2), 5.656854249492381);
  }


  @Test
  public void testArea2() {
    Point p = new Point(p1, p3);
    Assert.assertEquals(p.distanceObject(p1, p3), 5.0);
  }
}
