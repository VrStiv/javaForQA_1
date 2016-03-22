package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().mainPage();
    if (app.contact().all().size() == 0) {
      app.goTo().addContactPage();
      app.contact().create(new ContactData()
              .withFirstName("Stas").withLastName("Trubchanov").withNickName("Vrstiv")
              .withHomePhone("+7(1111)").withMobilePhone("22-22").withWorkPhone("333")
              .withMailHome("stas.trubchanov@mail.ru").withAddressHome("Kharkiv").withGroup("StasTest1"), true);
    }
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
    .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  private String mergeAddress(ContactData contact) {
    return Arrays.asList(contact.getAddressHome())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleanedAddress)
            .collect(Collectors.joining("\n"));
  }

  public static String cleanedAddress(String phone){
    return phone.replaceAll("[-()]", "");
  }


  @Test(enabled = true)
  public void testContactPhones() {
    app.goTo().mainPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddressHome(), equalTo(mergeAddress(contactInfoFromEditForm)));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

}
