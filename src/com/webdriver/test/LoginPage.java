package com.webdriver.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "username")
	@CacheLookup
	WebElement userNameEle;

	@FindBy(id = "password")
	@CacheLookup
	WebElement passWordEle;

	@FindBy(id = "buyerBtn")
	@CacheLookup
	WebElement buyerBtnEle;
	
	@FindBy(id = "supplierBtn")
	@CacheLookup
	WebElement supplierBtnEle;
	
	@FindBy(id = "loginBtn")
	@CacheLookup
	WebElement loginBtnEle;
	
	
	public void LoginPage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void inputUserName(String text){
		userNameEle.sendKeys(text);
	}
	
	public void inputPassWord(String text){
		passWordEle.sendKeys(text);
	}
	
	public void selectRole(String text){
		if(text.equals("我是供应商")) {
			supplierBtnEle.click();
		}
	}

	public void clickLoginButton(){
		loginBtnEle.click();
	}

}
