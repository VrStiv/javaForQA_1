package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testUserModification() {

    app.gotoUserMainPage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Stasm", "Trubchanovm", "Vrstivm", "+3806777777799", "stasm.trubchanov@mail.ru", "Kharkiv"));
    app.getContactHelper().modificationUser();
    app.getContactHelper().returnToMainPage();
  }
}