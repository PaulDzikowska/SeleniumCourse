package taskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");


     WebElement signIn = driver.findElement(By.className("hide_xs"));
    WebElement newsletterElementInput = driver.findElement(By.className("newsletter-input"));


      newsletterElementInput.sendKeys("test@test.com");

      signIn.click();
      WebElement emailAdressInput = driver.findElement(By.className ("is_required"));
      WebElement createAccount = driver.findElement(By.id("SubmitCreate"));
        emailAdressInput.sendKeys("paul.dzikowska@gmail.com");
        createAccount.click();
        WebElement firstName =driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        firstName.sendKeys("Mi");
       // emailAdressInput.
     //   driver.quit();
        }

    }

