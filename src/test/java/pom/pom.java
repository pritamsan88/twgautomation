package pom;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class pom {
	
	WebDriver driver;
	
	JavascriptExecutor js;

	protected By searchfield =By.cssSelector("#shopify-section-sections--15757381730348__header > sticky-header > div > nav > div > div.accont_area > ul > li:nth-child(1) > a");
	protected By searchbaritem=By.cssSelector("#shopify-section-sections--15757381730348__header > sticky-header > div > nav > div > div.accont_area > ul > li:nth-child(1) > form > input[type=text]");
	protected By searchioconclickafterproductname= By.id("search");
	protected By sortbyelement=By.id("SortBy");
	protected By productcount=By.id("ProductCountDesktop");
	protected By productgrid=By.xpath("//ul[@role='list']/li");
	protected By innersearch=By.id("Search-In-Template");
	protected By productslist=By.className("predictive-search__list-item");
	protected By productdetails=By.id("product-description");
	protected By tableelements=By.xpath("*//div[contains(@id,'ProductAccordion-collapsible_tab_tbRPwd-template--15757381140524__main')]//table//tr");
	protected By scrollintoviewproduct=By.xpath("//h2[contains(text(),'Shipping')]");
	protected By addtocart=By.xpath("//span[contains(text(),'Add to cart')]");
	protected By scrollintoaddtocartnear=By.className("product__title");
	protected By closecarticon=By.cssSelector("#cart-notification > div.cart-notification__header > button");
	//protected By wishlist=By.cssSelector("#Quantity-Form-template--15757381140524__main > div.qwbtn > button");
	protected By headermenucarticon=By.xpath("//a[@href='/cart']");
	protected By cartpagecontain1=By.xpath("//h2[contains(text(),'Estimated total')]");
	protected By cartpagecontain2=By.className("totals__total-value");
	protected By deletecart=By.id("Remove-1");
	protected By plusproduct=By.cssSelector("#CartItem-1 > td.cart-item__quantity > quantity-popover > div.cart-item__quantity-wrapper.quantity-popover-wrapper > div > quantity-input > button:nth-child(3)");
	
	//protected By headerwishlistmenu=By.xpath("//a[@href='#swym-wishlist']");
	//xpath("//ul[@role='list']/li")
	public pom(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void searchclick()
	{
		driver.findElement(searchfield).click();
	}
	public void searchbaritem(String product)
	{
		driver.findElement(searchbaritem).sendKeys(product);
	}
	public void afterclickproductname()
	{
		driver.findElement(searchioconclickafterproductname).click();
	}
	public void sortfunctionality() throws InterruptedException
	{
		Select dropdown=new Select(driver.findElement(sortbyelement));
		Thread.sleep(5000);
		dropdown.selectByVisibleText("Price, high to low");
		Thread.sleep(5000);
		
	}
	public void productcount()
	{
		String count=driver.findElement(productcount).getText();
		System.out.println(count);
	}
	public void productverify(String pageurl) throws InterruptedException
	{ 
		List<WebElement> allresults=driver.findElements(productgrid);
		
		String expectedpageurl=driver.getCurrentUrl().trim();
		System.out.println(expectedpageurl);
		String actualurl=pageurl.trim();
		System.out.println(actualurl);
		System.out.println(allresults.size());
		js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		Assert.assertEquals(actualurl, expectedpageurl);
		Thread.sleep(2000);
		for(int i=0;i<allresults.size();i++) {
			String actualsearchresult=allresults.get(i).getText();
			System.out.println(actualsearchresult);		
		}
		
		
	/*for(int i=0;i<allresults.size();i++)
		{
			js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(2000);
			String actualsearchresult=allresults.get(i).getText();
			System.out.println(actualsearchresult);
			String expectedsearchresult=product;
			System.out.println(expectedsearchresult);
		  Assert.assertEquals(actualsearchresult, expectedsearchresult);
			
			
		}*/	
	}
	
	public void clearsearchfield() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(innersearch).clear();
	}
	public void autosuggestion(String product,String autosuggesionproduct) throws InterruptedException
	{
		Thread.sleep(2000);
		
		driver.findElement(innersearch).sendKeys(product);
		Thread.sleep(2000);
		List<WebElement>allproducts=driver.findElements(productslist);
		System.out.println(allproducts);
		
		for (WebElement products:allproducts)
		{
			
			System.out.println("Auto Suggestion Value : " + products.getText().trim());
			try{
				if(products.getText().trim().contains(autosuggesionproduct))
			
			{
				Thread.sleep(2000);
				products.click();
				break;
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	}
	
	public void productdetails() throws InterruptedException
	{
		String productdetail=driver.findElement(productdetails).getText();
		System.out.println(productdetail);
		Thread.sleep(2000);
		WebElement ele=driver.findElement(scrollintoviewproduct);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		Thread.sleep(2000);
		ele.click();
		Thread.sleep(2000);
		List<WebElement> tableelements1=driver.findElements(tableelements);
		System.out.println(tableelements1);
		
		boolean dataselect=false;
		for (WebElement tableproductdata:tableelements1)
		{
			String value=tableproductdata.getText();
			System.out.println(value);
			if(value.contains("50 Free"))
			{
				dataselect=true;
				break;
			}
			
		}
		Assert.assertTrue("Records not found",dataselect);
	}
	public void addtocart() throws InterruptedException
	{
		WebElement ele1=driver.findElement(scrollintoaddtocartnear);
		JavascriptExecutor js1=(JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);",ele1);
		Thread.sleep(2000);
		if(driver.findElement(addtocart).isDisplayed())
		{
			
			WebElement ele2=driver.findElement(addtocart);
			JavascriptExecutor js2=(JavascriptExecutor) driver;
			js2.executeScript("arguments[0].click();",ele2);
			
			Thread.sleep(2000);
			
			driver.findElement(closecarticon).click();
		}
		
	}
	/*public void wishlist()
	{
		WebElement ele3=driver.findElement(wishlist);
		JavascriptExecutor js3=(JavascriptExecutor) driver;
		js3.executeScript("arguments[0].scrollIntoView(true);",ele3);
		
		if (driver.findElement(wishlist).isDisplayed())
		{
			ele3.click();
		}
		
		
	}*/
	public void cartsection() throws InterruptedException
	{
		WebElement ele4=driver.findElement(headermenucarticon);
		JavascriptExecutor js4=(JavascriptExecutor) driver;
		js4.executeScript("arguments[0].click();",ele4);
		
		//ele4.click();
		
		Thread.sleep(2000);
	}
	
	public void deletecart() throws InterruptedException
	{
		Thread.sleep(3000);
		if(driver.findElement(deletecart).isDisplayed())
		{
			driver.findElement(deletecart).click();
		}
	}
	
	
	public void cartpagevalidation()
	{
		String pagetitle=driver.getTitle().trim();
		System.out.println(pagetitle);
		
		String expected="Your Shopping Cart – Aardea";
		if(pagetitle.contains("Your Shopping Cart"))
		{
			Assert.assertEquals(pagetitle,expected);
			String price=driver.findElement(cartpagecontain1).getText();
			String priceVALUE=driver.findElement(cartpagecontain2).getText();
			//System.out.println(price+priceVALUE);
			String totalprice=price.concat(priceVALUE);
			System.out.println(totalprice);
		}
		else 
		{
			System.out.println("This is not a cart page");
		}
		
	}
	
	public void quantityplusminus()
	{
		for (int i=1;i<=3;i++)
		{
			driver.findElement(plusproduct).click();
		}
	}
	
	/*public void wishlistdetails()
	{
		driver.findElement(headerwishlistmenu).click();
	}*/
	/*public void wishlistvalidation() throws InterruptedException
	{
		String pagetitleofwishlist=driver.getTitle().trim();
		System.out.println(pagetitleofwishlist);
		Thread.sleep(3000);
		
		String expected="Wishlist – Aardea";
		if(pagetitleofwishlist.contains("Wishlist"))
		{
			Assert.assertEquals(pagetitleofwishlist,expected );
		}
		
	}*/
}
