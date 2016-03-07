package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

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

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void deletionUser() {
    click(By.xpath("//*[@id='content']/form[2]/input[2]"));
  }

  public void modificationUser() {
    click(By.xpath("//*[@id='content']/form[1]/input[22]"));
  }

  /* Метод для создания нового контакта */
  public void createContact(ContactData contact, boolean creation) {
    fillContactForm(contact, creation);
    submitForm();
    returnToMainPage();
  }

  /* Метод проверки наличия элемента для редактирования, для определения наличия контактов в списке */
  public boolean isThereAConntact() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

  }
}
