package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

public class CartPage extends BasePage{
    @FindBy(css = ".active")
    private WebElement shopping_cart;
    @FindBy(css = ".btn.btn-default.check_out")
    private WebElement proceed_to_checkout_button;
    @FindBy(css = ".fa.fa-times")
    private WebElement x_button;
    @FindBy(css = "p[class='text-center'] b")
    private WebElement empty_cart;

    public String emptyCart(){
        BrowserUtils.wait(2);
        return empty_cart.getText();
    }
    public void clickXButton(){
        x_button.click();
    }
    public void clickProceedToCheckoutButton(){
        proceed_to_checkout_button.click();
    }
    public String shoppingCart(){
        return shopping_cart.getText();
    }
}
