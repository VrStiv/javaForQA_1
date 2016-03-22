package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String lastName;
  private String nickName;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String mail1;
  private String addressHome;
  private String group;
  private String allPhones;


  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAddressHome(String addressHome) {
    this.addressHome = addressHome;
    return this;
  }

  public ContactData withMail1(String mail1) {
    this.mail1 = mail1;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
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

  public String getHomePhone() {
    return homePhone;
  }

  public String getMail1() {
    return mail1;
  }

  public String getAddressHome() {return addressHome; }

  public String getGroup() {
    return group;
  }

  public String getWorkPhone() { return workPhone;  }

  public String getMobilePhone() { return mobilePhone;  }

  public int getId() { return id;  }

  public String getAllPhones() { return allPhones;  }
}
