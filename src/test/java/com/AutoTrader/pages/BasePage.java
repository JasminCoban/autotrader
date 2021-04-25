package com.AutoTrader.pages;

import com.AutoTrader.utilities.BrowsilUtils;
import com.AutoTrader.utilities.MyDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(MyDriver.get(), this);
    }


    public static void clearCookies() {
        //delete all cookies
        MyDriver.get().manage().deleteAllCookies();
    }

    public void scrollDown(WebElement link) {
        /**
         *  this script must scroll, until link element is visible
         *  once link element visible, it will stop scrolling
         *  arguments[0] = means first webelement after comma (link)
         *  arguments it's an array of webelements after comma
         *  arguments[0] = link web element, it can be any web element
         */

        BrowsilUtils.wait(2);
        JavascriptExecutor js = (JavascriptExecutor)MyDriver.get();
        BrowsilUtils.wait(2);
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        BrowsilUtils.wait(2);

    }



}
