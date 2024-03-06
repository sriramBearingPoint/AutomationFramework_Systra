package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonUtils;
import utilities.ElementUtils;

public class IFSHomePage {
	WebDriver driver ;
    CommonUtils commonUtils;
    private ElementUtils elementUtils;


    public IFSHomePage(WebDriver driver) {

        //Initiate driver locally
        this.driver = driver;
        PageFactory.initElements(driver,this);//initiate all elements to this driver
        commonUtils = new CommonUtils();
        elementUtils = new ElementUtils(driver);
    }


    @FindBy(id="searchInputInsideNavigationMenu")
    WebElement searchInput;

    @FindBy(css="div[class='link-item ng-star-inserted'] span[class='title']")
    WebElement productsandmodels;

    @FindBy(css=".granite-icon.icon-new.ng-star-inserted")
    WebElement addNewId;

    @FindBy(xpath="//div[2]/div/div/input")
    WebElement productNumber;

    @FindBy(xpath="//fnd-input-field-container[2]/fnd-input-field/div/form/div[2]/div/div/input")
    WebElement productDescription;

    @FindBy(xpath="//fnd-input-field-container[3]/fnd-input-field/div/form/div[2]/div/div/input")
    WebElement productType;

    @FindBy(css="#Form-fndToolbar-action-Save-fndButton-button > .content > .ng-star-inserted")
    WebElement save;




    @FindBy(xpath="//div[@title='Product Number']")
    WebElement productNumberFilter;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchFilter;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;



    public String getProductNumber(){
       return commonUtils.generateRandonNumber();

    }

    public String getProductDescription(){
        return commonUtils.generateRandonNumber();
    }


    public void createNewProduct(String prodnumber,String prodDesc,String prodtype) throws InterruptedException {
        Thread.sleep(5000);
        searchInput.click();
        searchInput.sendKeys("product and models");
        productsandmodels.click();
        addNewId.click();
        productNumber.click();
        productNumber.sendKeys(prodnumber);
        productDescription.click();
        productDescription.sendKeys(prodDesc);
        productType.click();
        productType.sendKeys(prodtype);
        save.click();

    }

    public void searchProduct(String prodnumber) throws InterruptedException {
        Thread.sleep(5000);
        productNumberFilter.click();
        searchFilter.click();
        Thread.sleep(2000);
        searchFilter.sendKeys(prodnumber);
        searchFilter.sendKeys(Keys.ENTER);
        searchButton.click();


    }
}
