package com.cydeo.pages;


import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WCommonArea {

    @FindBy(id = "ct100_logout" )
    public WebElement logoutLInk ;

    @FindBy(linkText ="View all orders" )
    public WebElement viewAllOrderTab ;

    @FindBy(linkText = "View all products")
    public WebElement viewAllProductTab ;

    @FindBy(linkText = "Order")
    public WebElement orderTab ;

    public WCommonArea(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
