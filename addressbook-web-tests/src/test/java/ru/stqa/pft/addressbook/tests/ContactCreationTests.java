package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test (enabled = false)
  public void testUserCreation() {
    List<ContactData> before = app.contact().list();
    app.goTo().addContactPage();
    // true в параметрах - для модификации, когда присутствует элемент "Group"
    ContactData contact = new ContactData()
            .withFirstName("Stas").withLastName("Trubchanov").withNickName("Vrstiv")
            .withPhoneHome("+3806777777777").withMailHome("stas.trubchanov@mail.ru").withAddressHome("Kharkiv").withGroup("StasTest1");
    app.contact().create(contact, true);
    List<ContactData> after = app.contact().list();
    // Проверка наличия нового элемента
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
