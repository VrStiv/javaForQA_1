package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.myaddressbook.model.UserData;

public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreation() {

        app.gotoAddUserPage();
        app.getUserHelper().fillUserForm(new UserData("Stas", "Trubchanov", "Vrstiv", "+3806777777777", "stas.trubchanov@mail.ru", "Kharkiv"));
        app.getUserHelper().submitForm();
        app.getUserHelper().returnToMainPage();
    }

}
