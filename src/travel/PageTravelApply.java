package travel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



/*
 * 待审批页面批准采购申请
 * 
 * 
 */


public class PageTravelApply {

	WebDriver driver;

	//差旅菜单
	@FindBy(xpath = "//*[@id=\"navbar-demo-mobile\"]/ul/li[6]/a")
	@CacheLookup
	WebElement traveMenuEle;
	//
	
	//新建差旅申请
	@FindBy(xpath = "//*[@id=\"navTab\"]/div[3]/div/a")
	@CacheLookup
	WebElement createtraveApplyEle;
	
	public void PageTravelApply(WebDriver driver){

		this.driver = driver;
//		PageFactory.initElements(driver,this);
	}

	public void createTravelApply() throws InterruptedException{
		createtraveApplyEle.click();
		Thread.sleep(2000);
	}
	
	

	public void clickTraveMenu() throws InterruptedException{
		Thread.sleep(2000);
		traveMenuEle.click();
		Thread.sleep(2000);
	}

}
