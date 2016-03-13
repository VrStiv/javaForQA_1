package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testUserCreation() {
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoAddContactPage();
    /* true в параметрах - для модификации, когда присутствует элемент "Group"*/
    app.getContactHelper().createContact(new ContactData("Stas", "Trubchanov", "Vrstiv", "+3806777777777", "stas.trubchanov@mail.ru", "Kharkiv", "StasTest1"), true);
    int after = app.getContactHelper().getContactCount();
    /* Проверка наличия нового элемента */
    Assert.assertEquals(after, before + 1);
  }

}
