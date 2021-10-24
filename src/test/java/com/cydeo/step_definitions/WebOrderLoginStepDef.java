package com.cydeo.step_definitions;

import com.cydeo.pages.WLoginPage;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class WebOrderLoginStepDef {

    // putting the login variable at class level so that it can be available to all methods
    WLoginPage loginPage;

    @Given("we are at web order login page")
    public void we_are_at_web_order_login_page() {

        // navigate to the login page
        loginPage = new WLoginPage();
        loginPage.goTo();


    }
    @When("we provide valid credentials")
    public void we_provide_valid_credentials() {

        loginPage.login("Tester", "test");

    }
    @Then("we should see all order page")
    public void we_should_see_all_order_page() {

        // cucumber j-unit dependency already come with j-unit 4
        // So we will be just using assertions methods coming from junit 4
        // it's extremely similar just coming from different dependency
        // so the package import will be different
        // import static org.junit.Assert.*;

        assertEquals("Web Orders", Driver.getDriver().getTitle());

    }



    @When("we provide invalid credentials")
    public void weProvideInvalidCredentials() {

        loginPage.login("Blah","blah");

    }

    @Then("we should still be at login page")
    public void weShouldStillBeAtLoginPage() {

        assertEquals("Web Orders Login", Driver.getDriver().getTitle());

    }

    @And("login error message should be present")
    public void loginErrorMessageShouldBePresent() {

        assertTrue(loginPage.loginErrorMsgPresent());

    }


    @When("user provide username {string} and password {string}")
    public void isProvideUsernameAndPassword(String username, String password) {

        // username = "whatever is provided in the scenario step "
        // password = "Whatever is provided in the scenario step"
        loginPage.login(username, password);
    }
}
