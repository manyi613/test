package nondirectorysourcing;

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

import login.PageLogin;
import utils.PageShortcutMenu;

import org.testng.Assert;


/*
 * 测试审批采购申请
 * 
 */
public class TestApprovingSourcingApply {

	private static ChromeDriver driver;
	private static String chromedriverPath = "D:\\tools\\chromedriver.exe";
	private static String username = "1239263709@qq.com";
	private static String password = "manyi123";
	private static String URL = "http://testbuyer.zhichubao.com/";
	static String applyCode = null;
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

	@Test(priority = 0)
	public static void TestLogin() throws Exception {

		driver.get(URL);
		PageLogin homePage = PageFactory.initElements(driver, PageLogin.class);
		
		homePage.inputUserName(username);
		homePage.inputPassWord(password);
		homePage.clickLoginButton();
		System.out.println("执行登录测试。");
		Assert.assertEquals(driver.getTitle(), "支出宝-为节约而生");
	}

	@Test(priority = 1)
	public void TestApprovingSourcingApply() throws Exception {
//		driver.get(URL);
		PageShortcutMenu shortcutMenu = PageFactory.initElements(driver, PageShortcutMenu.class);
		shortcutMenu.PageShortcutMenu(driver);
		shortcutMenu.approvingSourcing();
		
		PageApprovingSourcing approvingSourcing = PageFactory.initElements(driver, PageApprovingSourcing.class);
		approvingSourcing.PageApprovingSourcing(driver);
		applyCode = TestCreateNonDirectorySourcing.ApplyCode;
//		applyCode = "PR2017110710361867";
		approvingSourcing.searchApply(applyCode);//提交采购申请回传的申请编号
		approvingSourcing.clickApprovedButton();
		System.out.println("采购申请" + applyCode + "审批通过。");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}