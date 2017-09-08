package com.webdriver.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSourcing1 {

	WebDriver driver;
	//申请名称
	@FindBy(name = "apply.applyName")
	@CacheLookup
	WebElement applyNameEle;
	
	//期望交付时间
	@FindBy(name = "apply.expectedDeliveryTime")
	@CacheLookup
	WebElement expectedDeliveryTimeEle;
	
	//定位frame
	@FindBy(xpath = "//*[@id=\"myframe\"]")
	@CacheLookup
	WebElement expectedDeliveryTimeframeEle;
	
	//今天
	@FindBy(id = "dpTodayInput")
	@CacheLookup
	WebElement todayEle;
	
	//下一步
	@FindBy(xpath = "//*[@id=\"create-nondirectory-apply-steps\"]/div[3]/ul/li[2]/a")
	@CacheLookup
	WebElement nextBtnEle;
	
	
	
	public void SourcingPage(WebDriver driver){

		this.driver = driver;
//		PageFactory.initElements(driver,this);
	}

	public void inputApplyName(String text){
		applyNameEle.sendKeys(text);
	}
	
	public void inputExpectedDeliveryTime(){
		expectedDeliveryTimeEle.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.switchTo().frame(expectedDeliveryTimeframeEle);
		todayEle.click();
		driver.switchTo().defaultContent();
	}

	public void clickNextButton(){
		nextBtnEle.click();
	}

}
