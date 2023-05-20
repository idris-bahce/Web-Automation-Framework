package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class StepDefinitions extends BaseStep {
    String name_of_category = "jean";
    String url = ConfigurationReader.getProperty("url");

    @Given("Launch browser")
    public void launch_browser() {
        Driver.getDriver().get(url);
    }

    @When("Navigate to given url")
    public void navigate_to_given_url() {
        System.out.println("Open ::" + url);
        BrowserUtils.wait(1);
    }

    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        pages.homePage().verify_home_page();
    }

    @Then("Click on {string} button")
    public void click_on_button(String navigate) {
        BrowserUtils.navigateTo(navigate);
    }

    @Then("Verify {string} is visible")
    public void verify_is_visible(String verify) {
        Assert.assertEquals(verify, pages.loginPage().getNewUserSignup());
    }

    @Then("Enter name and email address")
    public void enter_name_and_email_address() {
        pages.loginPage().enterEmail();
    }

    @Then("Click Signup button")
    public void click_signup_button() {
        pages.loginPage().clickSignup();
    }

    @Then("Verify that {string} is visible")
    public void verify_that_is_visible(String enter_account_info) {
        Assert.assertEquals(enter_account_info, pages.signupPage().getEnterAccountInfo());
    }

    @Then("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() {
        pages.signupPage().fillGivenSpacesBeforeNewsLetter();
    }

    @Then("Select checkbox Sign up for our newsletter!")
    public void select_checkbox_for_our_newsletter() {
        pages.signupPage().clickNewsletter();
    }

    @Then("Select checkbox Receive special offers from our partners!")
    public void select_checkbox_receive_special_offers_from_our_partners() {
        pages.signupPage().clickOffers();
    }

    @Then("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {
        pages.signupPage().fillGivenSpacesAfterNewsLetter();
    }

    @Then("Click Create Account button")
    public void click_button() {
        pages.signupPage().clickCreateAccount();
    }

    @Then("Verify that ACCOUNT CREATED! is visible")
    public void verify_that_account_created_is_visible() {
        //Since it is not important to create new page for this little "account created" page, I will
        //put necessary locator here.
        String account_created = Driver.getDriver().findElement(By.cssSelector("h2[class='title text-center'] b"))
                .getText().trim();
        Assert.assertEquals(account_created, "ACCOUNT CREATED!");
    }

    @Then("Click Continue button")
    public void click_continue_button() {
        BrowserUtils.navigateTo("Continue");
    }

    @Then("Verify that Logged in as username is visible")
    public void verify_that_logged_in_as_username_is_visible() {
        Assert.assertEquals("logged in as " + ConfigurationReader.getProperty("name")
                , pages.homePage().getLoggedInAsUsername());
    }

    @Then("Click Delete Account button")
    public void click_delete_account_button() {
        BrowserUtils.navigateTo("Delete Account");
    }

    @Then("Verify that ACCOUNT DELETED! is visible and click Continue button")
    public void verify_that_account_deleted_is_visible_and_click_continue_button() {
        //Since it is not important to create new page for this little "account created" page, I will
        //put necessary locator here.
        String account_created = Driver.getDriver().findElement(By.cssSelector("h2[class='title text-center'] b"))
                .getText().trim();
        Assert.assertEquals(account_created, "ACCOUNT DELETED!");
    }

    @Then("Verify Login to your account is visible")
    public void verify_login_to_your_account_is_visible() {
        Assert.assertEquals(pages.loginPage().getLoginToYourAccount(), "Login to your account");
    }

    @Then("Enter correct email address and password")
    public void enter_correct_email_address_and_password() {
        pages.loginPage().fillEmailAndPassword();
    }

    @Then("Click login button")
    public void click_login_button() {
        pages.loginPage().clickLogin();
    }

    @Then("Enter incorrect email address and password")
    public void enter_incorrect_email_address_and_password() {
        pages.loginPage().fillWrongEmailAndPassword();
    }

    @Then("Verify error {string} is visible")
    public void verify_error_is_visible(String message) {
        Assert.assertEquals(pages.loginPage().incorrectEmailOrPassword(), message);
    }

    @Then("Click {string} button")
    public void click_button(String button) {
        BrowserUtils.navigateTo(button);
    }

    @Then("Verify that user is navigated to login page")
    public void verify_that_user_is_navigated_to_login_page() {
        Assert.assertEquals(pages.loginPage().getLoginToYourAccount(), "Login to your account");
    }

    @Then("Enter name and already registered email address")
    public void enter_name_and_already_registered_email_address() {
        pages.loginPage().enterEmail();
    }

    @Then("Verify error Email Address already exist! is visible")
    public void verify_error_email_address_already_exist_is_visible() {
        //Since it is one time used feature, I will write element's locator here.
        WebElement element = Driver.getDriver().findElement(By.xpath("(//p[normalize-space()='Email Address already exist!'])[1]"));
        Assert.assertEquals("Email Address already exist!", element.getText());
    }

    @Then("Verify GET IN TOUCH is visible")
    public void verify_get_in_touch_is_visible() {
        Assert.assertEquals("GET IN TOUCH", pages.contactPage().getInTouch());
    }

    @Then("Enter name, email, subject and message")
    public void enter_name_email_subject_and_message() {
        pages.contactPage().fillTheBlanks();
    }

    @Then("Upload file")
    public void upload_file() {
        pages.contactPage().uploadFile();
    }

    @Then("Click Submit button")
    public void click_submit_button() {
        pages.contactPage().submit();
    }

    @Then("Click OK button")
    public void click_ok_button() {
        BrowserUtils.handleAlertAccept();
    }

    @Then("Verify success message {string} is visible")
    public void verify_success_message_is_visible(String success_message) {
        Assert.assertEquals(success_message, pages.contactPage().successMessage());
    }

    @Then("Click {string} button and verify that landed to home page successfully")
    public void click_button_and_verify_that_landed_to_home_page_successfully(String home) {
        BrowserUtils.navigateTo(home);
    }

    @Then("Verify user is navigated to test cases page successfully")
    public void verify_user_is_navigated_to_test_cases_page_successfully() {
        //Since I will use this page once, I will write locator here.
        WebElement test_case = Driver.getDriver().findElement(By.cssSelector("h2[class='title text-center'] b"));
        Assert.assertEquals("TEST CASES", test_case.getText());
    }

    @Then("Click on Products button")
    public void click_on_products_button() {
        pages.homePage().navigateToProductsPage();
    }

    @Then("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verify_user_is_navigated_to_all_products_page_successfully() {
        Assert.assertEquals("ALL PRODUCTS", pages.productsPage().allProducts());
    }

    @Then("Click on View Product of first product")
    public void click_on_view_product_of_first_product() {
        pages.productsPage().clickFirstProduct();
    }

    @Then("User is landed to product detail page")
    public void user_is_landed_to_product_detail_page() {
        Assert.assertEquals("Blue Top", pages.productsPage().productDetail());
    }

    @Then("Verify that detail is visible: product name, category, price, availability, condition, brand")
    public void verify_that_detail_is_visible_product_name_category_price_availability_condition_brand() {
        pages.productsPage().verifySomeTopics();
    }

    @Then("Enter product name in search input and click search button")
    public void enter_product_name_in_search_input_and_click_search_button() {
        pages.productsPage().enterSearchProduct();
    }

    @Then("Verify SEARCHED PRODUCTS is visible")
    public void verify_searched_products_is_visible() {
        Assert.assertEquals("SEARCHED PRODUCTS", pages.productsPage().searchedProducts());
    }

    @Then("Verify all the products related to search are visible")
    public void verify_all_the_products_related_to_search_are_visible() {
        //Since we need to use element list, I will use locator here.
        List<WebElement> productNames = Driver.getDriver().findElements(By.cssSelector(".productinfo > p"));
        for (WebElement productNameElement : productNames) {
            String productName = productNameElement.getText();
            if (!productName.toLowerCase().contains(name_of_category)) {
                Assert.fail(productName + " does not contains jean");
            }
        }
    }

    @Then("Scroll down to footer")
    public void scroll_down_to_footer() {
        pages.homePage().scrollDown();
    }

    @Then("Verify text SUBSCRIPTION")
    public void verify_text_subscription() {
        Assert.assertEquals("SUBSCRIPTION", pages.homePage().subscriptionText());
    }

    @Then("Enter email address in input and click arrow button")
    public void enter_email_address_in_input_and_click_arrow_button() {
        pages.homePage().fillEmail();
    }

    @Then("Verify success message You have been successfully subscribed! is visible")
    public void verify_success_message_you_have_been_successfully_subscribed_is_visible() {
        Assert.assertEquals("You have been successfully subscribed!", pages.homePage().successMessage());
    }

    @Then("Hover over first product and click Add to cart")
    public void hover_over_first_product_and_click_add_to_cart() {
        pages.productsPage().addFirstItemToCart();
    }

    @Then("Click Continue Shopping button")
    public void click_continue_shopping_button() {
        pages.productsPage().clickContinueShoppingButton();
    }

    @Then("Hover over second product and click Add to cart")
    public void hover_over_second_product_and_click_add_to_cart() {
        pages.productsPage().addSecondItemToCart();
    }

    @Then("Verify both products are added to Cart")
    public void verify_both_products_are_added_to_cart() {
        //Since we need to use element list, I will use locator here. We need to find a number.
        List<WebElement> products = Driver.getDriver().findElements(By.cssSelector(".cart_product"));
        if (products.size() != 2) {
            Assert.fail("There are more than two products.");
        }
    }

    @Then("Verify their prices, quantity and total price")
    public void verify_their_prices_quantity_and_total_price() {
        //Since we need to use element list, I will use locator here.
        //prices
        List<WebElement> prices = Driver.getDriver().findElements(By.cssSelector(".cart_price"));
        Assert.assertEquals("Rs. 500", prices.get(0).getText());
        Assert.assertEquals("Rs. 400", prices.get(1).getText());
        //quantity
        List<WebElement> quantities = Driver.getDriver().findElements(By.cssSelector(".cart_quantity"));
        Assert.assertEquals("1", quantities.get(0).getText());
        Assert.assertEquals("1", quantities.get(1).getText());
        //total price
        List<WebElement> total_prices = Driver.getDriver().findElements(By.cssSelector(".cart_total"));
        Assert.assertEquals("Rs. 500", total_prices.get(0).getText());
        Assert.assertEquals("Rs. 400", total_prices.get(1).getText());
    }

    @Then("Click View Product for any product on home page")
    public void click_view_product_for_any_product_on_home_page() {
        pages.homePage().clickViewFirstProduct();
    }

    @Then("Verify product detail is opened")
    public void verify_product_detail_is_opened() {
        String title = Driver.getDriver().getTitle().split("-")[1];
        Assert.assertEquals("Product Details", title.trim());
    }

    @Then("Increase quantity to {int}")
    public void increase_quantity_to(int quantity) {
        //We will use locator here not to specifically made page for this random product:
        Driver.getDriver().findElement(By.id("quantity")).clear();
        Driver.getDriver().findElement(By.id("quantity")).sendKeys(("" + quantity));
    }

    @Then("Click Add to cart button")
    public void click_add_to_cart_button() {
        Driver.getDriver().findElement(By.cssSelector("button[type='button']")).click();
    }

    @Then("Verify that product is displayed in cart page with exact quantity")
    public void verify_that_product_is_displayed_in_cart_page_with_exact_quantity() {
        List<WebElement> quantities = Driver.getDriver().findElements(By.cssSelector(".cart_quantity"));
        Assert.assertEquals("4", quantities.get(0).getText());
    }

    @Then("Add products to cart")
    public void add_products_to_cart() {
        pages.homePage().addFirstItemToCart();
    }

    @Then("Verify that cart page is displayed")
    public void verify_that_cart_page_is_displayed() {
        Assert.assertEquals("Shopping Cart", pages.cartPage().shoppingCart().trim());
    }

    @Then("Click Proceed To Checkout")
    public void click_proceed_to_checkout() {
        pages.cartPage().clickProceedToCheckoutButton();
    }

    @Then("Fill all details in Signup and create account")
    public void fill_all_details_in_signup_and_create_account() {
        pages.loginPage().enterEmail();
        pages.loginPage().clickSignup();
        pages.signupPage().fillGivenSpacesBeforeNewsLetter();
        pages.signupPage().clickNewsletter();
        pages.signupPage().clickOffers();
        pages.signupPage().fillGivenSpacesAfterNewsLetter();
        pages.signupPage().clickCreateAccount();
    }

    @Then("Verify ACCOUNT CREATED! and click Continue button")
    public void verify_account_created_and_click_continue_button() {
        //Since it is not important to create new page for this little "account created" page, I will
        //put necessary locator here.
        String account_created = Driver.getDriver().findElement(By.cssSelector("h2[class='title text-center'] b"))
                .getText().trim();
        Assert.assertEquals(account_created, "ACCOUNT CREATED!");
        BrowserUtils.navigateTo("Continue");
    }

    @Then("Click Proceed To Checkout button")
    public void click_proceed_to_checkout_button() {
        pages.cartPage().clickProceedToCheckoutButton();
    }

    @Then("Verify Address Details and Review Your Order")
    public void verify_address_details_and_review_your_order() {
        // We will create a list, so I will use locator here:
        List<WebElement> address_information = Driver.getDriver().findElements(By.cssSelector("#address_delivery li"));
        int index = 1;
        try {
            File file = new File("address_information.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String info = address_information.get(index).getText();
                String real_info = sc.nextLine();
                if (!real_info.equals(info)) {
                    Assert.fail(info + " does not match with " + real_info);
                }
                index++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Then("Enter description in comment text area and click Place Order")
    public void enter_description_in_comment_text_area_and_click_place_order() {
        //Since it is not important to create new page for this little "account created" page, I will
        //put necessary locator here.
        Driver.getDriver().findElement(By.cssSelector("textarea[name='message']")).sendKeys("Send them quick!");
        Driver.getDriver().findElement(By.cssSelector(".btn.btn-default.check_out")).click();
    }

    @Then("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() {
        //Since it is not important to create new page for this little "account created" page, I will
        //put necessary locator here.
        Driver.getDriver().findElement(By.cssSelector("input[name='name_on_card']")).sendKeys("Master Card");
        Driver.getDriver().findElement(By.cssSelector("input[name='card_number']")).sendKeys("1234567890123456");
        Driver.getDriver().findElement(By.cssSelector("input[placeholder='ex. 311']")).sendKeys("311");
        Driver.getDriver().findElement(By.cssSelector("input[placeholder='MM']")).sendKeys("12");
        Driver.getDriver().findElement(By.cssSelector("input[placeholder='YYYY']")).sendKeys("2024");
    }

    @Then("Click Pay and Confirm Order button")
    public void click_pay_and_confirm_order_button() {
        Driver.getDriver().findElement(By.cssSelector("#submit")).click();
    }

    @Then("Verify success message Your order has been placed successfully!")
    public void verify_success_message_your_order_has_been_placed_successfully() {
        Assert.assertEquals("ORDER PLACED!",
                Driver.getDriver().findElement(By.cssSelector("h2[class='title text-center'] b")).getText().trim());
    }

    @Then("Click X button corresponding to particular product")
    public void click_x_button_corresponding_to_particular_product() {
        pages.cartPage().clickXButton();
    }

    @Then("Verify that product is removed from the cart")
    public void verify_that_product_is_removed_from_the_cart() {
        Assert.assertEquals("Cart is empty!", pages.cartPage().emptyCart());
    }

    @Then("Click on {string} category")
    public void click_on_category(String women) {
        BrowserUtils.scrollDown(0, 100);
        BrowserUtils.navigateTo(women);
    }

    @Then("Click on any category link under Women category, for example: {string}")
    public void click_on_any_category_link_under_women_category_for_example(String dress) {
        pages.homePage().clickDressSubcategory();
    }

    @Then("Verify that category page is displayed and confirm text {string}")
    public void verify_that_category_page_is_displayed_and_confirm_text(String verify) {
        //Since ı just have to extract passage, I will put locator here:
        String assertion_string = Driver.getDriver().findElement(By.cssSelector(".title.text-center")).getText();
        Assert.assertEquals(assertion_string, verify);
    }

    @Then("On left side bar, click on any sub-category link of {string} category : {string}")
    public void on_left_side_bar_click_on_any_sub_category_link_of_category(String men, String jeans) {
        BrowserUtils.navigateTo(men);
        BrowserUtils.wait(1);
        BrowserUtils.navigateTo(jeans);
    }

    @Then("Verify that user is navigated to that category page")
    public void verify_that_user_is_navigated_to_that_category_page() {
        //Since I just have to extract passage, I will put locator here:
        String assertion_string = Driver.getDriver().findElement(By.cssSelector(".title.text-center")).getText();
        Assert.assertEquals(assertion_string, "MEN - JEANS PRODUCTS");
    }

    @Then("Verify that Brands are visible on left side bar")
    public void verify_that_brands_are_visible_on_left_side_bar() {
        //Since I just have to extract passage, I will put locator here:
        String assertion_string = Driver.getDriver().findElement(By.cssSelector("div[class='brands_products'] h2")).getText();
        Assert.assertEquals(assertion_string, "BRANDS");
    }

    @Then("Click on any brand name : {string}")
    public void click_on_any_brand_name(String polo) {
        BrowserUtils.scrollDown(0, 125);
        pages.productsPage().navigatePolo();
    }

    @Then("Verify that user is navigated to brand page and brand products are displayed")
    public void verify_that_user_is_navigated_to_brand_page_and_brand_products_are_displayed() {
        //Since I just have to extract passage, I will put locator here:
        String assertion_string = Driver.getDriver().findElement(By.cssSelector(".title.text-center")).getText();
        Assert.assertEquals(assertion_string, "BRAND - POLO PRODUCTS");
    }

    @Then("On left side bar, click on any other brand link : {string}")
    public void on_left_side_bar_click_on_any_other_brand_link(String madame) {
        BrowserUtils.scrollDown(0, 150);
        pages.productsPage().navigateMadame();
    }

    @Then("Verify that user is navigated to that brand page and can see products")
    public void verify_that_user_is_navigated_to_that_brand_page_and_can_see_products() {
        //Since I just have to extract passage, I will put locator here:
        String assertion_string = Driver.getDriver().findElement(By.cssSelector(".title.text-center")).getText();
        Assert.assertEquals(assertion_string, "BRAND - MADAME PRODUCTS");
    }

    @Then("Add those products to cart")
    public void add_those_products_to_cart() {
        // Since we need a list, I will put locator here.
        List<WebElement> elements = Driver.getDriver().findElements(By.cssSelector(".productinfo a"));
        for (WebElement add_to_cart : elements) {
            add_to_cart.click();
            BrowserUtils.waitForVisibility(By.cssSelector(".btn.btn-success.close-modal.btn-block"), 1);
            Driver.getDriver().findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block")).click();
        }
    }

    @Then("Click {string} button and verify that products are visible in cart")
    public void click_button_and_verify_that_products_are_visible_in_cart(String cart) {
        BrowserUtils.navigateTo(cart);
    }

    @Then("Click {string} button and submit login details")
    public void click_button_and_submit_login_details(String login) {
        BrowserUtils.navigateTo(login);
        pages.loginPage().enterEmail();
        pages.loginPage().clickLogin();
    }

    @Then("Again, go to Cart page")
    public void again_go_to_cart_page() {
        BrowserUtils.navigateTo("Cart");
    }

    @Then("Verify that those products are visible in cart after login as well")
    public void verify_that_those_products_are_visible_in_cart_after_login_as_well() {
        // Since we need a list, I will put locator here.
        List<WebElement> name_elements = Driver.getDriver().findElements(By.cssSelector(".cart_description a"));
        for (WebElement name_element : name_elements) {
            String name = name_element.getText();
            if (!name.toLowerCase().contains(name_of_category)) {
                Assert.fail("This product does not exist in the cart before: " + name);
            }
        }
    }

    @Then("Click on View Product button")
    public void click_on_view_product_button() {
        pages.productsPage().clickFirstProduct();
    }

    @Then("Verify Write Your Review is visible")
    public void verify_write_your_review_is_visible() {
        Assert.assertEquals("WRITE YOUR REVIEW", pages.productsPage().verifyWriteYourReview());
    }

    @Then("Enter name, email and review")
    public void enter_name_email_and_review() {
        pages.productsPage().fillTheBlanksForReview();
    }

    @Then("Click Submit  button")
    public void click_submit__button() {
        pages.productsPage().clickSubmitButton();
    }

    @Then("Verify success message {string}")
    public void verify_success_message(String verify) {
        //Since I just have to extract passage, I will put locator here:
        String assertion_string = Driver.getDriver().findElement(By.cssSelector(
                "div[class='col-md-12 form-group'] div[class='alert-success alert']")).getText();
        Assert.assertEquals(assertion_string, verify);
    }

    @When("Scroll to bottom of page")
    public void scroll_to_bottom_of_page() {
        BrowserUtils.scrollDownUntilElementFount(Driver.getDriver().findElement(By.cssSelector(
                ".recommended_items .title.text-center")));
    }

    @When("Verify RECOMMENDED ITEMS are visible")
    public void verify_recommended_items_are_visible() {
        Assert.assertEquals("RECOMMENDED ITEMS", pages.homePage().verifyRecommendedItems());
    }

    @When("Click on Add To Cart on Recommended product")
    public void click_on_add_to_cart_on_recommended_product() {
        pages.homePage().addItemFromRecommendedItems();
    }

    @When("Verify that product is displayed in cart page")
    public void verify_that_product_is_displayed_in_cart_page() {
        //We will see if there are more than zero items in the cart, than that means our item is added.
        List<WebElement> elements = Driver.getDriver().findElements(By.cssSelector(".cart_description"));
        if (elements.size() == 0) {
            Assert.fail();
        }
    }

    @Then("Verify that the delivery address is same address filled at the time registration of account")
    public void verify_that_the_delivery_address_is_same_address_filled_at_the_time_registration_of_account() {
        // We will create a list, so I will use locator here:
        List<WebElement> address_information = Driver.getDriver().findElements(By.cssSelector("#address_delivery li"));
        int index = 1;
        try {
            File file = new File("address_information.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String info = address_information.get(index).getText();
                String real_info = sc.nextLine();
                if (!real_info.equals(info)) {
                    Assert.fail(info + " does not match with " + real_info);
                }
                index++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Then("Click Download Invoice button and verify invoice is downloaded successfully.")
    public void click_download_invoice_button_and_verify_invoice_is_downloaded_successfully() {
        Driver.getDriver().findElement(By.cssSelector(".btn.btn-default.check_out")).click();
        BrowserUtils.wait(2);
    }
    @Then("Click on arrow at bottom right side to move upward")
    public void click_on_arrow_at_bottom_right_side_to_move_upward() {
        pages.homePage().clickScrollUpButton();
    }
    @Then("Verify that page is scrolled up and {string} text is visible on screen")
    public void verify_that_page_is_scrolled_up_and_text_is_visible_on_screen(String verify) {
        Assert.assertEquals(verify, pages.homePage().verifyFullFledgedPracticeWebsite());
    }
    @Then("Scroll up page to top")
    public void scroll_up_page_to_top() {
        BrowserUtils.scrollDown(0, -300);
    }
}
