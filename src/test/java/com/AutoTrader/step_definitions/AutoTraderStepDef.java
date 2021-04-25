package com.AutoTrader.step_definitions;

import com.AutoTrader.pages.AdvanceSearchPages;
import com.AutoTrader.pages.AutoTraderPage;
import com.AutoTrader.pages.BasePage;
import com.AutoTrader.utilities.BrowsilUtils;
import com.AutoTrader.utilities.ConfigurationReader;
import com.AutoTrader.utilities.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;
import java.util.logging.SocketHandler;

public class AutoTraderStepDef  {

    AutoTraderPage autoTraderPage = new AutoTraderPage();
    AdvanceSearchPages advanceSearchPages =new AdvanceSearchPages();

    @ Given ("user test with {string} browser")

    public void user_test_with_browser(String brs) {
        if (brs.equals("chrome")) {
            //ConfigurationReader.getProperty("browser");
            System.setProperty("browser", "chrome");


        } else
            //ConfigurationReader.getProperty("browserfx");
            System.setProperty("browser", "firefox");
    }

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        System.out.println("Landing Page");
        String actualTitle = MyDriver.get().getTitle();
        String expectedTitle = "New Cars, Used Cars - Find Cars for Sale and Reviews at Autotrader";
        Assert.assertEquals(expectedTitle,actualTitle);
        System.out.println(actualTitle);

    }

    @Given("user verifies that {string} is present")
    public void user_verifies_that_is_present(String string) {
        autoTraderPage.Verification(string);
        System.out.println(" 'Browse By Make' is present ");
        System.out.println(" 'Browse By Style' is present ");
        System.out.println(" 'Advanced search' is present ");
    }

    @Then("user verifies that search button is present")
    public void user_verifies_that_search_button_is_present() {
        autoTraderPage.searchButtonVerification();
        System.out.println(" Search button is present on the landing page ");
    }

    @Then("user verifies that {string} and {string} are visible")
    public void user_verifies_that_and_are_visible(String anyMake, String anyModul) {
        autoTraderPage.verifyMakeAndModule(anyMake, anyModul);
        System.out.println("'Any Make' and 'Any Module' options are present ");

    }
    @When("user clicks on Advanced Search link on the home page")
    public void user_clicks_on_Advanced_Search_link_on_the_home_page() {

    advanceSearchPages.advanceSearchClick();
       BasePage.clearCookies();
        BrowsilUtils.wait(2);
        System.out.println("Is clickked at 'Advance Search' button!");

    }
    @Then("user writes {string} into the Zip Code text box")
    public void user_writes_into_the_Zip_Code_text_box(String zipcode) {
        advanceSearchPages.zipCodeEnter(zipcode);
        System.out.println("30004 is written in the zipCode box");

    }

    @Then("user selects {string} check box under {string}")
    public void user_selects_check_box_under(String string, String string2) {
        advanceSearchPages.verifyClickCertifiedAndConvertible(string);
        BrowsilUtils.wait(2);
        System.out.println("Certified is clicked");
        System.out.println("Convertible is clicked");


    }

    @Then("user update year {string} to {string}")
    public void user_update_year_to(String year1, String year2) {
        advanceSearchPages.selectYearFromTo(year1, year2);
        System.out.println("Model year is selected from 2017 to 2020");

    }

    @Then("user selects {string} from Make, Model&Trim")
    public void user_selects_from_Make_Model_Trim(String model) {
        advanceSearchPages.selectVehicle1(model);
        BasePage.clearCookies();
        System.out.println("Bmw is selected");

    }

    @Then("user clicks {string} button")
    public void user_clicks_button(String string) {
        advanceSearchPages.verifyClickSearchButton();
        System.out.println("Search is submitted");

    }

    @Then("user verifies that he is on the result page")
    public void user_verifies_that_he_is_on_the_result_page() {
       advanceSearchPages.verifyUsersInPage();
    }

    @Then("user verifies only {string} cars in the result page")
    public void user_verifies_only_cars_in_the_result_page(String string) {
        advanceSearchPages.verifyNumberOfBMW();

    }

    @Then("writes the total number of cars in the result page")
    public void writes_the_total_number_of_cars_in_the_result_page() {

    }

    @Given("choose make as {string}")
    public void choose_make_as(String string) {

    }

}
