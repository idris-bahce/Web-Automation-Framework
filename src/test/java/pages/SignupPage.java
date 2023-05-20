package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigurationReader;

public class SignupPage extends BasePage{
    @FindBy(xpath = "(//h2[@class='title text-center'])[1]")
    private WebElement enter_account_info;
    @FindBy(id = "id_gender1")
    private WebElement title;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "days")
    private WebElement days;
    @FindBy(id = "months")
    private WebElement months;
    @FindBy(id = "years")
    private WebElement years;
    @FindBy(id = "newsletter")
    private WebElement newsletter;
    @FindBy(id = "optin")
    private WebElement optin;
    @FindBy(id = "first_name")
    private WebElement first_name;
    @FindBy(id = "last_name")
    private WebElement last_name;
    @FindBy(id = "company")
    private WebElement company;
    @FindBy(id = "address1")
    private WebElement address1;
    @FindBy(id = "address2")
    private WebElement address2;
    @FindBy(id = "country")
    private WebElement country;
    @FindBy(id = "state")
    private WebElement state;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "zipcode")
    private WebElement zipcode;
    @FindBy(id = "mobile_number")
    private WebElement mobile_number;
    @FindBy(css = "button[data-qa='create-account']")
    private WebElement create_account;


    public void clickCreateAccount(){
        create_account.click();
    }
    public void fillGivenSpacesAfterNewsLetter(){
        first_name.sendKeys(ConfigurationReader.getProperty("name"));
        last_name.sendKeys(ConfigurationReader.getProperty("last_name"));
        company.sendKeys(ConfigurationReader.getProperty("company"));
        address1.sendKeys(ConfigurationReader.getProperty("address"));
        address2.sendKeys(ConfigurationReader.getProperty("address2"));
        country.sendKeys(ConfigurationReader.getProperty("country"));
        state.sendKeys(ConfigurationReader.getProperty("state"));
        city.sendKeys(ConfigurationReader.getProperty("city"));
        zipcode.sendKeys(ConfigurationReader.getProperty("zipcode"));
        mobile_number.sendKeys(ConfigurationReader.getProperty("mobile_number"));
    }
    public void clickNewsletter(){
        newsletter.click();
    }

    public void clickOffers() {
        optin.click();
    }
    public void fillGivenSpacesBeforeNewsLetter(){
        title.click();
        password.sendKeys(ConfigurationReader.getProperty("password"));
        days.sendKeys(ConfigurationReader.getProperty("day"));
        months.sendKeys(ConfigurationReader.getProperty("month"));
        years.sendKeys(ConfigurationReader.getProperty("year"));
    }
    public String getEnterAccountInfo(){
        return enter_account_info.getText().trim();
    }
}
