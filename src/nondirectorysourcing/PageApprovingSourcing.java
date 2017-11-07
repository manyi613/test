package nondirectorysourcing;

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
	@FindBy(xpath = "//*[@id=\"data\"]/div/div[2]/table/tbody/tr/td[9]/button[2]")
	@CacheLookup
	WebElement approvedBtnEle;
	
	//拒绝按钮
	@FindBy(xpath = "//*[@id=\"checkbox\"]/div[1]/div[2]/table/tbody/tr/td[9]/button[2]")
	@CacheLookup
	WebElement rejectedBtnEle;
	
	//点击批准按钮后弹框的“确定”
	String apply = "//*[@class='layui-layer layui-layer-dialog  layer-anim']/div[3]/a[1]";
	
	public void PageApprovingSourcing(WebDriver driver){

		this.driver = driver;
//		PageFactory.initElements(driver,this);
		driver.findElement(By.id("")).click();
	}

	public void searchApply(String text){
		if(!text.equals(null)) {
			searchKeyEle.sendKeys(text);
			searchBtnEle.click();
		}
		
	}
	
	

	public void clickApprovedButton() throws InterruptedException{
		Thread.sleep(2000);
		approvedBtnEle.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(apply)).click();
		Thread.sleep(2000);
	}

}
