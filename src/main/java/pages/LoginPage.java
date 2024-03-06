package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;







public class LoginPage {
	
	
	WebDriver driver ;

	    public LoginPage(WebDriver driver) {
	        //Initiate driver locally
	        this.driver = driver;
	        PageFactory.initElements(driver, this);//initiate all elements to this driver
	    }


	    @FindBy(id="username")
	    WebElement username;

	    @FindBy(id="password")
	    WebElement userpassword;

	    @FindBy(name="login")
	    WebElement login;



	    public void login(String user,String pwd) throws InterruptedException {
              Thread.sleep(2000);
              System.out.println(user+pwd);
              username.sendKeys(user);
              userpassword.sendKeys(pwd);
	       /* driver.findElement(By.id("username")).click();
	        driver.findElement(By.id("username")).sendKeys(user);
	        driver.findElement(By.id("password")).click();
	        driver.findElement(By.id("password")).sendKeys(pwd);*/
	        
	       // userpassword.sendKeys(pwd);
	        login.click();


	    }
	}



