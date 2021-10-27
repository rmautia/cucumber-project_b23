package com.cydeo.pages;

import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

    @FindBy(name="q")
    private WebElement searchBox ;

    @FindBy(name = "btnK")
    private WebElement searchBtn ;

    @FindBy(linkText = "English")
    private WebElement translate ;

    public GoogleHomePage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * navigate to google homepage
     */

    public void goTo(){

        //Driver.getDriver().get("https://google.com");
        Driver.getDriver().navigate().to(ConfigReader.read("google.url"));

    }

    public void searchKeyWord( String keyword ){
        this.searchBox.sendKeys( keyword );
        this.searchBtn.submit();
    }

    public boolean isAT(){

      return  Driver.getDriver().getTitle().equals("Google");

    }



}
/**
 * Create 2 Pages Object for
 * - Google homepage
 *  Fields :
 *  - searchbox element
 *  - search button
 *  Methods
 *   - searchKeyWord
 *     - accept 1 string param as keyword
 *     - return nothing
 *     - should enter keyword and click search button
 *   - isAt
 *     - accept no param
 *     - return true if title match , false if not
 *   - goTo
 *      - void method with no param and navigate to google (use config reader for url)
 *
 * - Google SearchResultPage
 *   - Fields
 *      searchResultCount
 *      resultLinks (list of webelement )
 *   - Methods
 *      getResultCountText
 *      getAllResultLinkText
 */
