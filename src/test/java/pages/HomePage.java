package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

public class HomePage extends BasePage{
    @FindBy(xpath = "(//a[normalize-space()='Home'])[1]")
    private WebElement navbar_home;
    @FindBy(css = "li:nth-child(10) a:nth-child(1)")
    private WebElement logged_in_as_username;
    @FindBy(css = "a[href='/products']")
    private WebElement products_page;
    @FindBy(css = "div[class='single-widget'] h2")
    private WebElement subscription;
    @FindBy(css = "#susbscribe_email")
    private WebElement email;
    @FindBy(css = ".alert-success.alert")
    private WebElement success_message;
    @FindBy(css = "a[href='/product_details/1']")
    private WebElement first_product_view_product;
    @FindBy(css = "a[href='/category_products/1']")
    private WebElement dress_category;
    @FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[1]")
    private WebElement add_first_item_to_cart;
    @FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[70]")
    private WebElement add_item_to_cart_from_recommended;
    @FindBy(css = ".recommended_items .title.text-center")
    public WebElement recommended_items;
    @FindBy(css = ".fa.fa-angle-up")
    private WebElement scroll_up_button;
    @FindBy(css = ".item .col-sm-6 h2")
    private WebElement full_fledged_practice_website;

    public String verifyFullFledgedPracticeWebsite(){
        return full_fledged_practice_website.getText();
    }
    public void clickScrollUpButton(){
        BrowserUtils.wait(1);
        scroll_up_button.click();
    }
    public void addItemFromRecommendedItems(){
        BrowserUtils.waitForVisibility(add_item_to_cart_from_recommended, 10);
        add_item_to_cart_from_recommended.click();
    }
    public String verifyRecommendedItems(){
        return recommended_items.getText();
    }
    public void clickDressSubcategory(){
        dress_category.click();
    }
    public void addFirstItemToCart(){
        add_first_item_to_cart.click();
    }

    public void clickViewFirstProduct(){
        first_product_view_product.click();
    }
    public String successMessage(){
        return success_message.getText();
    }
    public void fillEmail(){
        email.sendKeys(ConfigurationReader.getProperty("email"), Keys.ENTER);
    }
    public String subscriptionText(){
        return subscription.getText();
    }
    public void scrollDown(){
        BrowserUtils.scrollDownUntilElementFount(subscription);
    }
    public void navigateToProductsPage(){
        products_page.click();
    }
    public String getLoggedInAsUsername(){
        return logged_in_as_username.getText().toLowerCase().trim();
    }
    public void verify_home_page(){
        Assert.assertEquals("home", navbar_home.getText().toLowerCase().trim());
    }
}
