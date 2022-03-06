Feature: Search Product

  @Signing
  Scenario Outline: Launch the Github application and verify the repository
    Given I open the UR in browse "<url>" and  "<browser>"
    When Moving the cursor over the Women link
    Then Clicked on the sub Menu T-shirts
    Then Validate name of the first product display
    Then Now enter the same product name in the search bar present on top of page and click the search button
    Then Validate that the same product is displayed on a searched page with the same details which were displayed on T-Shirt's page.

    Examples:
     |url                                     | browser   |
     |http://automationpractice.com/index.php |  Chrome   |