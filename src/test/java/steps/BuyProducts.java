package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.Products;

import java.util.concurrent.TimeUnit;

public class BuyProducts {
    LoginPage realizar = new LoginPage();
    Products adicionar = new Products();
    WebDriver driver = null;

    @Given("Que possuo uma conta no sistema automationexercise")
    public void que_possuo_uma_conta_no_sistema_automationexercise() {

        String projectPath = System.getProperty("user.dir");

        System.getProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        realizar.login();

    }


}
