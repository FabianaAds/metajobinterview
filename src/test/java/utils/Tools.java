package utils;

import br.com.meta.entity.ClientHttp;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Tools {
ClientHttp baseUrl = new ClientHttp();
WebDriver driver = null;

    public void navigateToHome(){
        driver.navigate().to(baseUrl.Url()+"/login");

    }

    public void webDriverPath(){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+ "/src/test/resources/drivers/chromedriver.exe");


    }
}
