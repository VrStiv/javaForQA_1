package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test (enabled = true)
  public void testUserCreation() {
    Set<ContactData> before = app.contact().all();
    app.goTo().addContactPage();
    // true в параметрах - для модификации, когда присутствует элемент "Group"
    ContactData contact = new ContactData()
            .withFirstName("Stas").withLastName("Trubchanov").withNickName("Vrstiv")
            .withPhoneHome("+3806777777777").withMailHome("stas.trubchanov@mail.ru").withAddressHome("Kharkiv").withGroup("StasTest1");
    app.contact().create(contact, true);
    Set<ContactData> after = app.contact().all();
    // Проверка наличия нового элемента
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
