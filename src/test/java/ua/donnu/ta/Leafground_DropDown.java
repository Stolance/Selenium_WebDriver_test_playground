package ua.donnu.ta;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
        Select NumberOfOptions = new Select(driver.findElement(By.xpath("//*[@class = 'dropdown']")));
        List<WebElement> NumOfOp = NumberOfOptions.getOptions();
        System.out.println("NumOfOp = " + NumOfOp.size());
    }

    @Test
    @DisplayName("Select training program using sendKeys")
    public void UsingSendKeys() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href = 'pages/Dropdown.html']")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'You can also use sendKeys to select')]//parent::select")).click();
        WebElement DropBox = driver.findElement(By.xpath("//*[contains(text(), 'You can also use sendKeys to select')]//parent::select"));
        DropBox.sendKeys(Keys.ARROW_DOWN);
        DropBox.sendKeys(Keys.ENTER);
    }

    @AfterEach
    public void shutdown() {driver.close();}

}
