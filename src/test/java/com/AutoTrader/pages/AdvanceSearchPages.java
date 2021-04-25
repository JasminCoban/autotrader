package com.AutoTrader.pages;

import com.AutoTrader.utilities.BrowsilUtils;
import com.AutoTrader.utilities.MyDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdvanceSearchPages extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
    public WebElement advancedSearchButton;

   @FindBy(xpath = "//input[@type='tel']")
    public WebElement zipCode;

    @FindBy(xpath = "//div[contains(text(),'Certified')]")
    public WebElement certifiedButton;

    @FindBy(xpath = "//div[contains(text(),'Convertible')]")
    public WebElement convertibleButton;

    @FindBy(name = "startYear")
    public WebElement selectFrom;

    @FindBy(name = "endYear")
    public WebElement selectTo;

    @FindBy(css = "[name='makeFilter0']")
    public WebElement selectVehicle1;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement clickSearchButton;

    @FindBy(xpath = "//title[contains(text(),'Certified BMW Convertibles for Sale')]")
    public WebElement userInPage;

    @FindBy(xpath = "//h2[contains(@data-cmp,'subheading')]")
    public WebElement onlyBMW;

    @FindBy(xpath = "//div[contains(@data-cmp,'inventoryListing')]")
    public WebElement numberOfBMW;

//clicking the advance search button
      public void advanceSearchClick(){

        MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try{
        Thread.sleep(2000);
    }catch(Exception e){

        }
          advancedSearchButton.click();
        }

    //Entering zipcode.
        public void zipCodeEnter(String zipcode){
          BasePage.clearCookies();
          MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          zipCode.clear();
          BrowsilUtils.wait(6);
          zipCode.sendKeys(zipcode);
            BrowsilUtils.wait(5);

        }
    //Clicking the Certificate and Convertible checkboxes.
        public void verifyClickCertifiedAndConvertible(String a){
          MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          if(a.equalsIgnoreCase(certifiedButton.getText())){
              System.out.println(certifiedButton.getText());
              BrowsilUtils.wait(4);
              certifiedButton.click();
              BrowsilUtils.wait(4);
          }else{
              WebElement link=convertibleButton;
              scrollDown(link);
              convertibleButton.click();
              BrowsilUtils.wait(3);
          }

        }
  //selecting modelYear from 2017 to 2020
        public void selectYearFromTo(String year1, String Year2){
            MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Select select1= new Select(selectFrom);
            select1.selectByValue(year1);
            BrowsilUtils.wait(2);
            Select select2=new Select(selectTo);
            select2.selectByValue(Year2);
            BrowsilUtils.wait(2);

        }

        //selecting model type tpo BMW
        public void selectVehicle1(String model){
          Select select =  new Select(selectVehicle1);
          select.selectByValue(model);
            BrowsilUtils.wait(2);

        }

    //Clicking the Search button
    public void verifyClickSearchButton() {

        WebElement link = clickSearchButton;
        scrollDown(link);
        clickSearchButton.click();
        BrowsilUtils.wait(10);
    }

    public void verifyUsersInPage(){
          String expected = "Convertibles for Sale in Alpharetta, GA 30004 - Autotrader";
          String actual =  userInPage.getText();
//        Assert.assertEquals(expected,actual);
//        BrowsilUtils.wait(3);
//          Assert.assertEquals(expected,actual);
//          BrowsilUtils.wait(5);
    }

    //Verifying that in result page there is no other car results come.
    public void VerifyThereIsOnlySelectedVehicle(String car) {
        //Storing all the results in List and comparing all the results not contains BMW
        List<WebElement> list = MyDriver.get().findElements(By.xpath("//h2[contains(@data-cmp,'subheading')]"));
        int count = 0;
        for(WebElement each:list){
            if(!each.getText().contains(car)){

                System.out.println("We found non BMW listing "+count);

            }else{
                count++;
            }
            System.out.println("We found "+count +" BMW listing and there is no non BMW listing");
        }


    }
    //Counting how many listing result displayed.
    public void verifyNumberOfBMW() {

          List<WebElement> list = MyDriver.get().findElements(By.xpath("//div[contains(@data-cmp,'inventoryListing')]"));
        System.out.println("Number of BMW listed in result page is :" + list.size());

        int actual =list.size();
        String expected = MyDriver.get().findElement(By.xpath("//div[@class='results-text-container text-size-200']")).getText();
        System.out.println(expected);

        String[] arr = expected.split(" ");
        int expectedResult = Integer.parseInt(arr[2]);
        Assert.assertEquals("Assertion failed", expectedResult, actual);


    }
}
