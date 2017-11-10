package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSubmitSuccess {

	WebDriver driver;
	public static String applyCodeXPATH = "//*[@id=\"loginform\"]/div[3]/div/div[2]/div/div/div/div/div/h5/a/strong";

	public void PageSubmitSuccess(WebDriver driver) {

		this.driver = driver;
		// PageFactory.initElements(driver,this);
	}
	
	public String getApplyCode() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement ac = driver.findElement(By.xpath(applyCodeXPATH));
		return ac.getText();
	}
}
