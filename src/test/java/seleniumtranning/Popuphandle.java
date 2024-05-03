package seleniumtranning;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.Pom;

public class Popuphandle {
	
WebDriver driver=null;	
Pom popup;

@BeforeTest
public void browserstartup()
{
	System.out.println("Browser startup");
	String url= System.getProperty("user.dir");
	System.out.println("Project path is :"+url);
	System.setProperty("WebDriver.chrome.Driver",url+"/src/test/resources/drivers/geckodriver.exe");
	//System.setProperty("WebDriver.chrome.Driver",url+"/src/test/resources/drivers/chromedriver.exe");
	//driver=new ChromeDriver();
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	
}
@Test
public void popup() throws InterruptedException
{
	popup=new Pom(driver);
	
	popup.urlopen();
	popup.linkclick();
}
	
@AfterTest
public void quit() throws InterruptedException
{
	Thread.sleep(5000);
	driver.quit();
}
}
