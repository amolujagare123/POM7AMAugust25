package DBTesting;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient.AddClient;
import pages.Menu;
import util.DoLogin;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static util.Conversion.*;
import static util.ForDataProvider.getMyData;

public class AddClientDPTest extends DoLogin {


    @Test (dataProvider = "getData")
    public void addClient(String clientName, String clientSurname, String language,
                          String streetAddress1, String streetAddress2, String city,
                          String state, String zipCode, String country,
                          String phoneNumber, String faxNumber, String mobileNumber,
                          String emailAddress, String webAddress,
                          String gender, String birthdate,
                          String vatId, String taxesCode) throws ClassNotFoundException, SQLException, ParseException {

        ArrayList<String> expected = new ArrayList<>();
        expected.add(clientName);
        expected.add(clientSurname);
        expected.add(language.toLowerCase());
        expected.add(streetAddress1);
        expected.add(streetAddress2);
        expected.add(city);
        expected.add(state);
        expected.add(zipCode);
        expected.add(country);
        expected.add(phoneNumber);
        expected.add(faxNumber);
        expected.add(mobileNumber);
        expected.add(emailAddress);
        expected.add(webAddress);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(vatId);
        expected.add(taxesCode);



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

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/ip";
        String username ="root";
        String password ="root";

        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();

        String sql = "select * from ip_clients where client_name='"+clientName+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while(rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            String shortCountry = rs.getString("client_country");
            String fullCountry =  convertCountry(shortCountry);
            actual.add(fullCountry);

            //actual.add(convertCountry(rs.getString("client_country")));




            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));

            actual.add(getGender(rs.getString("client_gender")));


            actual.add(convertDate(rs.getString("client_birthdate")));

            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

            Assert.assertEquals(actual,expected,"Data mismatch");
    }


    @DataProvider
    Object[][] getData() throws IOException {
        return getMyData("Data/ClientFormData.xlsx","DB Testing");
    }

}

