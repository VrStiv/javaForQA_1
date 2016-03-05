package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testUserCreation() {

        app.gotoAddUserPage();
        app.getContactHelper().fillContactForm(new ContactData("Stas", "Trubchanov", "Vrstiv", "+3806777777777", "stas.trubchanov@mail.ru", "Kharkiv"));
        app.getContactHelper().submitForm();
        app.getContactHelper().returnToMainPage();
    }

}
