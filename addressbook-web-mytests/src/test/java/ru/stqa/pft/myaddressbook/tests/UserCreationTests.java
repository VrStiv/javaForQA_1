package ru.stqa.pft.myaddressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.myaddressbook.model.UserData;

public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreation() {

        applicationManager.gotoAddUserPage();
        applicationManager.getUserHelper().fillUserForm(new UserData("Stas", "Trubchanov", "Vrstiv", "+3806777777777", "stas.trubchanov@mail.ru", "Kharkiv"));
        applicationManager.getUserHelper().submitForm();
        applicationManager.getUserHelper().returnToMainPage();
    }

}
