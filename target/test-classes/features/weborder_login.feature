@ui
Feature: Web order app login
     As a user
     I should be able  to login to web order app

  # this is where repeating beginning code can go, this is how we comment in cucumber
  Background:
#    This is a shared step for all scenarios so we remove duplicate
#    for putting it in Background section of feature
    Given we are at web order login page


  Scenario: User login successfully
#    Given we are at web order login page
    When we provide valid credentials
    Then we should see all order page

  Scenario: User login fail
#    Given we are at web order login page
    When we provide invalid credentials
    Then we should still be at login page
    And login error message should be present

    @blah
  Scenario: User login with specific credentials
#    whatever is enclosed inside quotation "" will be sent a parameter value
#    step definition will look like this
#     @When("user provide username {string} and password {string}")
    When user provide username "Tester" and password "test"
    Then we should see all order page


      @blah
  Scenario: User login with wrong credentials
    When user provide username "Blah" and password "Blah"
    Then we should still be at login page
    And login error message should be present

