package pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class addtocartpom {

	WebDriver driver;
	JavascriptExecutor js;
	
	By shoppage= By.xpath("//a[contains(@href,'//thosewoofguys.com/shop/')]");
	By shoppagecartbutton=By.cssSelector("a.btn_card.crt_btn");
	By cartpage=By.xpath("//a[contains(@href,'thosewoofguys.com/cart/')]");
	By cartcount=By.id("cart-count");
	
	public addtocartpom(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void shoppageoprn()
	{
		driver.findElement(shoppage).click();
	}
	public void addtocartshoppage() throws InterruptedException
	{
		js=(JavascriptExecutor) driver;
		List<WebElement> listofproducts=driver.findElements(shoppagecartbutton);
		System.out.println(listofproducts.size());
		
		for(int i=5;i<10;i++)
		{
			WebElement product=listofproducts.get(i);
			js.executeScript("arguments[0].scrollIntoView(true)", product);
			Thread.sleep(2000);
			js.executeScript("arguments[0].click()", product);
		}
		
	}
	public void gotocartpage() throws InterruptedException
	{
		WebElement cartpageicon=driver.findElement(cartpage);
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true)", cartpageicon);
		js.executeScript("arguments[0].click()",cartpageicon);
		
	}
	
	public void cardcountverify()
	{
		String cartnumber=driver.findElement(cartcount).getText();
		int countnumber=Integer.parseInt(cartnumber);
		
		if(countnumber>0) {
			System.out.println("Product added to cart!");
		}
		else
		{
			System.out.println("Product  not added to cart!");
		}
	}
}
