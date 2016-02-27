package ru.stqa.javaForQA_1.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {

  @Test
  public void testArea() {
    Point p = new Point(2, 4, 8, 8);
    Assert.assertEquals(p.distanceObject(),7.211102550927978);
      }
  @Test
  public void testArea2() {
    Point p = new Point(1, 2, 8, 9);
    Assert.assertEquals(p.distanceObject(),9.899494936611665);
  }
}
