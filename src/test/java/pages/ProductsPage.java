package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;

public class ProductsPage extends BasePage{
    @FindBy(css = ".title.text-center")
    private WebElement allProducts;
    @FindBy(css = "a[href='/product_details/1']")
    private WebElement first_product;
    @FindBy(css = "a[href='/product_details/2']")
    private WebElement second_product;
    @FindBy(css = "div[class='product-information'] h2")
    private WebElement product_detail;
    @FindBy(id = "search_product")
    private WebElement search_product;
    @FindBy(id = "submit_search")
    private WebElement submit_search;
    @FindBy(css = ".title.text-center")
    private WebElement searched_products;
    @FindBy(css = ".btn.btn-success.close-modal.btn-block")
    private WebElement continue_shopping_button;
    @FindBy(css = "a[href='/brand_products/Polo']")
    private WebElement polo_link;
    @FindBy(css = "a[href='/brand_products/Madame']")
    private WebElement madame_link;
    @FindBy(css = "a[href='#reviews']")
    private WebElement write_review;
    @FindBy(css = "#name")
    private WebElement name;
    @FindBy(css = "#email")
    private WebElement email;
    @FindBy(css = "#review")
    private WebElement review;
    @FindBy(css = "#button-review")
    private WebElement submit_button;

    public void clickSubmitButton(){
        submit_button.click();
    }

    public void fillTheBlanksForReview(){
        name.sendKeys(ConfigurationReader.getProperty("name"));
        email.sendKeys(ConfigurationReader.getProperty("email"));
        review.sendKeys("Well good goods");
    }
    public void navigatePolo(){
        polo_link.click();
    }
    public String verifyWriteYourReview(){
        return write_review.getText();
    }
    public void navigateMadame() {
        madame_link.click();
    }
    public void clickContinueShoppingButton(){
        continue_shopping_button.click();
    }
    public void addFirstItemToCart(){
        BrowserUtils.hoverOver(Driver.getDriver().findElement(By.xpath("(//div[@class='productinfo text-center'])[1]")));
        BrowserUtils.wait(2);
        //Since it is the add button of this product, I will simply put locator here without using @FindBy notation.
        Driver.getDriver().findElement(By.xpath(
                "(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[2]")).click();
    }
    public void addSecondItemToCart(){
        BrowserUtils.hoverOver(Driver.getDriver().findElement(By.xpath("(//img[@alt='ecommerce website products'])[2]")));
        BrowserUtils.wait(2);
        //Since it is the add button of this product, I will simply put locator here without using @FindBy notation.
        Driver.getDriver().findElement(By.xpath(
                "(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[4]")).click();
    }
    public String searchedProducts(){
        return searched_products.getText();
    }
    public void enterSearchProduct(){
        search_product.sendKeys("jean");
        submit_search.click();
    }
    public void verifySomeTopics(){
        List<WebElement> elements = Driver.getDriver().findElements(By.cssSelector(".product-information > p"));
        String category = elements.get(0).getText().split(":")[1];
        String availability = elements.get(1).getText().split(":")[1];
        String condition = elements.get(2).getText().split(":")[1];
        String brand = elements.get(3).getText().split(":")[1];
        Assert.assertEquals(category, " Women > Tops");
        Assert.assertEquals(availability, " In Stock");
        Assert.assertEquals(condition, " New");
        Assert.assertEquals(brand, " Polo");
    }
    public String productDetail(){
        return product_detail.getText();
    }
    public void clickFirstProduct(){
        first_product.click();
    }
    public String allProducts(){
        return allProducts.getText();
    }
}
