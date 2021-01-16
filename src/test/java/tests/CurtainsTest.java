package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonPackage.BaseClass;
import pages.CurtainsPage;
import pages.HomePage;

public class CurtainsTest extends BaseClass{
	HomePage hm;
	CurtainsPage cp;
	
	@Parameters({"productCategory","product"})
	@Test
	public void curtainTest(String productCategory, String product) {
		hm = new HomePage(BaseClass.driver);
		hm.clickDontAllow();
		hm.hoverOverTheProductCategory(productCategory);
		hm.clickOnTheProductLink(product);
		cp=new CurtainsPage(BaseClass.driver);
		cp.clickOnfirstProduct();
		cp.switchToBuyTab();
		cp.waitForInvisibilityOfPriceMessage();
		cp.clickOnAddToCart();
		cp.verifProductAddedMsg();
		
	}

}
