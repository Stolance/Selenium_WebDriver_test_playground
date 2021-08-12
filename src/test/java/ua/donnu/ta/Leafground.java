package ua.donnu.ta;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    @DisplayName("Check that email address field is editable")
    public void EmailAddress () throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Edit.html']")).click();
        driver.findElement(By.xpath("//*[@id = 'email']")).sendKeys("testleaf@gmail.com");
    }

    @Test
    @DisplayName("Check that 'TAB' button functionality is working")
    public void TabAfterText () throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Edit.html']")).click();
        driver.findElement(By.xpath("//div[@class = 'large-6 small-12 columns']//*[@type = 'text']//following::input[1]")).sendKeys("123");
        driver.findElement(By.xpath("//div[@class = 'large-6 small-12 columns']//*[@type = 'text']//following::input[1]")).sendKeys(Keys.TAB);
    }



    @AfterEach
    public void shutdown() {driver.close();}

}
