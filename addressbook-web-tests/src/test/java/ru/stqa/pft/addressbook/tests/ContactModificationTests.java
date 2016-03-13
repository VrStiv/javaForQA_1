package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testUserModification() {

    app.getNavigationHelper().gotoContactMainPage();
    if (!app.getContactHelper().isThereAConntact()) {
      app.getNavigationHelper().gotoAddContactPage();

      // true в параметрах - для модификации, когда присутствует элемент "Group"
      app.getContactHelper().createContact(new ContactData("Stas", "Trubchanov", "Vrstiv", "+3806777777777", "stas.trubchanov@mail.ru", "Kharkiv", "StasTest1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    // Параметр для выбора первого элемента (первый способ из лекции)
    app.getContactHelper().initContactModification(before.size() + 1);
    // null в параметрах - значение по умолчанию
    // false в параметрах - для модификации, когда отсутствует элемент "Group"
    app.getContactHelper().fillContactForm(new ContactData("Stasm", "Trubchanovm", "Vrstivm", "+3806777777799", "stasm.trubchanov@mail.ru", "Kharkiv", null), false);
    app.getContactHelper().modificationUser();
    app.getContactHelper().returnToMainPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}