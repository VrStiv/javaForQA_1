package ru.stqa.javaForQA_1.sandbox;/* Created by Vrstiv on 11.03.2016  */

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {


@Test
  public void testPrime(){
  Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));

}

  @Test
  public void testNonPrime(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));

  }

  @Test(enabled = false)
  public void testPrimeLong(){
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));

  }
}


