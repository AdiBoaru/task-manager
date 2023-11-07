package automation.register;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupWeb {
    public WebDriver webDriver;

    @Before
    public void setup(){
        System.setProperty("webDriver.chrome.driver",
                "C:\\Users\\USER\\TaskManager\\task-manager\\backend\\src\\main\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:5173/");
        webDriver.manage().window().maximize();
    }

    @After
    public void closeEnd(){
        //webDriver.quit();
    }
}
