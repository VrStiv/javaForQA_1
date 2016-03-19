package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToMainPage() {
    click(By.linkText("home"));
  }

  public void submitForm() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("home"), contactData.getPhoneHome());
    type(By.name("email"), contactData.getMailHome());
    type(By.name("address2"), contactData.getAddressHome());

    /* Проверка наличия поля "Group" */
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deletionContactButton() {
    click(By.xpath("//*[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[last()]/td[8]//img"));
  }

  public void modificationUser() {
    click(By.xpath("//*[@id='content']/form[1]/input[22]"));
  }

  public void create(ContactData contact, boolean creation) {
    fillContactForm(contact, creation);
    submitForm();
    returnToMainPage();
  }

  public void modyfy(ContactData contact) {
    initContactModification();
    fillContactForm(contact, false);
    modificationUser();
    returnToMainPage();
  }

  public void delete() {
    selectContact(0);
    deletionContactButton();
  }

  /* Метод проверки наличия элемента для редактирования, для определения наличия контактов в списке */
  public boolean isThereAConntact() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstName = element.findElement(By.xpath("./td[3]")).getText();
      String lastName = element.findElement(By.xpath("./td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
    }
    return contacts;
  }

  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstName = element.findElement(By.xpath("./td[3]")).getText();
      String lastName = element.findElement(By.xpath("./td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
    }
    return contacts;
  }

}
