package com.yantraQA.stepdefs;

import com.google.inject.Inject;
import com.yantraQA.core.TestContext;
import com.yantraQA.pageObjects.CommonPageObjects;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefs {

    @Inject
    TestContext context;

    @Inject
    CommonPageObjects commonPageObjects;

    @Given("I Open the Browser")
    public void i_open_the_browser() {
        context.invokeDriver();
    }

    @And("I Navigate to the URL")
    public void i_navigate_to_the_url() throws InterruptedException {
        context.navigateBrowser(context.getCoreConfig().browserAppURL());
    }

    @When("I search for a product")
    public void i_search_for_a_product() {
        commonPageObjects.searchForProduct("Apple");
    }
    @Then("Search result is displayed")
    public void search_result_is_displayed() {
        commonPageObjects.validatePageTitleToCheckPageIsNavigated("Apple");
    }

    @When("I click on returns and orders link")
    public void i_click_on_returns_and_orders_link() {
        commonPageObjects.clickOnReturnsAndOrders();
    }

    @Then("Sign page is Displayed")
    public void sign_page_is_displayed() {
        commonPageObjects.validatePageTitleToCheckPageIsNavigated("Amazon Sign In");
    }

    @When("I click on amazon pay link")
    public void i_click_on_amazon_pay_link() {
        commonPageObjects.clickOnAmazonPayLink();
    }

    @When("I click on Cart link")
    public void i_click_on_cart_link() {
        commonPageObjects.clickOnCartNavLink();
    }

    @Then("Cart page is displayed")
    public void cart_page_is_displayed() {
        commonPageObjects.validatePageTitleToCheckPageIsNavigated("Amazon.in Shopping Cart");
    }

    @Then("Amazon Pay Page is Displayed")
    public void amazon_pay_page_is_displayed() {
        commonPageObjects.validatePageTitleToCheckPageIsNavigated("Amazon Pay");
    }

}
