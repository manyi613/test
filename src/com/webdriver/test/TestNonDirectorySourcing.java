package com.webdriver.test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.Assert;

public class TestNonDirectorySourcing {

	private static ChromeDriver driver;
	private static String chromedriverPath = "D:\\tools\\chromedriver.exe";
	private static String username = "1239263709@qq.com";
	private static String password = "manyi123";
	private static String URL = "http://testbuyer.zhichubao.com/";

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", chromedriverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("no-sandbox");
		options.addArguments("disable-extensions");
		options.addArguments("no-default-browser-check");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
	}

	@Test
	public static void TestLogin() throws Exception {

		driver.get(URL);
		PageLogin homePage = PageFactory.initElements(driver, PageLogin.class);
		
		homePage.inputUserName(username);
		homePage.inputPassWord(password);
		homePage.clickLoginButton();
		System.out.println("执行登录测试。");
		Assert.assertEquals(driver.getTitle(), "支出宝-为节约而生");
	}

	@Test
	public void TestNewSourcingApply() throws Exception {
//		driver.get(URL);
		PageShortcutMenu shortcutMenuPage = PageFactory.initElements(driver, PageShortcutMenu.class);
		shortcutMenuPage.creatSourcingApple();
		
		PageSourcing1 sourcingPage1 = PageFactory.initElements(driver, PageSourcing1.class);
		sourcingPage1.SourcingPage(driver);
		
		sourcingPage1.inputApplyName(BaseTools.getDate());
		sourcingPage1.inputExpectedDeliveryTime();
		sourcingPage1.clickNextButton();
		
		PageSourcing2 sourcingPage2 = PageFactory.initElements(driver, PageSourcing2.class);
		sourcingPage2.SourcingPage(driver);
		sourcingPage2.clickCreatDetailButton();
		sourcingPage2.inputGoodName("GoodName");
		sourcingPage2.inputGoodCode("GoodCode");
		sourcingPage2.selectCategory();
//		sourcingPage2.selectCostCenter();
//		sourcingPage2.selectfinanceAccount();
//		sourcingPage2.selectSupplier();
//		sourcingPage2.inputGoodPrice("200");
//		sourcingPage2.inputGoodQuantity("100");
		sourcingPage2.clickSaveButton();
	}

	@AfterTest
	public void tearDown() {
//		driver.quit();
	}

}