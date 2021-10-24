package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleHomePage;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class GoogleSearchStepDef {

    GoogleHomePage homePage;

    @Given("user is at home page")
    public void userIsAtHomePage() {

        // navigate to google home page

        homePage = new GoogleHomePage();
        homePage.goTo();
    }

    @When("user search for keyword {string}")
    public void userSearchForKeyword(String keyword) {

        homePage.searchKeyWord(keyword);

    }

    @Then("we should see result page")
    public void weShouldSeeResultPage() {
        System.out.println("I can print the title in the next method");
    }

    @And("the title should start with {string}")
    public void theTitleShouldStartWith(String keyword) {

       assertTrue (Driver.getDriver().getTitle().startsWith(keyword));


    }
}
