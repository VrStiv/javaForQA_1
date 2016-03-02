package ru.stqa.pft.myaddressbook.tests;

import org.testng.annotations.Test;

public class UserDeletionTests extends TestBase {

  @Test
  public void testUserDeletion (){
    applicationManager.gotoUserMainPage();
    applicationManager.getUserHelper().initUserModification();
    applicationManager.getUserHelper().deletionUser();
    applicationManager.getUserHelper().returnToMainPage();

  }

}
