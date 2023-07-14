package pages;

import br.com.meta.entity.ClientHttp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    ClientHttp baseUrl = new ClientHttp();

    WebDriver driver = null;

    private By txt_username = By.xpath("(//input[@name='email'])[1]");
    private By txt_password = By.xpath("//input[@type='password']");
    private By loginButton= By.xpath("(//button[contains(@class,'btn btn-default')])[1]");

    private By first_product = By.xpath("(//a[@data-product-id='1'])[1]");

    public void login() {
        driver = new ChromeDriver();
        driver.get(baseUrl.Url()+"/login");
        driver.findElement(txt_username).sendKeys("fabi.meta@example.com");
        driver.findElement(txt_password).sendKeys("123456");
        driver.findElement(loginButton).click();

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,350", "");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        driver.findElement(first_product).click();


    }

}
