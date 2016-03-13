package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testUserDeletion() {
    app.getNavigationHelper().gotoContactMainPage();
    if (!app.getContactHelper().isThereAConntact()) {
      app.getNavigationHelper().gotoAddContactPage();
      // true в параметрах - для модификации, когда отсутствует элемент "Group"
      app.getContactHelper().createContact(new ContactData("Stas", "Trubchanov", "Vrstiv", "+3806777777777", "stas.trubchanov@mail.ru", "Kharkiv", "StasTest1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(0);
    app.getContactHelper().deletionContactButton();
    app.getNavigationHelper().gotoContactMainPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }

}
