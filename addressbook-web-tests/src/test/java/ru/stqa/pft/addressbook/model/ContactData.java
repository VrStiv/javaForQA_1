package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String lastName;
  private String nickName;
  private String phoneHome;
  private String mailHome;
  private String addressHome;
  private String group;

  public ContactData withAddressHome(String addressHome) {
    this.addressHome = addressHome;
    return this;
  }

  public ContactData withMailHome(String mailHome) {
    this.mailHome = mailHome;
    return this;
  }

  public ContactData withPhoneHome(String phoneHome) {
    this.phoneHome = phoneHome;
    return this;
  }

  public ContactData withNickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
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

  public int getId() {
    return id;
  }
}
