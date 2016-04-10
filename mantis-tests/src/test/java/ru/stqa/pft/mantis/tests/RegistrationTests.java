package ru.stqa.pft.mantis.tests;/* Created by Vrstiv on 10.04.2016  */

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

  @Test
  public void testRegistration(){
    app.registration().start("user1", "user1@localhost.localdomain");


  }
}
