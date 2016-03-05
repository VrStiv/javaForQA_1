package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserModificationTests extends TestBase {

  @Test
  public void testUserModification() {

    app.gotoUserMainPage();
    app.getUserHelper().initUserModification();
    app.getUserHelper().fillUserForm(new UserData("Stasm", "Trubchanovm", "Vrstivm", "+3806777777799", "stasm.trubchanov@mail.ru", "Kharkiv"));
    app.getUserHelper().modificationUser();
    app.getUserHelper().returnToMainPage();
  }
}