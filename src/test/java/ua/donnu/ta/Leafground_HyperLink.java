package ua.donnu.ta;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leafground_HyperLink {

    private WebDriver driver;

    @BeforeEach
    public void TestSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.leafground.com/home.html");
    }

    @Test
    @DisplayName("Go to home page")
    public void GoToHomePage() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Link.html']")).click();
        driver.findElement(By.xpath("//div[@class = 'large-6 small-12 columns']//a[@href = '../home.html']")).click();
    }

    @Test
    @DisplayName("Find where does the link lead without clicking on it")
    public void WhereDoesTheLinkLead() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Link.html']")).click();
        String Link = driver.findElement(By.xpath("//div[@class = 'large-6 small-12 columns']//a[@style = 'color:green']")).getAttribute("href");
        System.out.println("Link = " + Link);
    }

    @Test
    @DisplayName("Check that 'Verify am I broken' link is broken")
    public void BrokenLink() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Link.html']")).click();
        driver.findElement(By.xpath("//div[@class = 'large-6 small-12 columns']//a[@href = 'error.html']")).click();
        String TitleOfThePage = driver.getTitle();
        Assertions.assertEquals(TitleOfThePage, "HTTP Status 404 – Not Found");
    }

    @Test
    @DisplayName("Interact with the same link name")
    public void SameLinkName() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Link.html']")).click();
        driver.findElement(By.xpath("//a[@href = '../home.html']//following::label"));

    }

    @AfterEach
    public void shutdown() {driver.close();}

}
