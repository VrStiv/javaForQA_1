package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testUserDeletion() {

    app.getNavigationHelper().gotoContactMainPage();
    if (!app.getContactHelper().isThereAConntact()) {
      app.getNavigationHelper().gotoAddContactPage();
      /* true в параметрах - для модификации, когда отсутствует элемент "Group"*/
      app.getContactHelper().createContact(new ContactData("Stas", "Trubchanov", "Vrstiv", "+3806777777777", "stas.trubchanov@mail.ru", "Kharkiv", "StasTest1"), true);
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().deletionUser();
    app.getContactHelper().returnToMainPage();
  }

}
