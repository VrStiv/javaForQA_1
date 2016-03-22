package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneMailAddressTests extends TestBase {

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
    .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneMailAddressTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  private String mergeMails(ContactData contact) {
    return Arrays.asList(contact.getMail(), contact.getMail2(), contact.getMail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  private String mergeAddress(ContactData contact) {
    return Arrays.asList(contact.getAddressHome())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().mainPage();
    if (app.contact().all().size() == 0) {
      app.goTo().addContactPage();
      app.contact().create(new ContactData()
              .withFirstName("Stas").withLastName("Trubchanov").withNickName("Vrstiv")
              .withHomePhone("+7(1111)").withMobilePhone("22-22").withWorkPhone("333")
              .withMail("stas.trubchanov@mil.ru").withMail2("stas.trub@ail.ru").withMail3("stas.anov@mai.ru")
              .withAddressHome("Kharkiv-35, (Flat 14)").withGroup("StasTest1"), true);
    }
  }

  @Test(enabled = false)
  public void testContactPhones() {
    app.goTo().mainPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddressHome(), equalTo(mergeAddress(contactInfoFromEditForm)));
    assertThat(contact.getAllMails(), equalTo(mergeMails(contactInfoFromEditForm)));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  @Test(enabled = true)
  public void testContactDetails() {
    app.goTo().mainPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromDetailForm = app.contact().infoFromDetailForm(contact);
    assertThat(contact.getAllMails(), equalTo(mergeDetailsPage(contactInfoFromDetailForm)));

  }

  private String mergeDetailsPage(ContactData contact) {
    return Arrays.asList(contact.getMail(), contact.getMail2(), contact.getMail3())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneMailAddressTests::cleanedSecondPage)
            .collect(Collectors.joining("\n"));
  }

  public static String cleanedSecondPage(String mails){
    return mails.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
