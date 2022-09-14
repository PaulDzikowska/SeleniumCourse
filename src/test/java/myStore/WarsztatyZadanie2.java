package myStore;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;
import javax.imageio.ImageIO;
import java.awt.Robot;
import java.awt.AWTException;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarsztatyZadanie2 {

    private WebDriver driver;


    @BeforeEach
    public void setUp(){
        //        Ustaw gdzie jest chromedriver -> STEROWNIK
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        //        Otworz przegladarke
        this.driver = new ChromeDriver();

        //        Jesli test nie przechodzi poprawnie, to pewnie za wolno laduje sie strona -> Dodaj czekanie.
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public  void tearDown(){

        //driver.quit();
    }


    @Test
    public void testOrder() {

        String email = "klwmlyivgwqvbynsmi@bvhrs.com";
        String pass = "coderslab";
        String qty = "5";

        // Wejdz na strone glowna
        this.driver.get("https://mystore-testlab.coderslab.pl");

        //Wyszukaj przycisk Sign in
        WebElement signInButton = this.driver.findElement(By.className("user-info"));
        signInButton.click(); // Sign in

        //wyszukujemy pole i wpisujemy email
        WebElement emailInput = this.driver.findElement(By.className("form-control"));
        emailInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        emailInput.sendKeys(email);

        //Wyszukaj pole i wpisujemy hasło
        WebElement passwordInput = this.driver.findElement(By.xpath("//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input"));
        passwordInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        passwordInput.sendKeys(pass);

        //Klikamy SIGN IN
        WebElement submitButton = this.driver.findElement(By.id("submit-login"));
        submitButton.click();

        // przejdź na stronę ubrań
        WebElement clothesLink = this.driver.findElement(By.xpath("//*[@id=\"category-3\"]/a"));
        clothesLink.click();

        // Wybierz do zakupu Hummingbird Printed Sweater
        WebElement sweaterLink = this.driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[2]/div/div[1]/h2/a"));
        sweaterLink.click();


        //Rozwiń listę i wybierz rozmiar M
        WebElement sizeInput = this.driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
        sizeInput.click(); // rozwiń listę
        sizeInput.sendKeys("M");

        //Wpisz ilosc
        WebElement qtyInput = this.driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]"));
        qtyInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        qtyInput.sendKeys(qty);

        //Dodaj do koszyka
        WebElement addToCartButton = this.driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
        addToCartButton.click();

        //przycisk Proceed To Checkout
        WebElement checkoutButton = this.driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        checkoutButton.click();

        //przycisk Proceed To Checkout 2
        WebElement checkout2Button = this.driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        checkout2Button.click();

        //Potwierdzenie adresu dodanego w zadaniu 1
        WebElement confirmAdrrButton = this.driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button"));
        confirmAdrrButton.click();

        // Kliknij w PretaShop
        WebElement shippingMetod = this.driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/div/div[1]/div[1]/div/span/span"));
        shippingMetod.click();

        //Potwierdzenie shipping method
        WebElement shippingMetodContinue = this.driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button"));
        shippingMetodContinue.click();

        //Klikamy Opcję 1 platnosci
        WebElement choosePaymentButton = this.driver.findElement(By.id("payment-option-1"));
        choosePaymentButton.click();

        //Akceptacja Terms And Conditions
        WebElement acceptTandC = this.driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        acceptTandC.click();

        //Order
        WebElement orderContinue = this.driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
        orderContinue.click();

        //robimy screenshot
        // nie wiem czemu nie działa mi Robot, mimo tego że jest zaimportowany
        //Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        //BufferedImage capture = new Robot().createScreenCapture(screenRect);
       // ImageIO.write(capture, "bmp", new File("/screenshot.png"));

    }
}