package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  WebDriver wd;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private UserHelper userHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
    System.out.println("Используется браузер " + browser);
  }

  public void init() {
    if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://127.0.0.1:8080/addressbook/");
    groupHelper = new GroupHelper(wd);
    userHelper = new UserHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public UserHelper getUserHelper() {
    return userHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public void gotoUserMainPage() {
    wd.findElement(By.linkText("home")).click();
  }

  public void gotoAddUserPage() {
    wd.findElement(By.linkText("add new")).click();
  }
}
