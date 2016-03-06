package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testUserDeletion (){
    app.gotoContactMainPage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().deletionUser();
    app.getContactHelper().returnToMainPage();

  }

}
