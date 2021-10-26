package com.cydeo.step_definitions;

import com.cydeo.pages.WCommonArea;
import com.cydeo.pages.WOrderPage;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WebOrderStepDef {
    @When("we select {string} tab from sidebar")
    public void weSelectTabFromSidebar(String tabName) {
        System.out.println("tabName = " + tabName);
        WCommonArea commonArea = new WCommonArea();
        commonArea.orderTab.click();


    }

    @Then("I should see below options in product dropdown list")
    public void iShouldSeeBelowOptionsInProductDropdownList(List<String> expectedOptions) {
        System.out.println("options = " + expectedOptions);

        WOrderPage orderPage = new WOrderPage();

        WebElement dropdown = orderPage.productDropDown;
        Select selectObj = new Select(dropdown);

        // get options method from select class is used
        // to return all dropdown options as List of webelement
        List<WebElement> allProductOptions = selectObj.getOptions();
        // this is the list to store actual option so we can compare with expected
        List<String> actualOptions = new ArrayList<>();

        for (WebElement eachOption : allProductOptions) {
            System.out.println("eachOption.getText() = " + eachOption.getText());
            actualOptions.add(eachOption.getText());
        }

        // assert that these two lists are equal
        // import static org.junit.Assert.assertEquals;
        assertEquals(expectedOptions,actualOptions);

    }
}
