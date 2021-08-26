package ua.donnu.ta;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Leafground_IMAGE {

    private WebDriver driver;

    @BeforeEach
    public void TestSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.leafground.com/home.html");
    }

    @Test
    @DisplayName("Click on image to go home page")
    public void ClickOnImageToGoHomePage() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Image.html']")).click();
        driver.findElement(By.xpath("//*[@src= '../images/home.png']")).click();
        String CurrentPage = driver.getCurrentUrl();
        System.out.println(CurrentPage);
    }

    @Test //don't know how to create http request for getting error status
    @Disabled
    @DisplayName("Check is image broken")
    public void IsImageBroken() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Image.html']")).click();
    }

    @Test
    @DisplayName("Click on image using mouse or keyboard")
    public void ClickUsingMouseOrKeyboard() throws InterruptedException {
        //mouse
        driver.findElement(By.xpath("//a[@href = 'pages/Image.html']")).click();
        WebElement Image = driver.findElement(By.xpath("//*[@src= '../images/keyboard.png']"));
        Actions builder = new Actions(driver);
        Action mouseOnImagesPage = builder
                .moveToElement(Image)
                .click()
                .build();
        mouseOnImagesPage.perform();
    }

    @AfterEach
    public void shutdown() {driver.close();}

}
