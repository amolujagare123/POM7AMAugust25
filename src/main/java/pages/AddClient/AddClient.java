package pages.AddClient;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

   WebDriver driver;

    public AddClient(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setLanguage(String language)
    {
        languageContainer.click();
        search.sendKeys(language);
        driver.findElement(By.xpath("//li[normalize-space()='"+language+"']")).click();

    }
    
    @FindBy (id="select2-client_country-container")
    WebElement countryContainer;

    public void setCountry(String country)
    {
        countryContainer.click();
        search.sendKeys(country);
        driver.findElement(By.xpath("//li[normalize-space()='"+country+"']")).click();

    }
    
    @FindBy (id="select2-client_gender-container")
    WebElement genderContainer;

    public void setGender(String country)
    {
        genderContainer.click();
        driver.findElement(By.xpath("//li[normalize-space()='"+country+"']")).click();

    }
    @FindBy(xpath="//input[@id='client_birthdate']")
    WebElement clientBirthdate;

    public void setBirthdate(String birthdate)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+birthdate+"')",clientBirthdate);
    }
    

    @FindBy(id = "btn-submit")
    WebElement btnSave;

    @FindBy(id = "client_active")
    WebElement activeCheckbox;

    @FindBy(id = "client_name")
    WebElement clientName;

    @FindBy(id = "client_surname")
    WebElement clientSurname;

    @FindBy(id = "client_address_1")
    WebElement address1;

    @FindBy(id = "client_address_2")
    WebElement address2;

    @FindBy(id = "client_city")
    WebElement city;

    @FindBy(id = "client_state")
    WebElement state;

    @FindBy(id = "client_zip")
    WebElement zip;

    @FindBy(id = "client_phone")
    WebElement phone;

    @FindBy(id = "client_fax")
    WebElement fax;

    @FindBy(id = "client_mobile")
    WebElement mobile;

    @FindBy(id = "client_email")
    WebElement email;

    @FindBy(id = "client_web")
    WebElement web;

    @FindBy(id = "client_vat_id")
    WebElement vatId;

    @FindBy(id = "client_tax_code")
    WebElement taxCode;

    public void setActive(boolean active) {
        if (activeCheckbox.isSelected() != active) {
            activeCheckbox.click();
        }
    }

    public void setClientName(String value) {
        clientName.sendKeys(value);
    }

    public void setClientSurname(String value) {
        clientSurname.sendKeys(value);
    }


    @FindBy (id="select2-client_language-container")
    WebElement languageContainer;

    @FindBy(xpath="//input[@aria-label='Search']")
    WebElement search;



    public void setAddress1(String value) {
        address1.sendKeys(value);
    }

    public void setAddress2(String value) {
        address2.sendKeys(value);
    }

    public void setCity(String value) {
        city.sendKeys(value);
    }

    public void setState(String value) {
        state.sendKeys(value);
    }

    public void setZip(String value) {
        zip.sendKeys(value);
    }

    public void setPhone(String value) {
        phone.sendKeys(value);
    }

    public void setFax(String value) {
        fax.sendKeys(value);
    }

    public void setMobile(String value) {
        mobile.sendKeys(value);
    }

    public void setEmail(String value) {
        email.sendKeys(value);
    }

    public void setWeb(String value) {
        web.sendKeys(value);
    }

    public void setVatId(String value) {
        vatId.sendKeys(value);
    }

    public void setTaxCode(String value) {
        taxCode.sendKeys(value);
    }

    public void save() {
        btnSave.click();
    }
}
