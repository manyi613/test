package nondirectorysourcing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSourcing2 {

	WebDriver driver;
	// 添加行信息
	@FindBy(css = ".btn_my.back_baba.btn_create_detail")
	@CacheLookup
	WebElement creatDetailEle;
	// 下一步
//	@FindBy(id = "next_qa")
//	@CacheLookup
//	WebElement nextBtnEle;
	
	// 商品名称
	@FindBy(name = "goodName")
	@CacheLookup
	WebElement goodNameEle;

	// 采购类别一级
	// @FindBy(id = "s2id_oneLayerTypeList")
	// @CacheLookup
	// WebElement categoryLevel1Ele;
	// // 采购类别一级选择第一个结果
	// @FindBy(xpath = "//div[@id=\"select2-drop\"]/ul/li[2]")
	// // @CacheLookup
	// WebElement categoryLevel1SelectResultEle;

	// 所有下拉菜单都选择第一个结果
	String firstOption = "//div[@id=\"select2-drop\"]/ul/li[2]";
	WebElement selectResultEle = null;

	String categoryLevel1Ele = "s2id_oneLayerTypeList";
	String categoryLevel2Ele = "s2id_twoLayerTypeList";
	String supplierEle = "s2id_vendorList";
	String costCenterEle = "s2id_costCenterList";
	String financeAccountEle = "s2id_financialAccountList";
	String nextBtnEle = "next_qa";

	// test
	// @FindBy(id = "s2id_vendorList")
	// @CacheLookup
	// WebElement vendor;

	// 采购类别二级
	// @FindBy(id = "s2id_twoLayerTypeList")
	// @CacheLookup
	// WebElement categoryLevel2Ele;

	// 采购类别二级选择第一个结果
	// @FindBy(xpath = "//*[@id=\"select2-results-484\"]/li[2]")
	// @CacheLookup
	// WebElement categoryLevel2SelectResultEle;

	// 商品编码
	@FindBy(name = "goodCode")
	@CacheLookup
	WebElement goodCodeEle;

	// 供应商
	// @FindBy(id = "s2id_vendorList")
	// // @CacheLookup
	// WebElement supplierEle;

	// 供应商选择第一个结果
	// @FindBy(xpath = "//*[@id=\"select2-results-134\"]/li[2]")
	// @CacheLookup
	// WebElement supplierSelectResultEle;

	// 单价
	@FindBy(id = "goodPrice")
	@CacheLookup
	WebElement goodPriceEle;

	// 数量
	@FindBy(id = "goodQuantity")
	@CacheLookup
	WebElement goodQuantityEle;

	// 数量
	@FindBy(name = "remark")
	@CacheLookup
	WebElement remarkEle;

	// 预算对象-成本中心
	// @FindBy(id = "s2id_costCenterList")
	// @CacheLookup
	// WebElement costCenterEle;

	// 成本中心选择第一个结果
	// @FindBy(xpath = "//*[@id=\"select2-results-138\"]/li[2]")
	// @CacheLookup
	// WebElement costCenterSelectResultEle;

	// 财务科目
	// @FindBy(id = "s2id_financialAccountList")
	// @CacheLookup
	// WebElement financeAccountEle;

	// 财务科目选择第一个结果
	// @FindBy(xpath = "//*[@id=\"select2-results-692\"]/li[2]")
	// @CacheLookup
	// WebElement financeAccountSelectResultEle;

	// 保存
	@FindBy(id = "saveDetail")
	@CacheLookup
	WebElement saveEle;

	public void SourcingPage(WebDriver driver) {

		this.driver = driver;
		// PageFactory.initElements(driver,this);
	}

	public void inputGoodName(String text) {
		goodNameEle.sendKeys(text);
	}

	public void inputRemark(String text) {
		remarkEle.sendKeys(text);
	}

	public void selectFirstOption() throws InterruptedException {

		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath(firstOption)).click();
			Thread.sleep(1000);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			driver.findElement(By.xpath(firstOption)).click();
			Thread.sleep(1000);
		}
	}

	public void selectElement(String id) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id(id)).click();
		Thread.sleep(1000);
	}

	public void selectCategory1() throws InterruptedException {

		try {
			selectElement(categoryLevel1Ele);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			selectElement(categoryLevel1Ele);
		}
		selectFirstOption();

	}
	
	public void selectCategory2() throws InterruptedException {

		try {
			selectElement(categoryLevel2Ele);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			selectElement(categoryLevel2Ele);
		}
		selectFirstOption();
	}

	public void inputGoodCode(String text) {
		goodCodeEle.sendKeys(text);
	}

	public void inputGoodPrice(String text) {
		goodPriceEle.sendKeys(text);
	}

	public void inputGoodQuantity(String text) {
		goodQuantityEle.sendKeys(text);
	}

	public void selectSupplier() throws InterruptedException {
		selectElement(supplierEle);
		selectFirstOption();
	}

	public void selectCostCenter() throws InterruptedException {
		selectElement(costCenterEle);
		selectFirstOption();
	}

	public void selectfinanceAccount() throws InterruptedException {
		selectElement(financeAccountEle);
		selectFirstOption();
	}

	public void clickCreatDetailButton() {
		creatDetailEle.click();
	}

	public void clickSaveButton() throws InterruptedException {
		Thread.sleep(1000);
		saveEle.click();
	}
	
	
	public void clickNextButton() throws InterruptedException {
		Thread.sleep(3000);
		selectElement(nextBtnEle);
	}
}
