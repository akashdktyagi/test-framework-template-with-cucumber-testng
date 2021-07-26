package com.yantraQA.core;

import com.google.common.base.Preconditions;
import com.yantraQA.config.CoreConfig;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

@Log4j2
public class Interact {

	protected TestContext context;
	private long timeOutInSeconds;
	CoreConfig config = ConfigFactory.create(CoreConfig.class);

	public Interact(){
		timeOutInSeconds = config.browserExplicitWaitTimeOut();
	}

	public void clickElement(WebElement webElement) {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(webElement,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(context.getDriver(), timeOutInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();
		log.debug("Element is clicked. Element Description: " + webElement.toString());

	}

	public void clickElement(By by) {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(context.getDriver(), timeOutInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.click();
		log.debug("Element is clicked. Element Description: " + element.toString());
	}
	
	public WebElement setElement(By by, String text) {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(context.getDriver(), timeOutInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(text);
		log.debug("Element is Set with text as: " + text + ". Element Description: " + by.toString());
		return element;
	}
	
	public String getAttribute(By by, String attName) {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(context.getDriver(), timeOutInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		String value = element.getAttribute(attName);
		log.debug("Get Attribute for element: " + by.toString() + " Attribute name: " + attName);
		return value;
	}
	
	public String getText(By by) {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(context.getDriver(), timeOutInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		String value = element.getText();
		log.debug("Get Text for element: " + by.toString() + " Text : " + value);
		return value;
	}

	public String getTitle() {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		String value = context.getDriver().getTitle();
		log.debug("Title fetched: " + value);
		return value;
	}
	
	public List<WebElement> getListOfWebElements(By by){
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(context.getDriver(), timeOutInSeconds);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		log.debug("List of Elements returned for description: " + by.toString());
		return element.findElements(by);
	}
	
	public boolean validateElementIsDisplayed(By by) {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		boolean b = context.getDriver().findElement(by).isDisplayed();
		log.debug("Element is Displayed status: " + by.toString());
		return b;
	}
	
	public void switchToSecondWindowTab() {
		String [] handles = (String[]) context.getDriver().getWindowHandles().toArray();
		context.getDriver().switchTo().window(handles[1]);
		log.debug("Browser Switched to second window tab.");
	}
	
	public void switchToDefaultWindowTab() {
		String [] handles = (String[]) context.getDriver().getWindowHandles().toArray();
		context.getDriver().switchTo().window(handles[0]);
		log.debug("Browser Switched to parent window tab.");
	}
	
	public byte[] takeScreenShot() {

		TakesScreenshot shot = (TakesScreenshot)context.getDriver();
		log.debug("Screen Shot taken for full context.getDriver(). ");
		return shot.getScreenshotAs(OutputType.BYTES);
	}
	
	public byte[] takeScreenShot(By by) {
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		TakesScreenshot shot = (TakesScreenshot)context.getDriver().findElement(by);
		log.debug("Screen Shot taken for element: " + by.toString() );
		return shot.getScreenshotAs(OutputType.BYTES);
	}
	
	public File takeScreenShotAsFile() {
		TakesScreenshot shot = (TakesScreenshot)context.getDriver();
		log.debug("Screen Shot taken for full context.getDriver() and returned as a file.");
		return shot.getScreenshotAs(OutputType.FILE);
	}
	
	public File takeScreenShotAsFile(By by) {
		TakesScreenshot shot = (TakesScreenshot)context.getDriver().findElement(by);
		log.debug("Screen Shot taken for element and returned as a file. By descp: " + by.toString());
		return shot.getScreenshotAs(OutputType.FILE);
	}

}