package regression;

import org.testng.annotations.Test;
import pages.AddClient.AddClient;
import pages.Menu;
import util.DoLogin;

public class AddClientTest extends DoLogin {


    @Test
    public void addClient()
    {
        Menu menu = new Menu(driver);
       // menu.openClientsMenu();
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName("Scripting Logic Pvt Ltd");
        addClient.setClientSurname("Solutions");
        addClient.setLanguage("Thai");
        addClient.setAddress1("123 MG Road");
        addClient.setAddress2("Near Tech Park");
        addClient.setCity("Pune");
        addClient.setState("Maharashtra");
        addClient.setZip("411001");
        addClient.setCountry("Malta");
        addClient.setGender("Female");
        addClient.setBirthdate("05-Sep-1985");
        addClient.setPhone("0201234567");
        addClient.setFax("0207654321");
        addClient.setMobile("9876543210");
        addClient.setEmail("contact@scriptinglogic.in");
        addClient.setWeb("https://scriptinglogic.in");
        addClient.setVatId("GSTIN1234");
        addClient.setTaxCode("TAXCODE001");

        addClient.save();

    }

}

