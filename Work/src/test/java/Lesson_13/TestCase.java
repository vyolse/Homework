package Lesson_13;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

public class TestCase {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/IdeaProjects/Lesson101/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://andersenlab.com/");
    }

    @Test
    public void isSkypeButtonDisplayed() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        WebElement skypeButton = driver.findElement(By.xpath("//a[contains(@href,'//join.skype.com/')]"));
        if (skypeButton.isDisplayed()) skypeButton.getText();
        String heading = skypeButton.getText();
        assertEquals("skype", heading);
        System.out.println(heading);
    }

    @Test
    public void isTestimonialsDisplayed() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 0)");
        WebElement companyLink = driver.findElement(By.xpath("//div[text()='Company']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(companyLink).build().perform();// Наведение фокуса на элемент
        WebElement testimonialsButton = driver.findElement(By.xpath("//a[text()='Testimonials']"));
        if (testimonialsButton.isDisplayed()) testimonialsButton.getText();
        String heading = testimonialsButton.getText();
        assertEquals("Testimonials", heading);
        System.out.println(heading);
    }

    @AfterAll
    public static void tearDown() {

        driver.quit();
    }
}
