package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testUserCreation() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoAddContactPage();
    // true в параметрах - для модификации, когда присутствует элемент "Group"
    ContactData contact = new ContactData("Stas", "Trubchanov", "Vrstiv", "+3806777777777", "stas.trubchanov@mail.ru", "Kharkiv", "StasTest1");
    app.getContactHelper().createContact(contact, true);
    List<ContactData> after = app.getContactHelper().getContactList();
    // Проверка наличия нового элемента
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
