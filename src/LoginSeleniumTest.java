import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginSeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        // point to chromedriver
        System.setProperty("webdriver.chrome.driver", 
            "C:\\drivers\\chromedriver.exe");

        // point to Brave browser
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\pc\\AppData\\Local\\BraveSoftware\\" +
            "Brave-Browser\\Application\\brave.exe");
        options.addArguments("--start-maximized");

        // open Brave browser
        WebDriver driver = new ChromeDriver(options);

        // go to test login page
        driver.get("https://the-internet.herokuapp.com/login");
        Thread.sleep(2000);

        // type username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        // type password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        // click login
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);

        // check result
        String bodyText = driver.findElement(By.tagName("body")).getText();
        if (bodyText.contains("You logged into a secure area")) {
            System.out.println("✅ TEST PASSED - Login successful");
        } else {
            System.out.println("❌ TEST FAILED - Login did not work");
        }

        Thread.sleep(3000);

        // close browser
        driver.quit();
    }
}