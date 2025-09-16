package regression;

import org.testng.annotations.Test;
import pages.Login.Login;
import util.OpenURL;

public class LoginTest extends OpenURL {

    @Test
    public void loginTest()
    {

        Login login = new Login(driver);
        login.setTxtUsername("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();
    }
}
