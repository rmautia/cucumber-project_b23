package com.cydeo.step_definitions;

import com.cydeo.pages.WLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class DataTablesStepDefs {

    @Given("I have a {string}")
    public void i_have_a(String animal) {
        System.out.println("Given I have a "+animal);
    }
    @When("I call their names")
    public void i_call_their_names() {
        System.out.println("When I call their name");
    }
    @Then("They come to me.")
    public void they_come_to_me() {
        System.out.println("Then they come to me");
    }


    @Given("I have the following animals")
    public void i_have_the_following_animals(List<String> animalList) {

        System.out.println("animalList = " + animalList);

    }


    @When("I call their names with below names")
    public void iCallTheirNamesWithBelowNames(List<String > nameList) {
        System.out.println("nameList = " + nameList);
    }

//    @Then("They come to me with below noise")
//    public void theyComeToMeWithBelow(Map<String, String > animalNoiseMap) {
//
//        System.out.println("animalNoiseMap = " + animalNoiseMap);
//
//    }

    @Then("They come to me with below noise")
   public void theyComeToMeWithBelow(List<List<String>> animalRowList) {

       System.out.println("animalRowList = " + animalRowList);

   }

    @When("we provide below credentials")
    public void weProvideBelowCredentials(Map<String, String> credentialMap) {

        String usernameFromTable = credentialMap.get("username");
        String passwordFromTable = credentialMap.get("password");

        System.out.println("credentialMap = " + credentialMap);
        WLoginPage loginPage = new WLoginPage();
        loginPage.login(usernameFromTable, passwordFromTable);


    }

    @Given("this is the product reference")
    public void thisIsTheProductReference(List<Map<String, Object>> productMapLst) {

        for (Map<String, Object> eachRowMap : productMapLst) {
            System.out.println("eachRowMap = " + eachRowMap);
        }
    }

    @And("I have another product reference without header")
    public void headlessTable(List< List<String> > productInfoList) {
        /**
         *       | MyMoney     | 100   | 0.08     |
         *       | FamilyAlbum | 80    | 0.15     |
         *       | ScreenSaver | 20    | 0.1      |
         */
        System.out.println("productInfoList = " + productInfoList);

        // get me entire 3rd row
        List<String> thirdRow = productInfoList.get(2);
        System.out.println("thirdRow = " + thirdRow);
        // get the price value of third row
        System.out.println("thirdRow price is = " + thirdRow.get(1));

        // get the discount column of first row
        System.out.println("First row 3rd column value productInfoList.get(0).get(2) = "
                + productInfoList.get(0).get(2));
    }
}

