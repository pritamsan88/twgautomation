package stepsdefinitions;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.pom;

public class search {
	WebDriver driver=null;
	pom aardea;
	
	@Given("open a browser")
	public void open_a_browser() {
	    System.out.println("Browser is open");
	   String url= System.getProperty("user.dir");
	   System.out.println("Project path is "+url);
	   System.setProperty("WebDriver.chrome.Driver", url+"/src/test/resources/driver/chromedriver.exe");
	   driver=new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   driver.manage().window().maximize();
	   
	}

	@Given("Go to Aardea website")
	public void go_to_aardea_website() {
		System.out.println(" Enter a Website");
		driver.get("https://www.aardea.com/");
		
	}

	@When("users enters(.*)$")
	public void i_add_amalfi_to_search_section(String product) throws InterruptedException {
		System.out.println(" search bar open & enter product name of search bar");
		aardea=new pom(driver);
		Thread.sleep(1000);
		aardea.searchclick();
		Thread.sleep(1000);
		aardea.searchbaritem(product);
		
		
		
	}

	@When("click on search button")
	public void click_on_search_button() {
		System.out.println("After enter the product user click on search button");
		aardea.afterclickproductname();
	}

	@When("Check the sortby functionality")
	public void check_the_sortby_functionality() throws InterruptedException {
		System.out.println("To check the sortby functionality");
		aardea.sortfunctionality();
	}

	@Then("Search result should come according product name(.*)$")
	public void search_result_should_come_according_product_name(String pageurl) throws InterruptedException {
		System.out.println("verify result");
		aardea.productcount();
		aardea.productverify(pageurl);
		
		
		
	}
	@AfterStep
	public void takescreenshot(Scenario sc)
	{
		if(sc.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			final byte[] bs=ts.getScreenshotAs(OutputType.BYTES);
			sc.attach(bs, "image/png", "Capture Screenshot");
			
		}
	}

}
