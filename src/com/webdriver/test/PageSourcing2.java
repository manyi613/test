package com.webdriver.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSourcing2 {

	WebDriver driver;
	//添加行信息
	@FindBy(css = ".btn_my.back_baba.btn_create_detail")
	@CacheLookup
	WebElement creatDetailEle;
	//下一步
	@FindBy(xpath = "//*[@id=\"create-nondirectory-apply-steps\"]/div[3]/ul/li[3]/a")
	@CacheLookup
	WebElement nextBtnEleEle;
	
	//商品名称
	@FindBy(name = "goodName")
	@CacheLookup
	WebElement goodNameEle;
	
	//采购类别一级
	@FindBy(xpath = "//*[@id=\"applyDetailForm\"]/div[2]/div/div/div/div/div/a/span")
	@CacheLookup
	WebElement categoryLevel1Ele;
	//采购类别一级选择第一个结果
	@FindBy(xpath = "//div[@id=\"select2-drop\"]/ul/li[2]/div")
	@CacheLookup
	WebElement categoryLevel1SelectResultEle;
	//test
	@FindBy(xpath = "//select[@id=\"oneLayerTypeList\"]/option[2]")
	@CacheLookup
	WebElement test;	
	

	//采购类别二级
	@FindBy(id = "select2-chosen-484")
	@CacheLookup
	WebElement categoryLevel2Ele;
	
	//采购类别二级选择第一个结果
	@FindBy(xpath = "//*[@id=\"select2-results-484\"]/li[2]")
	@CacheLookup
	WebElement categoryLevel2SelectResultEle;
	
	//商品编码
	@FindBy(name = "goodCode")
	@CacheLookup
	WebElement goodCodeEle;
	
	//供应商
	@FindBy(id = "select2-chosen-134")
	@CacheLookup
	WebElement supplierEle;
	
	//供应商选择第一个结果
	@FindBy(xpath = "//*[@id=\"select2-results-134\"]/li[2]")
	@CacheLookup
	WebElement supplierSelectResultEle;
	
	//单价
	@FindBy(id = "goodPrice")
	@CacheLookup
	WebElement goodPriceEle;
	
	//数量
	@FindBy(xpath = "goodQuantity")
	@CacheLookup
	WebElement goodQuantityEle;
	
	//预算对象-成本中心
	@FindBy(id = "select2-chosen-138")
	@CacheLookup
	WebElement costCenterEle;
	
	//成本中心选择第一个结果
	@FindBy(xpath = "//*[@id=\"select2-results-138\"]/li[2]")
	@CacheLookup
	WebElement costCenterSelectResultEle;
	
	//财务科目
	@FindBy(id = "select2-chosen-692")
	@CacheLookup
	WebElement financeAccountEle;
	
	//财务科目选择第一个结果
	@FindBy(xpath = "//*[@id=\"select2-results-692\"]/li[2]")
	@CacheLookup
	WebElement financeAccountSelectResultEle;
	
	//保存
	@FindBy(id = "saveDetail")
	@CacheLookup
	WebElement saveEle;
	
	public void SourcingPage(WebDriver driver){

		this.driver = driver;
//		PageFactory.initElements(driver,this);
	}

	public void inputGoodName(String text){
		goodNameEle.sendKeys(text);
	}
	
	public void selectCategory(){
//		test.click();
//		System.out.println(test.isSelected());
//		System.out.println(test.getAttribute("value"));
		categoryLevel1Ele.click();
//		categoryLevel1SelectResultEle.click();
//		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//		categoryLevel2Ele.click();
//		categoryLevel2SelectResultEle.click();
	}
	
	public void inputGoodCode(String text){
		goodCodeEle.sendKeys(text);
	}
	
	
	public void inputGoodPrice(String text){
		goodPriceEle.sendKeys(text);
	}
	
	public void inputGoodQuantity(String text){
		goodQuantityEle.sendKeys(text);
	}
	
	public void selectSupplier(){
		supplierEle.click();
		supplierSelectResultEle.click();
	}
	
	public void selectCostCenter(){
		costCenterEle.click();
		costCenterSelectResultEle.click();
	}
	
	public void selectfinanceAccount(){
		financeAccountEle.click();
		financeAccountSelectResultEle.click();
	}
	
	public void clickCreatDetailButton(){
		creatDetailEle.click();
	}
	public void clickSaveButton(){
		saveEle.click();
	}
}
