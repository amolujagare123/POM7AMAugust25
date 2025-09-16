package regression;

import org.testng.annotations.Test;
import pages.Login.ForgotPassword;
import pages.Login.Login;
import util.OpenURL;

public class ForgotPasswordTest extends OpenURL {

    @Test
    public void loginTest()
    {

        Login login = new Login(driver);
        login.clickForgotPassword();


        ForgotPassword forgotPassword = new ForgotPassword(driver);
        forgotPassword.setTxtEmail("amol@gmail.com");
        forgotPassword.clickReset();

    }
}
