package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToMainPage() {
    click(By.linkText("home"));
  }

  public void submitForm() {
    click(By.cssSelector("input[type ='submit']"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getMail());
    type(By.name("email2"), contactData.getMail2());
    type(By.name("email3"), contactData.getMail3());
    type(By.name("address"), contactData.getAddressHome());

    /* Проверка наличия поля "Group" */
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+ id + "']")).click();
  }

  public void deletionContactButton() {
    click(By.cssSelector("input[value ='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.cssSelector("img[title ='Edit']"));
  }

  public void modificationUser() {
    click(By.cssSelector("input[value ='Update']"));
  }

  public void create(ContactData contact, boolean creation) {
    fillContactForm(contact, creation);
    submitForm();
    contactCache = null;
    returnToMainPage();
  }

  public void modyfy(ContactData contact, boolean creation) {
    initContactModification();
    fillContactForm(contact, false);
    modificationUser();
    contactCache = null;
    returnToMainPage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deletionContactButton();
    contactCache = null;
  }

  /* Метод проверки наличия элемента для редактирования, для определения наличия контактов в списке */
  public boolean isThereAConntact() {
    return isElementPresent(By.name("selected[]"));
  }

  private Contacts contactCache = null;

  public Contacts all() {
      if (contactCache != null){
        return new Contacts(contactCache);
      }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstName = element.findElement(By.xpath("./td[3]")).getText();
      String lastName = element.findElement(By.xpath("./td[2]")).getText();
      String addressHome = element.findElement(By.xpath("./td[4]")).getText();
      String allMails = element.findElement(By.xpath("./td[5]")).getText();
      String allPhones = element.findElement(By.xpath("./td[6]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData()
              .withId(id).withFirstName(firstName).withLastName(lastName).withAddressHome(addressHome)
              .withAllMails(allMails).withAllPhones(allPhones));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    String addressHome = wd.findElement(By.name("address")).getAttribute("value");
    String mail = wd.findElement(By.name("email")).getAttribute("value");
    String mail2 = wd.findElement(By.name("email2")).getAttribute("value");
    String mail3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId()).withFirstName(firstname).withLastName(lastname).withAddressHome(addressHome)
            .withMail(mail).withMail2(mail2).withMail3(mail3)
            .withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone);

  }
  private void initContactModificationById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }
}
