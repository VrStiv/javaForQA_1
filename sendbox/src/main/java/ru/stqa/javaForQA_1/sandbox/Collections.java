package ru.stqa.javaForQA_1.sandbox;/* Created by Vrstiv on 11.03.2016  */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main (String[] args){

    String [] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

  for (String l : languages){
    System.out.println("Я хочу выучить " + l);
  }

  }
}
