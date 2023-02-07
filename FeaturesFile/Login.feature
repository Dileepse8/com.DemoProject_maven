Feature: Login Functionality

@sanity
  Scenario: Login with Valid Credentials
    Given User Launch the Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/"
    And User Enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login button
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout Link
    Then Page Title should be "Your store. Login"
    And close the browser

 @sanity @regression
  Scenario Outline: Login with Valid Credentials
    Given User Launch the Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/"
    And User Enters Email as "<Email>" and Password as "<Password>"
    And Click on Login button
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout Link
    Then Page Title should be "Your store. Login"
    And close the browser
    Examples:

      | Email               | Password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | admin1   |
