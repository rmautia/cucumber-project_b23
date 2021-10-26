@ui
Feature: web order should work as expected

  @wip
  Scenario: User should see all product from the list according to available product
    Given we are at web order login page
    And we provide valid credentials
    When we select "Order" tab from sidebar
    Then I should see below options in product dropdown list
      | MyMoney     |
      | FamilyAlbum |
      | ScreenSaver |
