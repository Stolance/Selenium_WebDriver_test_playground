package ua.donnu.ta;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leafground {

    private WebDriver driver;

    @BeforeEach
    public void TestSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.leafground.com/home.html");
    }

    @Test
    @DisplayName("Check that email address was entered into email address field")
    public void EmailAddress () throws InterruptedException {
        driver.findElement(By.xpath("//div[@class = 'row']//li[1]//a[1]")).click();
        driver.findElement(By.xpath("//*[@id = 'email']")).sendKeys("testleaf@gmail.com");
    }

    @AfterEach
    public void shutdown() {driver.close();}

}
