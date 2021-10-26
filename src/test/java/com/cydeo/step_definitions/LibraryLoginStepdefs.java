package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LibraryLoginStepdefs {
    @Given("user is at library login page")
    public void userIsAtLibraryLoginPage() {
    }

    @When("user use username {string} and passcode {string}")
    public void userUseUsernameAndPasscode(String email, String password) {
    }

    @Then("user should be at dashboard page")
    public void userShouldBeAtDashboardPage() {
    }
}
