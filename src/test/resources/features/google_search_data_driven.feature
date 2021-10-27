@ui @go_home
Feature: Google Search Data Driven

  As a user ,
  I should be able to search by keyword
  and get my result

## modify this to make it data driven scenario that search for multiple keywords
  Scenario Outline: User search by keyword
    Given user is at home page
    When user search for keyword "<keyword>"
    Then the title should start with "<keyword>"
    Examples:
      | keyword                        |
      | cybertruck                     |
      | selenium                       |
      | steve jobs                     |
      | sdet jobs                      |
      | how to make 100k by being SDET |
