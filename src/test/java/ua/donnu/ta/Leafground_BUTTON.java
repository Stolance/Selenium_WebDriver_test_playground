package ua.donnu.ta;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class Leafground_BUTTON {

    private WebDriver driver;

    @BeforeEach
    public void TestSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.leafground.com/home.html");
    }

    @Test
    @DisplayName("Check that 'Go to home Page' button is redirecting to home page")
    public void GoToHomePage() throws InterruptedException {
        String HomePageUrl = "http://www.leafground.com/home.html";
        driver.findElement(By.xpath("//a[@href = 'pages/Button.html']")).click();
        driver.findElement(By.xpath("//div[@class= 'large-6 small-12 columns']//*[@id = 'home']")).click();
        String CurrentPage = driver.getCurrentUrl();
        Assertions.assertEquals(HomePageUrl, CurrentPage);
    }

    @Test
    @DisplayName("Find button position (x,y)")
    public void FindButtonPos() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Button.html']")).click();
        Point PositionOfButton = driver.findElement(By.xpath("//div[@class= 'large-6 small-12 columns']//*[@id = 'position']")).getLocation();
        System.out.println("PositionOfButton = " + PositionOfButton);
    }

    @Test
    @DisplayName("Find button color")
    public void FindButtonColor() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Button.html']")).click();
        String ButtonColor = driver.findElement(By.xpath("//div[@class= 'large-6 small-12 columns']//*[@id = 'color']")).getCssValue("background-color");
        System.out.println("ButtonColor = " + ButtonColor);
    }

    @Test
    @DisplayName("Find the height and width of the button")
    public void FindHeightAndWidh() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Button.html']")).click();
        Dimension SizeOfTheButton = driver.findElement(By.xpath("//div[@class= 'large-6 small-12 columns']//*[@id = 'size']")).getSize();
        System.out.println("SizeOfTheButton = " + SizeOfTheButton);
    }

    @AfterEach
    public void shutdown() {driver.close();}

}
