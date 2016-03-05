package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testUserDeletion (){
    app.gotoUserMainPage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().deletionUser();
    app.getContactHelper().returnToMainPage();

  }

}
