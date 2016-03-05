package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.myaddressbook.model.UserData;

public class UserHelper extends HelperBase {

  public UserHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToMainPage() {
    click(By.linkText("home"));
  }

  public void submitForm() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillUserForm(UserData userData) {
    type(By.name("firstname"), userData.getFirstName());
    type(By.name("lastname"), userData.getLastName());
    type(By.name("nickname"), userData.getNickName());
    type(By.name("home"), userData.getPhoneHome());
    type(By.name("email"), userData.getMailHome());
    type(By.name("address2"), userData.getAddressHome());
  }

  public void initUserModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void deletionUser() {
    click(By.xpath("//*[@id='content']/form[2]/input[2]"));
  }

  public void modificationUser() {
    click(By.xpath("//*[@id='content']/form[1]/input[22]"));
  }
}
