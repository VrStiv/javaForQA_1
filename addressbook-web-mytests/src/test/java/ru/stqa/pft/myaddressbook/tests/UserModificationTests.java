package ru.stqa.pft.myaddressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.myaddressbook.model.UserData;

public class UserModificationTests extends TestBase {

  @Test
  public void testUserModification() {

    applicationManager.gotoUserMainPage();
    applicationManager.getUserHelper().initUserModification();
    applicationManager.getUserHelper().fillUserForm(new UserData("Stasm", "Trubchanovm", "Vrstivm", "+3806777777799", "stasm.trubchanov@mail.ru", "Kharkiv"));
    applicationManager.getUserHelper().modificationUser();
    applicationManager.getUserHelper().returnToMainPage();
  }
}