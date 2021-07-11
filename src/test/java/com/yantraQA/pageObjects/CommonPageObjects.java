package com.yantraQA.pageObjects;

import com.google.inject.Inject;
import com.yantraQA.core.Interact;
import com.yantraQA.core.TestContext;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.*;

@Log4j2
public class CommonPageObjects extends Interact {

    By linkMyCart = By.id("nav-cart");
    By linkAccountList = By.id("nav-link-accountList");
    By searchTextBox = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");
    By linkAmazonPay = By.linkText("Amazon Pay");

    @Inject
    public CommonPageObjects(TestContext context){
        super.context = context;
    }

    public void searchForProduct(String text){
        setElement(searchTextBox,text);
        clickElement(searchButton);
        context.getScenario().log("product Searched: " + text);
    }

    public void clickOnReturnsAndOrders(){
        clickElement(linkAccountList);
        context.getScenario().log("Clicked on ReturnsAndOrders");
        log.debug("Clicked on ReturnsAndOrders");
    }

    public void clickOnAmazonPayLink(){
        clickElement(linkAmazonPay);
        context.getScenario().log("Clicked on linkAmazonPay");
        log.debug("Clicked on linkAmazonPay");
    }

    public void clickOnCartNavLink(){
        clickElement(linkMyCart);
        context.getScenario().log("Clicked on linkMyCart");
        log.debug("Clicked on linkMyCart");
    }


    public void validatePageTitleToCheckPageIsNavigated(String titleText){
        assertThat(getTitle()).as("Page Title Contains").contains(titleText);
        log.debug("Validated page title as : " + titleText);
    }

}
