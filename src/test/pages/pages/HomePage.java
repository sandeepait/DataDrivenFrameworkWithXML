package pages;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@CacheLookup
	@FindBy(xpath="//div[@class='moe-button-wrapper']/button[1]")
	WebElement btn_dontAllow;
	
	@CacheLookup
	@FindBy(xpath="//a[text()='Home & Kitchen']")
	WebElement	link_homeAndKitchen;
	
	@CacheLookup
	@FindBy(xpath="//ul[@class='list_blocks']//a[text()='Curtains']")
	WebElement link_curtains;
	
	public void clickDontAllow() {
		btn_dontAllow.click();
		System.out.println("*****Clicked on don't Allow *****");
	}
	
	public void hoverOverTheProductCategory(String productCategory) {
		String xPathForProductCategory="//a[text()='productCategory']";
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(xPathForProductCategory.replace("productCategory", productCategory)))).build().perform();
		System.out.println("*****Mouse moved over to "+productCategory+"*****");

	}
	
	public void clickOnTheProductLink(String product) {
		String xpathForProduct="//ul[@class='list_blocks']//a[text()='product']";
		driver.findElement(By.xpath(xpathForProduct.replace("product", product))).click();
		System.out.println("*****Clicked on "+product+"*****");
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String window:allWindows) {
			
			if(!window.equalsIgnoreCase(mainWindow)) {
				driver.switchTo().window(window);
			}
		}
	}

}
