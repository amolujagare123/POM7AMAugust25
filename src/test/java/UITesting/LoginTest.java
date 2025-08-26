package UITesting;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenURL;

import static util.ForUITests.*;

public class LoginTest extends OpenURL {

    Login login;
    @BeforeClass
    public void initLogin()
    {
        login = new Login(driver);
    }

    /*@Test
    public void loginLogoAvailabilityCheck()
    {
        boolean expected = true;
        boolean actual=false;

        try {
            actual = login.logoIcon.isDisplayed();
        }
         catch (Exception e)
         {
           //  actual = false;
         }

        Assert.assertEquals(actual,expected,"Element is not Present");
    }*/

    @Test
    public void loginLogoAvailabilityCheck()
    {
        boolean expected = true;
        boolean actual=checkAvailability(login.logoIcon);
        Assert.assertEquals(actual,expected,"Element is not Present");
    }

    @Test
    public void txtUsernameAvailabilityCheck()
    {
        boolean expected = true;
        boolean actual=checkAvailability(login.txtUsername);
        Assert.assertEquals(actual,expected,"Element is not Present");
    }

    @Test
    public void txtPasswordAvailabilityCheck()
    {
        boolean expected = true;
        boolean actual=checkAvailability(login.txtPassword);
        Assert.assertEquals(actual,expected,"Element is not Present");
    }

    @Test
    public void txtUsernameEnabilityCheck()
    {
        boolean expected = true;
        boolean actual=checkEnability(login.txtUsername);
        Assert.assertEquals(actual,expected,"Element is not Present");
    }


    @Test
    public void lblEmailSpellCheck()
    {
        String expected = "Email";
        String actual=checkSpellig(login.lblEmail);
        Assert.assertEquals(actual,expected,"incorrect spelling");
    }

    @Test
    public void lblPasswordSpellCheck()
    {
        String expected = "Password";
        String actual=checkSpellig(login.lblPassword);
        Assert.assertEquals(actual,expected,"incorrect spelling");
    }


    @Test
    public void lblPasswordWatermarkCheck()
    {
        String expected = "Password";
        String actual=checkPlaceholder(login.txtPassword);
        Assert.assertEquals(actual,expected,"wrong watermark or no watermarks");
    }

    @Test
    public void lblPasswordFontSizeCheck()
    {
        String expected = "14px";
        String actual=checkStyle(login.lblPassword,"font-size");
        Assert.assertEquals(actual,expected,"wrong  font-size");
    }


    @Test
    public void lblPasswordFontFamilyCheck()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual=checkStyle(login.lblPassword,"font-family");
        Assert.assertEquals(actual,expected,"wrong font-family");
    }


    @Test
    public void buttonColorCheck()
    {
        String expected = "#2C8EDD";
        String actual=getColorHex(login.btnLogin,"background-color").toUpperCase();
        Assert.assertEquals(actual,expected,"wrong  background-color");
    }




}
