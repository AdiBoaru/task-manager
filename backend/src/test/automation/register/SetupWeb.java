package automation.register;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SetupWeb {
    public WebDriver webDriver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "backend/src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:5173/landing-page");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void closeEnd(){
        //webDriver.quit();
    }
}
