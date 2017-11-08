package travel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/*
 * 差旅申请编辑机票酒店信息页面
 * 
 * 
 */


public class PageTravelApply2 {

	WebDriver driver;

	
	
	//行程信息日期
	@FindBy(id = "rout_date")
	@CacheLookup
	WebElement addRouteBtnEle;
	
	
	//定位frame
	@FindBy(xpath = "//*[@id=\"myframe\"]")
	@CacheLookup
	WebElement timeframeEle;
	
	//今天
	@FindBy(id = "dpTodayInput")
	@CacheLookup
	WebElement todayEle;
	
	//交通方式
	@FindBy(id = "s2id_ddl_travelType")
	@CacheLookup
	WebElement travelTypeEle;
	
	
	//飞机
	@FindBy(xpath = "//*[@id=\"select2-results-3\"]/li[2]")
	@CacheLookup
	WebElement ByPlaneEle;
	
	//火车
	@FindBy(xpath = "//*[@id=\"select2-results-3\"]/li[3]")
	@CacheLookup
	WebElement ByTrainEle;
	
	//选择出发城市
	@FindBy(id = "txt_travelFrom")
	@CacheLookup
	WebElement travelFromEle;
	
	
	//选择出发城市-北京
	@FindBy(xpath = "//*[@id=\"mode-route\"]/div[2]/div/div/div[1]/dl/dd/span[1]")
	@CacheLookup
	WebElement travelFromBJEle;
	
	
	//选择到达城市
	@FindBy(id = "txt_travelTo")
	@CacheLookup
	WebElement travelToEle;
	
	//选择到达城市-上海
	@FindBy(xpath = "//*[@id=\"mode-route\"]/div[2]/div/div/div[1]/dl/dd/span[2]")
	@CacheLookup
	WebElement travelToSHEle;
	
	//行程确定按钮
	@FindBy(id = "btn_ok_route")
	@CacheLookup
	WebElement routeOKEle;
	
	//酒店确定按钮
	@FindBy(id = "btn_ok_hotel")
	@CacheLookup
	WebElement hotelOKEle;
	
	public void PageTravelApply2(WebDriver driver){

		this.driver = driver;
//		PageFactory.initElements(driver,this);
	}
	public void selectTravelType(String type) throws InterruptedException{
		Thread.sleep(1000);
		travelTypeEle.click();
		Thread.sleep(1000);
		if(type.equals("飞机")) {
			Thread.sleep(1000);
			ByPlaneEle.click();
		}
		else {
			Thread.sleep(1000);
			ByTrainEle.click();
		}
	}

	public void selectTravelFromCity() throws InterruptedException{
		Thread.sleep(1000);
		travelFromEle.click();
		Thread.sleep(1000);
		travelFromBJEle.click();
	}
	
	public void selectTravelToCity() throws InterruptedException{
		Thread.sleep(1000);
		travelToEle.click();
		Thread.sleep(1000);
		travelToSHEle.click();
	}

	public void inputTime(){
		addRouteBtnEle.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.switchTo().frame(timeframeEle);
		todayEle.click();
		driver.switchTo().defaultContent();
	}
	
	public void clickRouteOKButton(){
		routeOKEle.click();
	}
	
	public void clickHotelOKButton(){
		hotelOKEle.click();
	}
	
}
