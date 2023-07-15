package pages;

import br.com.meta.entity.ClientHttp;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Tools;

import java.util.concurrent.TimeUnit;

public class Elements {
    Tools acao = new Tools();
    ClientHttp baseUrl = new ClientHttp();
    WebDriver driver = null;

    private By txt_username = By.xpath("(//input[@name='email'])[1]");
    private By txt_password = By.xpath("//input[@type='password']");
    private By loginButton= By.xpath("(//button[contains(@class,'btn btn-default')])[1]");
    private By first_product = By.xpath("(//a[@data-product-id='1'])[1]");
    private By modal_Continue_Shopping = By.xpath("//button[@data-dismiss='modal']");
    private By second_product = By.xpath("(//a[@data-product-id='2'])[1]");
    private By cart= By.xpath("//a[contains(.,'Cart')]");
    private By removeProductButton = By.xpath("//a[@data-product-id='1']");
    private By proceedToCheckoutButton = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private By placeOrder = By.xpath("//a[contains(@class,'btn btn-default')]");
    private By nameOnCard = By.xpath("//div[@class='col-sm-12 form-group']//input[1]");
    private By cardNumber = By.xpath("(//div[contains(@class,'col-sm-12 form-group')]//input)[2]");
    private By cvcCard = By.xpath("//input[@class='form-control card-cvc']");
    private By  expirationCardMonth = By.xpath("//input[@class='form-control card-expiry-month']");
    private By expirationCardYear = By.xpath("//input[@class='form-control card-expiry-year']");
    private By payAndConfirmOrder = By.xpath("//button[contains(@class,'form-control btn')]");
    private By orderPlacedMessage = By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");
    public void login(){
        driver = new ChromeDriver();
        driver.navigate().to(baseUrl.Url()+"/login");
        driver.manage().window().maximize();
        driver.findElement(txt_username).sendKeys("fabi.meta@example.com");
        driver.findElement(txt_password).sendKeys("123456");
        driver.findElement(loginButton).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 450)");
    }

    public void addFirstProduct(){
         driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(first_product).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(modal_Continue_Shopping).click();
    }
    public void addSecondProduct(){
        driver.findElement(second_product).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(modal_Continue_Shopping).click();
    }

    public void removeTheProductFromCart(){
        driver.findElement(cart).click();
        driver.findElement(removeProductButton).click();
    }

    public void navigateAndBuyAgain(){
        driver.navigate().to(baseUrl.Url());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 450)");
        addFirstProduct();
        driver.findElement(cart).click();

    }

    public void checkout(){
        driver.findElement(proceedToCheckoutButton).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 850)");
        driver.findElement(placeOrder).click();
    }
    public void buySucess(){
        driver.navigate().to(baseUrl.Url()+"/payment");
        driver.findElement(nameOnCard).sendKeys("Fabiana Alves");
        driver.findElement(cardNumber).sendKeys("5486 6092 8172 0979");
        driver.findElement(cvcCard).sendKeys("954");
        driver.findElement(expirationCardMonth).sendKeys("11");
        driver.findElement(expirationCardYear).sendKeys("2024");
        driver.findElement(payAndConfirmOrder).click();
        String placedOrder = driver.findElement(orderPlacedMessage).getText();
        Assert.assertEquals(placedOrder,"Congratulations! Your order has been confirmed!");

    }
}
