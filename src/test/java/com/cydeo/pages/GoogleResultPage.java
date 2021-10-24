package com.cydeo.pages;

import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 *      * - Google SearchResultPage
 *      *   - Fields
 *      *      searchResultCount
 *      *      resultLinks (list of webElement )
 *      *   - Methods
 *      *      getResultCountText
 *      *      getAllResultLinkText
 */

public class GoogleResultPage {

    @FindBy(id="result-stats")
    private WebElement searchResultCount ;

    @FindBy(xpath = "//H3[@class='LC20lb DKV0Md']")
    private List<WebElement> resultLinks ;

    public GoogleResultPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * Get the text of result element that contains search result total
     * @return the text of search Result Count element
     */
    public String getResultCountText(){
        return searchResultCount.getText();
    }

    /**
     *
     */
    public void printAllSearchResultLinks(){

        System.out.println("resultLinks.size() = " + resultLinks.size());

        for (WebElement eachLinkElm : resultLinks) {
            // remove empty resultLinks
            if (eachLinkElm.getText().equals("")){
                continue;
            }else {
                System.out.println("eachLinkElm.getText() = " + eachLinkElm.getText());
            }
        }
    }




}
