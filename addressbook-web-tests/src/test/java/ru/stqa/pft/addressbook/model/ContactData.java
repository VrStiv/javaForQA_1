package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private final String firstName;
  private final String lastName;
  private final String nickName;
  private final String phoneHome;
  private final String mailHome;
  private final String addressHome;
  private String group;

  public ContactData(int id, String firstName, String lastName, String nickName, String phoneHome, String mailHome, String addressHome, String group) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.phoneHome = phoneHome;
    this.mailHome = mailHome;
    this.addressHome = addressHome;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  public ContactData(String firstName, String lastName, String nickName, String phoneHome, String mailHome, String addressHome, String group) {
    this.id = Integer.MAX_VALUE;

    this.firstName = firstName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.phoneHome = phoneHome;

    this.mailHome = mailHome;
    this.addressHome = addressHome;

    this.group = group;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
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
