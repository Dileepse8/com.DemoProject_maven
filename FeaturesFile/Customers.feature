Feature: Customers CRUD Operations

  Background: 
    Given User Launch the Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/"
    And User Enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login button
    Then User can view Dashboard
    When User click on customers Menu
    And click on customers Menu Item

  @sanity
  Scenario: Adding Customers Scenario
    And click on Add new button
    Then User can view Add new customer Page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close the browser

  @regression
  Scenario: Searching Customers By Email Scenario
    And Enter Customer Email on SearchBox
    When Click on Search button
    Then User should found Email in the Search table
    And close the browser

  @regression
  Scenario: Searching Customers By FirstName and LastName Scenario
    And Enter Customer FirstName
    And Enter Customer LastName
    When Click on Search button
    Then User should found Name in the Search table
    And close the browser
