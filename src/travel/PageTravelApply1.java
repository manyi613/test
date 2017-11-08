package travel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



/*
 * 差旅申请页面
 * 
 * 
 */


public class PageTravelApply1 {

	WebDriver driver;

	//差旅菜单
	@FindBy(xpath = "//*[@id=\"navbar-demo-mobile\"]/ul/li[6]/a")
	@CacheLookup
	WebElement traveMenuEle;
	
	//新建差旅申请
	@FindBy(xpath = "//*[@id=\"navTab\"]/div[3]/div/a")
	@CacheLookup
	WebElement createtraveApplyEle;
	
	//差旅申请名称
	@FindBy(name = "applyName")
	@CacheLookup
	WebElement applyNameEle;
	
	//差旅申请机票火车票“添加”按钮
	@FindBy(id = "btn_add_route")
	@CacheLookup
	WebElement addRouteBtnEle;
	
	//差旅申请酒店“添加”按钮
	@FindBy(id = "btn_add_hotel")
	@CacheLookup
	WebElement addHotelBtnEle;	
	
	//差旅申请第一页的“下一步”按钮
	@FindBy(id = "btn_next")
	@CacheLookup
	WebElement nextBtnEle;
	
	
	//您未填写酒店信息，请确认本次出差无需预定酒店吗？确定
	@FindBy(xpath = "//a[@class=\"layui-layer-btn0\"]")
	@CacheLookup
	WebElement sureEle;	
	
	//提交按钮
	@FindBy(id = "btn_submit")
	@CacheLookup
	WebElement submitEle;	
	
	public void PageTravelApply1(WebDriver driver){

		this.driver = driver;
//		PageFactory.initElements(driver,this);
	}

	public void createTravelApply() throws InterruptedException{
		createtraveApplyEle.click();
		Thread.sleep(2000);
	}
	
	public void inputApplyName(String text){
		applyNameEle.sendKeys("差旅申请" + text);
	}
	
	public void clickAddHotelButton() throws InterruptedException{
		Thread.sleep(2000);
		addHotelBtnEle.click();
		Thread.sleep(2000);
	}
	
	public void clickAddRouteButton() throws InterruptedException{
		Thread.sleep(2000);
		addRouteBtnEle.click();
		Thread.sleep(2000);
	}

	public void clickTraveMenu() throws InterruptedException{
		Thread.sleep(2000);
		traveMenuEle.click();
		Thread.sleep(2000);
	}
	
	public void clickNextButton() throws InterruptedException{
		Thread.sleep(2000);
		nextBtnEle.click();
		Thread.sleep(2000);
	}

	public void clickSureButton() throws InterruptedException{
		Thread.sleep(1000);
		sureEle.click();
		Thread.sleep(1000);
	}
	
	public void submitApply() throws InterruptedException{
		Thread.sleep(2000);
		submitEle.click();
		Thread.sleep(1000);
	}
	
}
