package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testUserCreation() {
    Contacts before = app.contact().all();
    app.goTo().addContactPage();
    ContactData contact = new ContactData()
            .withFirstName("Stas").withLastName("Trubchanov").withNickName("Vrstiv")
            .withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withMail1("stas.trubchanov@mail.ru")
            .withAddressHome("Kharkiv").withGroup("StasTest1");
    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    // Проверка наличия нового элемента
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
