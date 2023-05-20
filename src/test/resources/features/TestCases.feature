Feature: All the test cases are below

  @TestCase1
  Scenario: Register User
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    And Click on 'Signup / Login' button
    Then Verify 'New User Signup!' is visible
    And Enter name and email address
    Then Click Signup button
    And Verify that 'ENTER ACCOUNT INFORMATION' is visible
    Then Fill details: Title, Name, Email, Password, Date of birth
    And Select checkbox Sign up for our newsletter!
    Then Select checkbox Receive special offers from our partners!
    And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    Then Click Create Account button
    And Verify that ACCOUNT CREATED! is visible
    Then Click Continue button
    And Verify that Logged in as username is visible
    Then Click Delete Account button
    And Verify that ACCOUNT DELETED! is visible and click Continue button

  @TestCase2
  Scenario: Login User with correct email and password
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    And Click on 'Signup / Login' button
    Then Verify Login to your account is visible
    And Enter correct email address and password
    Then Click login button
    Then Verify that Logged in as username is visible
    Then Click Delete Account button
    And Verify that ACCOUNT DELETED! is visible and click Continue button

  @TestCase3
  Scenario: Login User with correct email and password
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    And Click on 'Signup / Login' button
    Then Verify Login to your account is visible
    Then Enter incorrect email address and password
    Then Click login button
    Then Verify error 'Your email or password is incorrect!' is visible

  @TestCase4
  Scenario: Logout User
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    And Click on 'Signup / Login' button
    Then Verify Login to your account is visible
    And Enter correct email address and password
    Then Click login button
    Then Verify that Logged in as username is visible
    Then Click 'Logout' button
    Then Verify that user is navigated to login page

  @TestCase5
  Scenario: Register User with existing email
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    And Click on 'Signup / Login' button
    Then Verify 'New User Signup!' is visible
    Then Enter name and already registered email address
    And Click Signup button
    Then Verify error Email Address already exist! is visible

  @TestCase6
  Scenario: Contact Us Form
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    And Click on 'Contact us' button
    And Verify GET IN TOUCH is visible
    And Enter name, email, subject and message
    And Upload file
    And Click Submit button
    And Click OK button
    And Verify success message 'Success! Your details have been submitted successfully.' is visible
    And Click 'Home' button and verify that landed to home page successfully

  @TestCase7
  Scenario: Verify Test Cases Page
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    And Click on 'Test Cases' button
    And Verify user is navigated to test cases page successfully

  @TestCase8
  Scenario: Verify All Products and product detail page
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    And Click on Products button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And Click on View Product of first product
    And User is landed to product detail page
    And Verify that detail is visible: product name, category, price, availability, condition, brand

  @TestCase9
  Scenario: Search Product
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    And Click on Products button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And Enter product name in search input and click search button
    And Verify SEARCHED PRODUCTS is visible
    And Verify all the products related to search are visible

  @TestCase10
  Scenario: Verify Subscription in home page
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    Then Scroll down to footer
    Then Verify text SUBSCRIPTION
    Then Enter email address in input and click arrow button
    Then Verify success message You have been successfully subscribed! is visible

  @TestCase11
  Scenario: Verify Subscription in Cart page
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    Then Click 'Cart' button
    Then Scroll down to footer
    Then Verify text SUBSCRIPTION
    Then Enter email address in input and click arrow button
    Then Verify success message You have been successfully subscribed! is visible

  @TestCase12
  Scenario: Add Products in Cart
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    Then Click on Products button
    Then Hover over first product and click Add to cart
    Then Click Continue Shopping button
    Then Hover over second product and click Add to cart
    Then Click 'View Cart' button
    Then Verify both products are added to Cart
    Then Verify their prices, quantity and total price

  @TestCase13
  Scenario: Verify Product quantity in Cart
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    Then Click View Product for any product on home page
    Then Verify product detail is opened
    Then Increase quantity to 4
    Then Click Add to cart button
    Then Click 'View Cart' button
    Then Verify that product is displayed in cart page with exact quantity

  @TestCase14
  Scenario: Place Order: Register while Checkout
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    Then Add products to cart
    Then Click 'View Cart' button
    Then Verify that cart page is displayed
    Then Click Proceed To Checkout
    Then Click 'Register / Login' button
    Then Fill all details in Signup and create account
    Then Verify ACCOUNT CREATED! and click Continue button
    Then Verify that Logged in as username is visible
    Then Click 'Cart' button
    Then Click Proceed To Checkout button
    Then Verify Address Details and Review Your Order
    Then Enter description in comment text area and click Place Order
    Then Enter payment details: Name on Card, Card Number, CVC, Expiration date
    Then Click Pay and Confirm Order button
    Then Verify success message Your order has been placed successfully!
    Then Click 'Delete Account' button
    Then Verify that ACCOUNT DELETED! is visible and click Continue button

  @TestCase15
  Scenario: Place Order: Register before Checkout
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    And Click on 'Signup / Login' button
    Then Fill all details in Signup and create account
    Then Verify ACCOUNT CREATED! and click Continue button
    Then Verify that Logged in as username is visible
    Then Add products to cart
    Then Click 'View Cart' button
    Then Verify that cart page is displayed
    Then Click Proceed To Checkout button
    Then Verify Address Details and Review Your Order
    Then Enter description in comment text area and click Place Order
    Then Enter payment details: Name on Card, Card Number, CVC, Expiration date
    Then Click Pay and Confirm Order button
    Then Verify success message Your order has been placed successfully!
    Then Click 'Delete Account' button
    Then Verify that ACCOUNT DELETED! is visible and click Continue button


  @TestCase16
  Scenario: Place Order: Login before Checkout
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    And Click on 'Signup / Login' button
    And Enter correct email address and password
    Then Click login button
    Then Verify that Logged in as username is visible
    Then Add products to cart
    Then Click 'View Cart' button
    Then Verify that cart page is displayed
    Then Click Proceed To Checkout button
    Then Verify Address Details and Review Your Order
    Then Enter description in comment text area and click Place Order
    Then Enter payment details: Name on Card, Card Number, CVC, Expiration date
    Then Click Pay and Confirm Order button
    Then Verify success message Your order has been placed successfully!
    Then Click 'Delete Account' button
    Then Verify that ACCOUNT DELETED! is visible and click Continue button

  @TestCase17
  Scenario: Remove Products From Cart
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    Then Add products to cart
    Then Click 'View Cart' button
    Then Verify that cart page is displayed
    Then Click X button corresponding to particular product
    Then Verify that product is removed from the cart

  @TestCase18
  Scenario: View Category Products
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    Then Click on 'WOMEN' category
    Then Click on any category link under Women category, for example: "Dress"
    Then Verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'
    Then On left side bar, click on any sub-category link of 'MEN' category : "JEANS"
    Then Verify that user is navigated to that category page

  @TestCase19
  Scenario: View & Cart Brand Products
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    And Click on Products button
    And Verify that Brands are visible on left side bar
    And Click on any brand name : "POLO"
    And Verify that user is navigated to brand page and brand products are displayed
    And On left side bar, click on any other brand link : "MADAME"
    And Verify that user is navigated to that brand page and can see products

  @TestCase20
  Scenario: Search Products and Verify Cart After Login
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    And Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    Then Enter product name in search input and click search button
    Then Verify SEARCHED PRODUCTS is visible
    Then Verify all the products related to search are visible
    Then Add those products to cart
    Then Click 'Cart' button and verify that products are visible in cart
    Then Click 'Signup / Login' button and submit login details
    Then Again, go to Cart page
    Then Verify that those products are visible in cart after login as well

  @TestCase21
  Scenario: Add review on product
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    And Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    Then Click on View Product button
    Then Verify Write Your Review is visible
    Then Enter name, email and review
    Then Click Submit  button
    Then Verify success message 'Thank you for your review.'

  @TestCase22
  Scenario: Add to cart from Recommended items
    Given Launch browser
    When Navigate to given url
    When Scroll to bottom of page
    When Verify RECOMMENDED ITEMS are visible
    When Click on Add To Cart on Recommended product
    When Click on 'View Cart' button
    When Verify that product is displayed in cart page

  @TestCase23
  Scenario: Place Order: Register while Checkout
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    Then Add products to cart
    Then Click 'View Cart' button
    Then Verify that cart page is displayed
    Then Click Proceed To Checkout
    Then Click 'Register / Login' button
    Then Fill all details in Signup and create account
    Then Verify ACCOUNT CREATED! and click Continue button
    Then Verify that Logged in as username is visible
    Then Click 'Cart' button
    Then Verify that cart page is displayed
    Then Click Proceed To Checkout
    Then Verify that the delivery address is same address filled at the time registration of account
    Then Click 'Delete Account' button
    Then Verify that ACCOUNT DELETED! is visible and click Continue button

  @TestCase24
  Scenario: Download Invoice after purchase order
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    Then Add products to cart
    Then Click 'View Cart' button
    Then Verify that cart page is displayed
    Then Click Proceed To Checkout
    Then Click 'Register / Login' button
    Then Fill all details in Signup and create account
    Then Verify ACCOUNT CREATED! and click Continue button
    Then Verify that Logged in as username is visible
    Then Click 'Cart' button
    Then Click Proceed To Checkout button
    Then Verify Address Details and Review Your Order
    Then Enter description in comment text area and click Place Order
    Then Enter payment details: Name on Card, Card Number, CVC, Expiration date
    Then Click Pay and Confirm Order button
    Then Verify success message Your order has been placed successfully!
    Then Click Download Invoice button and verify invoice is downloaded successfully.
    Then Click 'Continue' button
    Then Click 'Delete Account' button
    Then Verify that ACCOUNT DELETED! is visible and click Continue button

  @TestCase25
  Scenario: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    Then Scroll down to footer
    Then Verify text SUBSCRIPTION
    Then Click on arrow at bottom right side to move upward
    Then Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen

  @TestCase26
  Scenario: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
    Given Launch browser
    When Navigate to given url
    Then Verify that home page is visible successfully
    Then Scroll down to footer
    Then Verify text SUBSCRIPTION
    Then Scroll up page to top
    Then Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen