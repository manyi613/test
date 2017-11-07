package nondirectorysourcing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSourcing3 {

	WebDriver driver;
	String applyCode = null;
	// 提交审批
//	@FindBy(xpath = "//*[@id=\"create-nondirectory-apply-steps\"]/div[3]/ul/li[3]/a")
//	@CacheLookup
//	WebElement commitEle;
	@FindBy(id = "finish_qa")
	@CacheLookup
	WebElement commitEle;
	
	String applyCodeXPATH = "//*[@id=\"loginform\"]/div[3]/div/div[2]/div/div/div/div/div/h5/a/strong";
	
	public void SourcingPage(WebDriver driver) {

		this.driver = driver;
		// PageFactory.initElements(driver,this);
	}
	public void clickCommitButton() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		commitEle.click();
	}
	
	public String getApplyCode() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement ac = driver.findElement(By.xpath(applyCodeXPATH));
		return ac.getText();
	}
}
