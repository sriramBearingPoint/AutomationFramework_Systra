Feature: Create Product

@SmokeTest
Scenario: Create and validate product - Positive Test
     Given Login to ifs cloud page with username sriram.karanam and password abcd1234
     When 	Navigate to products and models and create a new product
     Then  Validate the product which is created
@SmokeTest
  Scenario: Create and validate product - Negative Test
    Given Login to ifs cloud page with username <username> and password <password>
    When Navigate to products and models and create a new product
    Then Validate the product which is created should not list in product list
@Sprint2 
  Scenario: Create and validate product - Positive Test
    Given Login to ifs cloud page with username username and password password
    When Navigate to products and models and create a new product
    Then Validate the product which is created
@UAT 
  Scenario Outline: Create and validate product - Negative Test
    Given Login to ifs cloud page with username <username> and password <password>
    When Navigate to products and models and create a new product
    Then Validate the product which is created should not list in product list
    Examples:
      | username       | password |
      | sriram.karanam | abcd1234 |
     
 @Reg 
  Scenario Outline: Create and validate product - Postive Test
    Given Login to ifs cloud page from excell sheet login "<SheetName>" and rownumber <RowNumber>
    When Navigate to products and models and create a new product
    Then Validate the product which is created should not list in product list
    Examples:
      | SheetName|RowNumber|
      | Loginuser| 0 |
      | Loginuser| 1 |
      

  