package stepsdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.addtocartpom;

public class addtocart {
	
	WebDriver driver=null;
	addtocartpom ad1;
	
	@Given("browser open")
	public void browser_open() {
		
		
		System.out.println("Browser is open");
		String projecturl= System.getProperty("user.dir");
		System.out.println("Project path is :-"+projecturl);
		System.setProperty("WebDriver.chrome.driver", projecturl+"/src/test/resources/driver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://thosewoofguys.com/my-account/");
		driver.manage().window().maximize();
	   
	}

	@Given("Go to shop page")
	public void go_to_shop_page() {
		
		System.out.println("Go to shop page");
	    ad1=new addtocartpom (driver);
		ad1.shoppageoprn();
	    
	}

	@When("click add to cart button selective products")
	public void click_add_to_cart_button_selective_products() throws InterruptedException {
	   System.out.println(" click on selective products in the shop page");
	   ad1.addtocartshoppage();
	}

	@When("Go to cart page")
	public void go_to_cart_page() throws InterruptedException {
		System.out.println("cart page open");
		ad1.gotocartpage();
		
	    
	}

	@Then("cart should display items count")
	public void cart_should_display_items_count() {
		System.out.println("cart count verify");
		
		ad1.cardcountverify();
	    
	}
	

}
