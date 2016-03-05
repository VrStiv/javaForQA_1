package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class UserDeletionTests extends TestBase {

  @Test
  public void testUserDeletion (){
    app.gotoUserMainPage();
    app.getUserHelper().initUserModification();
    app.getUserHelper().deletionUser();
    app.getUserHelper().returnToMainPage();

  }

}
