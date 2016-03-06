package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String nickName;
  private final String phoneHome;
  private final String mailHome;
  private final String addressHome;
  private String group;

  public ContactData(String firstName, String lastName, String nickName, String phoneHome, String mailHome, String addressHome, String group) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.phoneHome = phoneHome;
    this.mailHome = mailHome;
    this.addressHome = addressHome;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getPhoneHome() {
    return phoneHome;
  }

  public String getMailHome() {
    return mailHome;
  }

  public String getAddressHome() {
    return addressHome;
  }

  public String getGroup() {
    return group;
  }
}
