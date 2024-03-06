package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.IFSHomePage;
import pages.LoginPage;
import utilities.CommonUtils;
import utilities.DriverFactory;

public class StepTest1 {
    WebDriver driver;
    private IFSHomePage homePage;
    private final String prodNumber = "TESTPROD" + RandomStringUtils.randomNumeric(4);
    LoginPage loginPage ;



    @Given("^Login to ifs cloud page with username (.+) and password (.+)$")
    public void loginToIfsCloudPageWithUsernameAndPassword(String username, String password) throws InterruptedException {

        driver = DriverFactory.getDriver();
        LoginPage loginPage = new LoginPage(driver);
             //loginPage.login("sriram.karanam","abcd1234");
       loginPage.login(username, password);

    }




    @When("Navigate to products and models and create a new product")
    public void navigate_to_products_and_models_and_create_a_new_product() throws InterruptedException {
        homePage = new IFSHomePage(driver);
        homePage.createNewProduct(prodNumber, prodNumber, "ATPaas");


    }

    @Then("Validate the product which is created")
    public void validate_the_product_which_is_created() throws InterruptedException {
        homePage = new IFSHomePage(driver);
        homePage.searchProduct(prodNumber);
        String expectedValue = driver.findElement(By.xpath("//form[1]")).getAttribute("tooltip");
        Assert.assertEquals(expectedValue, prodNumber);


    }

    @Then("Validate the product which is created should not list in product list")
    public void validateTheProductWhichIsCreatedShouldNotListInProductList() throws InterruptedException {
        homePage = new IFSHomePage(driver);
        homePage.searchProduct(prodNumber);
        String expectedValue = driver.findElement(By.xpath("//form[1]")).getAttribute("tooltip");

        Assert.assertNotEquals(expectedValue, "ABCD1234");


    }
    
  
    @Given("Login to ifs cloud page from excell sheet login {string} and rownumber {int}")
    public void login_to_ifs_cloud_page_from_excell_sheet_login_and_rownumber(String sheetname, Integer rownumber) throws InvalidFormatException, IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
    	driver = DriverFactory.getDriver();
    	LoginPage loginPage = new LoginPage(driver);
    	CommonUtils utils = new CommonUtils();
    	List<Map<String, String>> testdata = utils.getData(System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\testdata.xlsx","Loginuser");

	String userid = testdata.get(rownumber).get("UserDetails");

    String pass = testdata.get(rownumber).get("PasswordDetails");
    System.out.println(userid+' '+' '+pass);   	 
    
        if (userid !=null || pass != null) {
        	
        	 loginPage.login(userid, pass); 
		}
        
    	
    	
                 
        
    	
    	}
 


}


