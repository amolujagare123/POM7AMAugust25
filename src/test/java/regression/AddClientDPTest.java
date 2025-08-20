package regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;
import util.DoLogin;

import java.io.IOException;

import static util.ForDataProvider.getMyData;

public class AddClientDPTest  extends DoLogin {


    @Test (dataProvider = "getData")
    public void addClient(String clientName, String clientSurname, String language,
                          String streetAddress1, String streetAddress2, String city,
                          String state, String zipCode, String country,
                          String phoneNumber, String faxNumber, String mobileNumber,
                          String emailAddress, String webAddress,
                          String gender, String birthdate,
                          String vatId, String taxesCode,String expected,String xpathActual)
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName(clientName);
        addClient.setClientSurname(clientSurname);
        addClient.setLanguage(language);
        addClient.setAddress1(streetAddress1);
        addClient.setAddress2(streetAddress2);
        addClient.setCity(city);
        addClient.setState(state);
        addClient.setZip(zipCode);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setBirthdate(birthdate);
        addClient.setPhone(phoneNumber);
        addClient.setFax(faxNumber);
        addClient.setMobile(mobileNumber);
        addClient.setEmail(emailAddress);
        addClient.setWeb(webAddress);
        addClient.setVatId(vatId);
        addClient.setTaxCode(taxesCode);

        addClient.save();

     //   String expected = "[ "+name+" ] Customer Details Added !";

        String actual = "";

        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect or no message");
    }


    @DataProvider
    Object[][] getData() throws IOException {
        return getMyData("Data/ClientFormData.xlsx","Sheet1");
    }

}

