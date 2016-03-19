package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHelper().gotoContactMainPage();
    if (!app.getContactHelper().isThereAConntact()) {
      app.getNavigationHelper().gotoAddContactPage();
      app.getContactHelper().createContact(new ContactData("Stas", "Trubchanov", "Vrstiv", "+3806777777777", "stas.trubchanov@mail.ru", "Kharkiv", "StasTest1"), true);
    }
  }

  @Test (enabled = true)
  public void testUserModification() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(), "Stasm", "Trubchanovm", "Vrstivm", "+3806777777799", "stasm.trubchanov@mail.ru", "Kharkiv", null);
    app.getContactHelper().modyfyContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}


// true в параметрах - для модификации, когда присутствует элемент "Group"
// false в параметрах - для модификации, когда отсутствует элемент "Group"
// null в параметрах - значение по умолчанию