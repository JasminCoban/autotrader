package com.AutoTrader.pages;

import com.AutoTrader.utilities.MyDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.sql.Driver;

public class AutoTraderPage {

    @FindBy (xpath = "//span[contains(@title, 'Browse by Make')]")
    public WebElement BrowseByMake;

    @FindBy(xpath = "//span[@title='Browse by Style']")
    public WebElement BrowseByStyle;


    @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
    public WebElement advancedSearchButton;

    @FindBy (id = "search")
    public WebElement searchButton;

    @FindBy (id = "makeCodeListPlaceHolder")
    public WebElement anyMakeelement;

    @FindBy (id = "modelCodeListPlaceHolder")
    public WebElement anyModulelement;


    public AutoTraderPage(){
        PageFactory.initElements(MyDriver.get(),this);

    }

    public void Verification(String expected) {

        if (expected.equals("BrowseByMake")) {
            String actual = BrowseByMake.getText();
            Assert.assertEquals(expected, actual);
        } else if (expected.equals("BrowseByStyle")) {
            String actual = BrowseByStyle.getText();
            Assert.assertEquals(expected, actual);
        } else if ((expected.equals("AdvancedSearch"))){
            String actual = advancedSearchButton.getText();
            Assert.assertEquals(expected, actual);
        }
    }
    //Verifiying search button is enable
        public void searchButtonVerification(){
        Assert.assertTrue(searchButton.isEnabled());

    }
  //Verifiying make and module are visible
    public void verifyMakeAndModule(String anyMake, String anyModul){
        Assert.assertTrue(anyMakeelement.isEnabled());
        Assert.assertTrue(anyModulelement.isEnabled());
    }



}
