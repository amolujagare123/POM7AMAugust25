package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

   /* WebDriver driver = new ChromeDriver();
    WebElement username = driver.findElement(By.id("username"));
   WebElement password = driver.findElement(By.id("password"));
   */
    @FindBy (id="email")
    public WebElement txtUsername;

    @FindBy (id="password")
    public WebElement txtPassword;

    @FindBy (xpath="//button")
    public WebElement btnLogin;

    @FindBy(xpath = "//a[@class='btn btn-default']")
    public WebElement forgotPassword;

    @FindBy(xpath="//label[normalize-space()='Email']")
    public WebElement lblEmail;


    @FindBy(xpath="//img[@class='login-logo img-responsive']")
    public WebElement logoIcon;

    @FindBy(xpath="//label[normalize-space()='Password']")
    public WebElement lblPassword;



    public void clickForgotPassword()
    {
        forgotPassword.click();
    }

    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setTxtUsername(String username)
    {
        txtUsername.sendKeys(username);
    }

    public void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }


}
