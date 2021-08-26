package ua.donnu.ta;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Leafground_DropDown {

    private WebDriver driver;

    @BeforeEach
    public void TestSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.leafground.com/home.html");
    }

    @Test
    @DisplayName("Select training program using index")
    public void SelectUsingIndex() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Dropdown.html']")).click();
        driver.findElement(By.xpath("//*[@id = 'dropdown1']")).click();
        driver.findElement(By.xpath("//*[@id = 'dropdown1']//*[@value = '1']")).click();
    }

    @Test
    @DisplayName("Select training program using Text")
    public void SelectUsingText() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Dropdown.html']")).click();
        driver.findElement(By.xpath("//div[@class = 'example']//*[contains(text(), 'Select training program using Text')]")).click();
        driver.findElement(By.xpath("//*[@name = 'dropdown2']//*[contains(text(), 'Selenium')]")).click();
    }

    @Test
    @DisplayName("Select training program using Value")
    public void SelectUsingValue() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Dropdown.html']")).click();
        driver.findElement(By.xpath("//*[@name = 'dropdown3']//*[@value = '0']"));
        driver.findElement(By.xpath("//*[@name = 'dropdown3']//*[@value = '1']"));
    }

    @Test
    @DisplayName("Get the number of dropdown options")
    public void NumberOfDropdownOprtions() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Dropdown.html']")).click();
        WebElement NumberOfOptions = driver.findElement(By.xpath("//*[@class = 'dropdown']"));

    }

    @AfterEach
    public void shutdown() {driver.close();}

}
