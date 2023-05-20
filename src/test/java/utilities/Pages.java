package utilities;

import pages.*;

public class Pages {
    private HomePage homePage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private ContactPage contactPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    public Pages() {
        this.loginPage = new LoginPage();
        this.homePage = new HomePage();
        this.signupPage = new SignupPage();
        this.contactPage = new ContactPage();
        this.productsPage = new ProductsPage();
        this.cartPage = new CartPage();
    }

    public CartPage cartPage() {
        return cartPage;
    }

    public ProductsPage productsPage() {
        return productsPage;
    }

    public ContactPage contactPage() {
        return contactPage;
    }

    public SignupPage signupPage(){
        return signupPage;
    }

    public LoginPage loginPage() {
        return loginPage;
    }

    public HomePage homePage() {
        return homePage;
    }
}
