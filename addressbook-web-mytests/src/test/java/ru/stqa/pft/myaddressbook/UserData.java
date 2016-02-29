package ru.stqa.pft.myaddressbook;

public class UserData {
  private final String firstName;
  private final String lastName;
  private final String nickName;
  private final String phoneHome;
  private final String mailHome;
  private final String addressHome;

  public UserData(String firstName, String lastName, String nickName, String phoneHome, String mailHome, String addressHome) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.phoneHome = phoneHome;
    this.mailHome = mailHome;
    this.addressHome = addressHome;
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
}
