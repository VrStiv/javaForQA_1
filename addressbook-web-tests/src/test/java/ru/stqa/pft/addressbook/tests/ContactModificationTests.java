package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().mainPage();
    if (app.contact().all().size() == 0) {
      app.goTo().addContactPage();
      app.contact().create(new ContactData()
              .withFirstName("Stas").withLastName("Trubchanov").withNickName("Vrstiv")
              .withPhoneHome("+3806777777777").withMailHome("stas.trubchanov@mail.ru").withAddressHome("Kharkiv").withGroup("StasTest1"), true);
    }
  }

  @Test (enabled = true)
  public void testUserModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("Stasm").withLastName("Trubchanovm").withNickName("Vrstivm")
            .withPhoneHome("+3806777777777").withMailHome("stasm.trubchanov@mail.ru").withAddressHome("Kharkiv");
    app.contact().modyfy(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}


// true в параметрах - для модификации, когда присутствует элемент "Group"
// false в параметрах - для модификации, когда отсутствует элемент "Group"
// null в параметрах - значение по умолчанию