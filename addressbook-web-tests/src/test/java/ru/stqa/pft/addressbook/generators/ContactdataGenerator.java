package ru.stqa.pft.addressbook.generators;/* Created by Vrstiv on 27.03.2016  */

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactdataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  @Parameter (names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactdataGenerator generator = new ContactdataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")){
      saveAsCsv(contacts, new File(file));
    }else if (format.equals("xml")){
      saveAsXml(contacts, new File(file));
    }else if (format.equals("json")){
      saveAsJson(contacts, new File(file));
    }else {
      System.out.println("Unrecognized format " + format);
    }
  }

  private void saveAsXml(List<ContactData> groups, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(groups);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsCsv(List<ContactData> groups, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact: groups){
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;\n", contact.getFirstName(), contact.getLastName(), contact.getNickName(),
              contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(), contact.getAddressHome(), contact.getGroup()));
    }
    writer.close();
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++){
      contacts.add(new ContactData().withFirstName(String.format("Stas %s", i)).withLastName(String.format("Trubchanov %s", i))
              .withNickName(String.format("Vrstiv %s", i)).withHomePhone(String.format("8793%s4312", i)).withMobilePhone(String.format("234%s233", i))
              .withWorkPhone(String.format("32423%s23423", i)).withAddressHome(String.format("Kharkiv%s", i)).withGroup(String.format("StasTest1")) );
    }
    return contacts;
  }








}
