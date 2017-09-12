package com.webdriver.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageApprovingSourcing {

	WebDriver driver;
	//搜索框
	@FindBy(name = "searchKey")
	@CacheLookup
	WebElement searchKeyEle;
	
	//搜索按钮
	@FindBy(css = ".searchBtn.btn_my.back_baba")
	@CacheLookup
	WebElement searchBtnEle;
	
	//批准按钮
	@FindBy(xpath = "//*[@id=\"checkbox\"]/div[1]/div[2]/table/tbody/tr/td[9]/button")
	@CacheLookup
	WebElement approvedBtnEle;
	
	//拒绝按钮
	@FindBy(xpath = "//*[@id=\"checkbox\"]/div[1]/div[2]/table/tbody/tr/td[9]/button[2]")
	@CacheLookup
	WebElement rejectedBtnEle;
	
	String apply = "//*[@class='layui-layer layui-layer-dialog  layer-anim']/div[3]/a[1]";
	
	public void PageApprovingSourcing(WebDriver driver){

		this.driver = driver;
//		PageFactory.initElements(driver,this);
	}

	public void searchApply(String text){
		searchKeyEle.sendKeys(text);
		searchBtnEle.click();
	}
	
	

	public void clickApprovedButton() throws InterruptedException{
		Thread.sleep(2000);
		approvedBtnEle.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(apply)).click();
		Thread.sleep(2000);
	}

}
