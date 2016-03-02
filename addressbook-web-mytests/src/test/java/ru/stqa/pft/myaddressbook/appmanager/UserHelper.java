package ru.stqa.pft.myaddressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.myaddressbook.model.UserData;

public class UserHelper {
  private FirefoxDriver wd;

  public UserHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void returnToMainPage() {
      wd.findElement(By.linkText("home page")).click();
  }

  public void submitForm() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillUserForm(UserData userData) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(userData.getFirstName());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(userData.getLastName());
      wd.findElement(By.name("nickname")).click();
      wd.findElement(By.name("nickname")).clear();
      wd.findElement(By.name("nickname")).sendKeys(userData.getNickName());
      wd.findElement(By.name("home")).click();
      wd.findElement(By.name("home")).clear();
      wd.findElement(By.name("home")).sendKeys(userData.getPhoneHome());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(userData.getMailHome());
      wd.findElement(By.name("address2")).click();
      wd.findElement(By.name("address2")).clear();
      wd.findElement(By.name("address2")).sendKeys(userData.getAddressHome());
  }
}
