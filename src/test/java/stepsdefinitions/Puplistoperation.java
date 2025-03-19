package stepsdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.Puplist;

public class Puplistoperation {
	
	WebDriver driver=null;
	Puplist pup;
	
	@Given("open website login page")
	public void open_website_login_page() {
		
		System.out.println("Open website login page ...... ...:- ");
		String projecturl= System.getProperty("user.dir");
		System.out.println(projecturl);
		System.setProperty("WebDriver.chrome.driver", projecturl+"/src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://thosewoofguys.com/my-account/");
		driver.manage().window().maximize();
	    
	}

	@Given("login with login credentials (.*) and (.*)$")
	public void login_with_login_credentials(String email,String password) throws InterruptedException {
		
		System.out.println("user enters email and password...... ...:-");
		
		 pup=new Puplist(driver);
		 pup.login(email, password);
		 
	    
	}

	@When("click on login button")
	public void click_on_login_button() throws InterruptedException {
		
		System.out.println(" login button click ...... ...:-");
		pup.loginbuttonclick();
	   
	}

	@Then("verify dashboard")
	public void verify_dashboard() {
		
		System.out.println(" you  are enter dashboard or not ...... ...:-");
	    pup.dashboardverify();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
	    System.out.println("Click add new button ...... ...:- ");
	    pup.addnewbutton();
	}

	@When("user add details of pup (.*) and (.*) and (.*)$")
	public void user_add_details_of_pup_year_and_month_and_golden_retriever(String year,String month,String breed) throws InterruptedException {

		System.out.println("pupadded with details...... ...:-");
		pup.clickpupsubmit1();
		pup.addpup(year, month, breed);
	}

	@When("click on submit")
	public void click_on_submit() throws InterruptedException {
		
		System.out.println("click on submit button after adding pup information...... ...:-");
		pup.clickpupsubmit();
	  
	}

	@Then("verify user goes to puplist page")
	public void verify_user_goes_to_puplist_page() {
		
		System.out.println("verify new pup added in the list or not...... ...:-");
		pup.verifypuplistadded();
	   
	}

	@When("click on edit button")
	public void click_on_edit_button() throws InterruptedException {
		
		System.out.println(" Click on edit puplist button...... ...:-");
		pup.clickeditpup();
		
		
	   
	}

	@When("edit details of pup (.*) and (.*)$")
	public void edit_details_of_pup_weight_and_foodallergy(String weight,String foodallergy) throws InterruptedException {
		
		System.out.println("Edit pup list ...... ...:-");
		pup.editpuplist(weight,foodallergy);
	  
	}

	@Then("verify edit properly or not")
	public void verify_edit_properly_or_not() {
		
		System.out.println("verify pup records edited or not");
		pup.verifypuplistedited();
	   
	}

	@When("delete the pup from puplist")
	public void delete_the_pup_from_puplist() {
		
		System.out.println("delete button click ");
		pup.deletepuplist();
	    
	}

	@Then("verify delete properly or not")
	public void verify_delete_properly_or_not() {
	   pup.verifydelete();
	}

}
