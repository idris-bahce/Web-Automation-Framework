package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigurationReader;

public class LoginPage extends BasePage{
    @FindBy(css = "div[class='signup-form'] h2")
    private WebElement new_user_signup;

    @FindBy(css = "input[placeholder='Name']")
    private WebElement name_input;
    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement email_input;
    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signup_button;
    @FindBy(css = "div[class='login-form'] h2")
    private WebElement login_to_your_account;
    @FindBy(css = "input[data-qa='login-email']")
    private WebElement email;
    @FindBy(css = "input[placeholder='Password']")
    private WebElement password;
    @FindBy(css = "button[data-qa='login-button']")
    private WebElement login;
    @FindBy(xpath = "(//p[normalize-space()='Your email or password is incorrect!'])[1]")
    private WebElement incorrect_email;

    public String incorrectEmailOrPassword(){
        return incorrect_email.getText().trim();
    }
    public void clickLogin(){
        login.click();
    }
    public void fillEmailAndPassword(){
        email.sendKeys(ConfigurationReader.getProperty("email"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
    }
    public void fillWrongEmailAndPassword(){
        email.sendKeys("wrong@wrong.com");
        password.sendKeys("wrong");
    }
    public String getLoginToYourAccount(){
        return login_to_your_account.getText().trim();
    }
    public void clickSignup(){
        signup_button.click();
    }
    public void enterEmail(){
        name_input.sendKeys(ConfigurationReader.getProperty("name"));
        email_input.sendKeys(ConfigurationReader.getProperty("email"));
    }
    public String getNewUserSignup(){
        return new_user_signup.getText().trim();
    }
}
