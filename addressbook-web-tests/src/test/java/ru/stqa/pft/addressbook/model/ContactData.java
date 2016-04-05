package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname")
  private String firstName;
  @Expose
  @Column(name = "lastname")
  private String lastName;
  @Expose
  @Column(name = "middlename")
  private String middleName;
  @Expose
  @Column(name = "nickname")
  private String nickName;
  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;
  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;
  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;
  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String mail;
  @Column(name = "email2")
  @Type(type = "text")
  private String mail2;
  @Column(name = "email3")
  @Type(type = "text")
  private String mail3;
  @Column(name = "address")
  @Type(type = "text")
  private String addressHome;
  @Expose
  @Transient
  private String group;
  @Transient
  private String allPhones;
  @Transient
  private String allMails;
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;


  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withAllMails(String allMails) {
    this.allMails = allMails;
    return this;
  }

  public ContactData withMail2(String mail2) {
    this.mail2 = mail2;
    return this;
  }

  public ContactData withMail3(String mail3) {
    this.mail3 = mail3;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAddressHome(String addressHome) {
    this.addressHome = addressHome;
    return this;
  }

  public ContactData withMail(String mail) {
    this.mail = mail;
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

  public int getId() { return id;  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getHomePhone() { return homePhone;  }

  public String getMail() { return mail;  }

  public String getAddressHome() {return addressHome; }

  public String getGroup() {
    return group;
  }

  public String getWorkPhone() { return workPhone;  }

  public String getMobilePhone() { return mobilePhone;  }

  public String getAllPhones() { return allPhones;  }

  public String getMail2() {return mail2;  }

  public String getAllMails() { return allMails;  }

  public String getMail3() { return mail3;  }

  public String getMiddleName() {return middleName; }

  public File getPhoto() {
    if(photo != null) {
      return new File(photo);
    }
    return null;
  }
}
