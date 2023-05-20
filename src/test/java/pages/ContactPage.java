package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigurationReader;

public class ContactPage extends BasePage{
    @FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
    private WebElement get_in_touch;
    @FindBy(css = "input[placeholder='Name']")
    private WebElement name;
    @FindBy(css = "input[placeholder='Email']")
    private WebElement email;
    @FindBy(css = "input[placeholder='Subject']")
    private WebElement subject;
    @FindBy(id = "message")
    private WebElement message;
    @FindBy(css = "input[name='upload_file']")
    private WebElement file;
    @FindBy(css = "input[value='Submit']")
    private WebElement submit;
    @FindBy(css = ".status.alert.alert-success")
    private WebElement success_message;

    public String successMessage(){
        return success_message.getText();
    }
    public void submit(){
        submit.click();
    }
    public void uploadFile(){
        //In order upload a file we have to send absolute path of that file:
        file.sendKeys("C:\\Users\\idris\\Desktop\\Java Studies\\Cucumber_Web_Automation\\extension_5_6_0_0.crx");
    }
    public void fillTheBlanks(){
        name.sendKeys(ConfigurationReader.getProperty("name"));
        email.sendKeys(ConfigurationReader.getProperty("email"));
        subject.sendKeys("Some topic");
        message.sendKeys("Some message to be written");
    }
    public String getInTouch(){
        return get_in_touch.getText();
    }
}
