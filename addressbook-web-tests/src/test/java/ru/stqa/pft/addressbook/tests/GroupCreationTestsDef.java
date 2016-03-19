package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTestsDef extends TestBase {

  @Test
  public void testGroupCreation() {

    app.goTo().groupPage();
    app.group().initGroupCreation();
    app.group().fillGroupForm(new GroupData("StasTest1", null, null));
    app.group().submitGroupCreation();
    app.group().returnToGroupPage();
  }

}
