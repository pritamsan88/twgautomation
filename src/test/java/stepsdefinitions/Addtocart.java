package stepsdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.pom;

public class Addtocart {
	
	WebDriver driver=null;
	pom aardea;
	
	@Given("browser lunch")
	public void browser_lunch() {
	    System.out.println("Browser is open");
	   String url= System.getProperty("user.dir");
	   System.out.println("Project path is "+url);
	   System.setProperty("WebDriver.chrome.Driver", url+"/src/test/resources/driver/chromedriver.exe");
	   driver=new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   driver.manage().window().maximize();
	   
	}
	
	@Given("enter a website")
	public void enter_a_website() {
		System.out.println(" Enter a Website");
		driver.get("https://www.aardea.com/");
		
	}
	@When("enter product in the search section (.*)$")
	public void enter_product_in_the_search_section_(String product ) throws InterruptedException {
		System.out.println(" search bar open & enter product name of search bar");
		aardea=new pom(driver);
		Thread.sleep(1000);
		aardea.searchclick();
		Thread.sleep(1000);
		aardea.searchbaritem(product);
		
	}
	@When("click on search button in the header search")
	public void click_on_search_button_in_the_header_search() {
		System.out.println("After enter the product user click on search button");
		aardea.afterclickproductname();
	}

	@When("clear the search field")
	public void clear_the_search_field() throws InterruptedException {
	    System.out.println("clear search field");
	    aardea.clearsearchfield();
	}

	@When("select product from auto suggestion dropdown (.*) and (.*)$")
	public void select_product_from_auto_suggestion_dropdown(String product,String autosuggesionproduct) throws InterruptedException {
	   System.out.println("product select from autosuggestion dropdown");
	   aardea.autosuggestion(product,autosuggesionproduct);
	   
	}

	@When("go to product details page")
	public void go_to_product_details_page() throws InterruptedException {
	 System.out.println("This is product details page ");
	 aardea.productdetails();
	}

	@When("click on cart option")
	public void click_on_cart_option() throws InterruptedException {
	   System.out.println("click on add to cart page");
	   aardea.addtocart();
	}

	@When("click on wishlist option")
	public void click_on_wishlist_option() {
	   System.out.println("Also click on wishlist option");
	   
	  // aardea.wishlist();
	}

	@When("go to cart page")
	public void go_to_cart_page() throws InterruptedException {
	    System.out.println("Go to cart details page");
	    aardea.cartsection();
	}

	@Then("user should navigate to cart")
	public void user_should_navigate_to_cart() {
	    System.out.println("check cart page validation");
	    aardea.cartpagevalidation();
	}

	@Then("go to wishlist")
	public void go_to_wishlist() {
	  System.out.println("This is wishlist page");
	//  aardea.wishlistdetails();
	  aardea.quantityplusminus();
	}

	@Then("user should navigate to wishlist page")
	public void user_should_navigate_to_wishlist_page() throws InterruptedException {
	    System.out.println("check wishlist page validation");
	   // aardea.wishlistvalidation();
	    aardea.deletecart();
	}
}
