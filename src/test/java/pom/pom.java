package pom;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pom {

	WebDriver driver=null;
	
	String url="https://demo.automationtesting.in/Windows.html";
	
	By buttonlink=By.xpath("//a[contains(text(),'Open Seperate Multiple Windows')]");
	By buttonlink2=By.cssSelector("#Multiple > button");
	String pageurl="https://demo.automationtesting.in/Index.html";
	By popupemailfield= By.id("email");
	String emailfield="abc@yopmail.com";
	By buttonclick=By.id("enterimg");
	public Pom(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void urlopen()
	{
		driver.get(url);
	}
	
	public void linkclick() throws InterruptedException
	{
		driver.findElement(buttonlink).click();
		String parentwindowid= driver.getWindowHandle();
		System.out.println(parentwindowid);
		
		driver.findElement(buttonlink2).click();
		
		Set<String> Childwindowid=driver.getWindowHandles();
		System.out.println(Childwindowid);
		
		Thread.sleep(3000);
		/*for(String popups:Childwindowid)
		{
		 if(!popups.equals(parentwindowid))
			{
			driver.switchTo().window(popups);

	       if(driver.getCurrentUrl().equalsIgnoreCase(pageurl))
	         {
	    	
	    	   WebElement email=driver.findElement(popupemailfield);
	    	   email.sendKeys(emailfield);
	    	   WebElement button=driver.findElement(buttonclick);
	    	   button.click();
	    }
			}
		
	}*/
		
		Iterator<String> it1=Childwindowid.iterator();
		
		while(it1.hasNext())
		{
			if(!pop)
		}
		
		
	}	
	
	
}
