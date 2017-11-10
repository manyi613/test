package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageShortcutMenu {

	WebDriver driver;
	// 快速新建
	@FindBy(xpath = "//*[@id=\"p2p_layout_menu_xj\"]/a/span")
	@CacheLookup
	WebElement quickNewEle;

	// 快速新建-采购申请
	@FindBy(xpath = "//*[@id=\"p2p_layout_menu_xj\"]/ul/li[1]/a")
	@CacheLookup
	WebElement quickNewSourcingEle;

	// 待审批
	@FindBy(xpath = "//*[@id=\"p2p_layout_menu_dsp\"]/a/span")
	@CacheLookup
	WebElement approvingEle;
	String dsp = "p2p_layout_menu_dsp";
	// 待审批-采购申请
	@FindBy(xpath = "//*[@id=\"p2p_layout_menu_dsp\"]/ul/li[1]/a")
	@CacheLookup
	WebElement approvingSourcingEle;

	// 已审批
	@FindBy(xpath = "//*[@id=\"p2p_layout_menu_ysp\"]/a/span")
	@CacheLookup
	WebElement approvedEle;

	// 下一步
	@FindBy(xpath = "//*[@id=\"create-nondirectory-apply-steps\"]/div[3]/ul/li[2]/a")
	@CacheLookup
	WebElement nextBtnEle;

	public void PageShortcutMenu(WebDriver driver) {

		this.driver = driver;
		// PageFactory.initElements(driver,this);
	}

	public void creatSourcingApple() {
		quickNewEle.click();
		quickNewSourcingEle.click();
	}
	
	public void approvingSourcing() throws InterruptedException {
		Thread.sleep(2000);
		approvingEle.click();
//		driver.findElement(By.id("p2p_layout_menu_xj")).click();
		approvingSourcingEle.click();
	}
}
