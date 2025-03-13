package pageobjectmodel;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Puplist {
	
	WebDriver driver=null;
	
	JavascriptExecutor js;
	
	By emaillogin= By.id("username");
	By passwordlogin=By.id("password");
	By loginbuttonlocator=By.xpath("//button[contains(text(),'Log in')]");
	By dashboard=By.xpath("//h2[contains(text(),'Dashboard')]");
	By counttitle=By.cssSelector("h3.dog_profile_count_cls");
	By count=By.cssSelector("span.user_ordr_count");
	By addnewbutton=By.xpath("//a[contains(text(),'Add New')]");
	By pupname=By.name("dog_name");
	By gender=By.id("Female");
	By listofyear2=By.xpath("//select[@id='dog_age_year']/option");
	By listofmonth2=By.xpath("//select[@id='dog_age_month']/option");
	By breed2=By.xpath("//select[@id='dog_breed']/option");
	By pupweight=By.xpath("//input[@type='number']");
	By needs=By.id("Maintaincurrentweight");
	By editpuplist=By.xpath("//a[contains(text(),'Edit')]");
	By sucessmessage=By.cssSelector("#post-9 > div > div > div > section > div > span");
	
	By foodrules= By.xpath("//select[@name='allergies[]']/option");
	By editpupyear2=By.xpath("//select[@name='dog_age_year']/option");
	By editpupmonth2=By.xpath("//select[@name='dog_age_month']/option");
	By deletepuplist=By.xpath("//button[@name='delete_dog_profile']");
	
	public Puplist(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void login(String email,String password) throws InterruptedException
	{
		
		 driver.findElement(emaillogin).sendKeys(email);
		 driver.findElement(passwordlogin).sendKeys(password);
		 
	}
	public void loginbuttonclick() throws InterruptedException
	{
		js=(JavascriptExecutor) driver;
		WebElement loginbutton=driver.findElement(loginbuttonlocator);
		 js.executeScript("arguments[0].scrollIntoView();", loginbutton);
		 Thread.sleep(1000);
		 js.executeScript("arguments[0].click();", loginbutton);
	}
	public void dashboardverify()
	{
		String dashboardtext=driver.findElement(dashboard).getText();
		if(dashboardtext.contains("Dashboard"))
		{
			System.out.println(" You are enter dashboard ");
			
		}else
		{
			System.out.println(" Not dashboard ");
		}
		
	}
	public void addnewbutton() throws InterruptedException
	{
		
		String countitletext=driver.findElement(counttitle).getText();
		System.out.println(countitletext);
		String counttext=driver.findElement(count).getText();
		System.out.println(counttext);
		Thread.sleep(2000);
		WebElement addnewpup=driver.findElement(addnewbutton);
		js.executeScript("arguments[0].scrollIntoView();", addnewpup);
		js.executeScript("arguments[0].click();", addnewpup);
		
		
		
		
	}
	
	public void addpup(String year,String month,String breed) throws InterruptedException 
	{
		
		WebElement pupnameadd=driver.findElement(pupname);
		pupnameadd.sendKeys("Tommy");
		Thread.sleep(1000);
		
		List<WebElement> listofyear=driver.findElements(listofyear2);
		
		for(WebElement pupyear:listofyear)
		{
			String yearcatch=pupyear.getText().trim();
			//System.out.println(year);
			 if(yearcatch.contains(year))
			 {
				 pupyear.click();
				 Thread.sleep(1000);
				 
				   
			 }
		
		}
		
		List<WebElement> listofmonth=driver.findElements(listofmonth2);
		
		for(WebElement pupmonth:listofmonth)
		{
			String monthcatch=pupmonth.getText().trim();
			 //System.out.println(month);
			 if(monthcatch.contains(month))
			 {
				 pupmonth.click();
				 Thread.sleep(1000);
			 }
			 
		}
		Thread.sleep(1000);
		WebElement genderpup=driver.findElement(gender);
		genderpup.click();
		Thread.sleep(1000);
		
		List<WebElement> listofbreed2=driver.findElements(breed2);
		
		for(WebElement pupbreed:listofbreed2)
		{
			String breedpup=pupbreed.getText().trim();
			// System.out.println(breed);
			 if(breedpup.contains(breed))
			 {
				 pupbreed.click();
				 Thread.sleep(1000);
			 }
			 
		}
		
		WebElement weight=driver.findElement(pupweight);
		js.executeScript("arguments[0].scrollIntoView();", weight);
		weight.sendKeys("80");
		
		WebElement mydogsneeds=driver.findElement(needs);
		js.executeScript("arguments[0].click();", mydogsneeds);
		//mydogsneeds.click();
		
		WebElement uploadpics=driver.findElement(By.xpath("//input[@id='uplod_pop']")); 
		 uploadpics.sendKeys("C:\\Users\\ETPL-DTP-020\\Downloads\\dog.jpg");
		 Thread.sleep(1000);
		
		
	}
	public void clickpupsubmit() throws InterruptedException
	{
		WebElement submit=driver.findElement(By.xpath("//input[@type='submit']"));
		Thread.sleep(1000);
		submit.click();
		Thread.sleep(1000);
	}
	
	public void verifypuplistadded()
	{
		try {
			WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(40));
            WebElement successMessage = wait1.until(
            ExpectedConditions.visibilityOfElementLocated(sucessmessage));
			
			//WebElement pupaddedalert=driver.findElement(By.cssSelector("#post-9 > div > div > div > section > div > span"));
			
			String alert=successMessage.getText();
			if(alert.contains("New profile has been registered successfully!"))
			{
				  System.out.println("Create operation verified: " + alert);
			}else
			{
				System.err.println("Unexpected message: " + alert);
			}
			}catch (org.openqa.selenium.TimeoutException e) {
				System.err.println("Timeout occurred: " + e.getMessage());
			}
	}
	
	
	public void clickeditpup() throws InterruptedException
	{
		String currentwindowID= driver.getWindowHandle();
		System.out.println(currentwindowID);
		
		//WebDriverWait wait2= new WebDriverWait(driver, Duration.ofSeconds(40));
		//WebElement editpuplistbutton=wait2.until(ExpectedConditions.elementToBeClickable(editpuplist));
		Thread.sleep(1000);
		WebElement editpuplistbutton=driver.findElement(editpuplist);
		
		js.executeScript("arguments[0].click();", editpuplistbutton);
		Thread.sleep(1000);
		//editpuplistbutton.click();
		Set<String> windowIDs= driver.getWindowHandles();
		System.out.println(windowIDs);
		
		
	}
	
	public void editpuplist(String weight,String foodallergy) throws InterruptedException
	{
		
      /* List<WebElement> listofyear=driver.findElements(editpupyear2);
		
		for(WebElement pupyear:listofyear)
		{
			String yearcatch=pupyear.getText();
			System.out.println(yearcatch);
			
			
				if(yearcatch.equalsIgnoreCase(updateyear))
				 {
					 Thread.sleep(1000);
					 js.executeScript("arguments[0].click();", pupyear);
					 
				 }
			
			 
		}
		Thread.sleep(1000);
		
		List<WebElement> listofmonth=driver.findElements(editpupmonth2);
		
		for(WebElement pupmonth:listofmonth)
		{
			String monthcatch=pupmonth.getText();
			 System.out.println(monthcatch);
			
			 
				 if(monthcatch.equalsIgnoreCase(updatemonth))
				 {
					 Thread.sleep(1000);
					 js.executeScript("arguments[0].click();", pupmonth);
					
				 }
			 
			
			 
		}*/
		
		
		Thread.sleep(1000);
		//WebElement genderpup=driver.findElement(gender);
		//js.executeScript("arguments[0].scrollIntoView();", genderpup);
		//genderpup.click();
		
		
		/*List<WebElement> listofbreed2=driver.findElements(breed2);
		
		for(WebElement pupbreed:listofbreed2)
		{
			String breedpup=pupbreed.getText().trim();
			// System.out.println(breed);
			 if(breedpup.contains(editbreed))
			 {
				 pupbreed.click();
				 Thread.sleep(1000);
			 }
			 
		}*/
		
		WebElement weight1=driver.findElement(pupweight);
		weight1.clear();
		js.executeScript("arguments[0].scrollIntoView();", weight1);
		weight1.sendKeys(weight);
		Thread.sleep(1000);
		
		WebElement mydogsneeds=driver.findElement(needs);
		js.executeScript("arguments[0].click();", mydogsneeds);
		Thread.sleep(1000);
		
		 List<WebElement> Anyfoodrules=driver.findElements(foodrules);
			
			for(WebElement foodrules:Anyfoodrules)
			{
				String breedfoodrules=foodrules.getText();
				// System.out.println(breedfoodrules);
				if(breedfoodrules!=null)
				{
					if(breedfoodrules.contains(foodallergy))
					 {
						 foodrules.click();
						 Thread.sleep(1000);
					 }
				}
				 
		
				 /*else
				 {
					 System.out.println("not present in list");
				 }*/
			}
		
		
		
		
		WebElement submit=driver.findElement(By.xpath("//input[@type='submit']"));
		Thread.sleep(1000);
		submit.click();
		Thread.sleep(1000);
	}
	
	public void verifypuplistedited()
	{
		try {
			WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(40));
            WebElement successMessage = wait1.until(
            ExpectedConditions.visibilityOfElementLocated(sucessmessage));
			
			//WebElement pupaddedalert=driver.findElement(By.cssSelector("#post-9 > div > div > div > section > div > span"));
			
			String alert=successMessage.getText();
			if(alert.contains("Profile updated successfully!"))
			{
				  System.out.println("Edit operation verified: " + alert);
			}else
			{
				System.err.println("Unexpected message: " + alert);
			}
			}catch (org.openqa.selenium.TimeoutException e) {
				System.err.println("Timeout occurred: " + e.getMessage());
			}
	}
	
	public void deletepuplist()
	{
		WebElement delete=driver.findElement(deletepuplist);
		delete.click();
		
		Alert alert=driver.switchTo().alert();
		System.out.println("Alert Text: " + alert.getText());
		alert.accept();
	}
	
	public void verifydelete()
	{
		try
		{
		
		WebDriverWait wait2= new  WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement successMessage=wait2.until(ExpectedConditions.visibilityOfElementLocated(sucessmessage));
		
		String alert= successMessage.getText();
		
		if(alert.contains("Profile deleted successfully!"))
		{
			System.out.println(" Deleted operation verified: "+alert);
		}else {
			System.err.println("Unexpected message: " + alert);
		}
		}catch (org.openqa.selenium.TimeoutException e) {
			
			System.err.println("Timeout occurred: " + e.getMessage());
			
		}
	}
    
	
	

}
