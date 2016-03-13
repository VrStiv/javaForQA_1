package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testUserModification() {

    app.getNavigationHelper().gotoContactMainPage();
    if (!app.getContactHelper().isThereAConntact()) {
      app.getNavigationHelper().gotoAddContactPage();

      // true в параметрах - для модификации, когда присутствует элемент "Group"
      app.getContactHelper().createContact(new ContactData("Stas", "Trubchanov", "Vrstiv", "+3806777777777", "stas.trubchanov@mail.ru", "Kharkiv", "StasTest1"), true);
    }
    int before = app.getContactHelper().getContactCount();
    // Параметр для первого элемента
    app.getContactHelper().initContactModification(2);
    // null в параметрах - значение по умолчанию
    // false в параметрах - для модификации, когда отсутствует элемент "Group"
    app.getContactHelper().fillContactForm(new ContactData("Stasm", "Trubchanovm", "Vrstivm", "+3806777777799", "stasm.trubchanov@mail.ru", "Kharkiv", null), false);
    app.getContactHelper().modificationUser();
    app.getContactHelper().returnToMainPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}