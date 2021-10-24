package com.cydeo.pages;

import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WLoginPage {

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement userNameField;

    @FindBy(name = "ctl00$MainContent$password")
    public WebElement passwordField ;

    @FindBy(css = "#ctl00_MainContent_login_button")
    public WebElement loginButton ;

    @FindBy(xpath = "//span[.='Invalid Login or Password.']")
    public WebElement errorMsg;

     // PageFactory is a Selenium class that support Page Object Model
    // and it  has method called initElements
    // once it is called, it will locate all the elements.
    // specified using @FindBy notation
    // now we need to instruct selenium to start looking for element
    // when this constructor is called

    public WLoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    public void goTo(){
        Driver.getDriver().navigate().to(ConfigReader.read("weborder_url"));
    }

    /**
     * login with parameters
     * @param username username
     * @param password password
     */

    public void login(String username, String password){

        // You can access directly using userNameField or using this.userNameField
        this.userNameField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.loginButton.click();

    }
    /**
     * check error message is present if wrong credentials is provided
     * LoginErrorMessage present. simply return the result of isDisplayed method call
     */

    public boolean loginErrorMsgPresent(){

        return this.errorMsg.isDisplayed();
    }




}
