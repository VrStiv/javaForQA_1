package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().mainPage();
    if (app.db().contacts().size() == 0) {
      app.goTo().addContactPage();
      app.contact().create(new ContactData()
              .withFirstName("Stas").withLastName("Trubchanov").withNickName("Vrstiv")
              .withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
              .withMail("stas.trubchanov@mail.ru").withAddressHome("Kharkiv"), true);
    }
  }

  @Test (enabled = true)
  public void testUserDeletion() {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().mainPage();
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListInUI();
  }
}
