package com.cydeo.step_definitions;

import com.cydeo.pages.WAllProductPage;
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
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WebOrderStepDef {
    @When("we select {string} tab from sidebar")
    public void weSelectTabFromSidebar(String tabName) {
        System.out.println("tabName = " + tabName);
        WCommonArea commonArea = new WCommonArea();
        switch (tabName) {
            case "View all products" :
                commonArea.viewAllProductTab.click();
                break;
            case "View all orders" :
                commonArea.viewAllOrderTab.click();
                break;
            case "Order":
                commonArea.orderTab.click();
                break;
        }


    }

    @Then("I should see below options in product dropdown list")
    public void iShouldSeeBelowOptionsInProductDropdownList(List<String> expectedOptions) {
        System.out.println("options = " + expectedOptions);

        WOrderPage orderPage = new WOrderPage();

        WebElement dropdown = orderPage.productDropDown;
        Select selectObj = new Select(dropdown);

        List<String> actualOptions = orderPage.getAllProductOptionFromList();

        // assert that these two lists are equal
        // import static org.junit.Assert.assertEquals;
        assertEquals(expectedOptions,actualOptions);

    }

    @Then("we should see table with below content")
    public void weShouldSeeTableWithBelowContent(List<Map<String,String>> productMapLst) {

        System.out.println("productMapLst = " + productMapLst);

        // how to get first map
        Map<String,String> expectedFirstRowMap = productMapLst.get(0) ;

        WAllProductPage allProductPage = new WAllProductPage();

        System.out.println("allProductPage.getRowMapFromWebTable() = "
                + allProductPage.getRowMapFromWebTable());

        Map<String,String> actualFirstRowMap = allProductPage.getRowMapFromWebTable() ;

        // assert two maps are equal
        assertEquals(  expectedFirstRowMap , actualFirstRowMap );


        // assert the first row match from datatable and web table




//        // get expected headers :
//        Set<String> headerSet = productMapLst.get(0).keySet() ;
//        System.out.println("headerSet = " + headerSet);
//
//        // get actual header :
//        List<String> actualHeaders = allProductPage.getAllHeaderText();
//        System.out.println("actualHeaders = " + actualHeaders);
//
//        // check the size is the same
//        assertEquals(headerSet.size() , actualHeaders.size() );
//
//        // list to set equality check will not work
//        // so we need to turn the set into list
//        List<String> expectedHeaders = new ArrayList<>( headerSet );
//        assertEquals(expectedHeaders, actualHeaders);


    }
}
