package travel;

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
import nondirectorysourcing.PageSourcing2;
import utils.BaseTools;
import utils.PageShortcutMenu;
import utils.PageSubmitSuccess;

import org.testng.Assert;


/*
 * 测试审批采购申请
 * 
 */
public class TestTravelApply {

	private static ChromeDriver driver;
	private static String chromedriverPath = "D:\\tools\\chromedriver.exe";
	private static String username = "1239263709@qq.com";
	private static String password = "manyi123";
	private static String URL = "http://testbuyer.zhichubao.com/";
	static String ApplyCode = null;
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
	public void TestTravelApply() throws Exception {
		
		PageTravelApply1 travelApply1 = PageFactory.initElements(driver, PageTravelApply1.class);
		travelApply1.PageTravelApply1(driver);
		
		
		
		travelApply1.clickTraveMenu();
		travelApply1.createTravelApply();
		travelApply1.inputApplyName(BaseTools.getDate());
		
		travelApply1.clickAddRouteButton();
		
		PageTravelApply2 travelApply2 = PageFactory.initElements(driver, PageTravelApply2.class);
		travelApply2.PageTravelApply2(driver);
		
		travelApply2.selectTravelType("火车");
		travelApply2.inputTime();
		
		travelApply2.selectTravelFromCity();
		travelApply2.selectTravelToCity();
		
		travelApply2.clickRouteOKButton();
		travelApply1.clickNextButton();
		
		travelApply1.clickSureButton();
		travelApply1.submitApply();
		
		PageSubmitSuccess submitSuccess = PageFactory.initElements(driver, PageSubmitSuccess.class);
		submitSuccess.PageSubmitSuccess(driver);
		ApplyCode = submitSuccess.getApplyCode();
		
		System.out.println("差旅申请" + ApplyCode + "申请通过。");
	}

	@AfterTest
	public void tearDown() {
//		driver.quit();
	}

}