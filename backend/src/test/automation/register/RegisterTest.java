package automation.register;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends SetupWeb {
    @Test
    public void registerTest(){
        WebElement registerButton = webDriver.findElement(By.cssSelector(".text-xl"));
        registerButton.click();
    }
}
