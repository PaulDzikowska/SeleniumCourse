package myStore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarsztatyZadanie1 {

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
    public void tearDown(){

        //driver.quit();
    }

    @Test
    public void testCreateNewAddress() {

        String email = "klwmlyivgwqvbynsmi@bvhrs.com";
        String pass = "coderslab";
        String alias = "PaulD";
        String first_name = "Paul";
        String last_name = "Dzika";
        String address = "Leona 1/2";
        String city = "Wejherowo";
        String postal_code = "84-200";
        String country = "United Kingdom";
        String phone = "555666999";

        String expectedAlertText = "Address successfully added!";

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


        // Wyszukaj przycisk Addresses
        WebElement addressesLink = this.driver.findElement(By.linkText("Addresses"));
        addressesLink.click(); // Kliknij na przycisk Addresses

        // Wyszukaj przycisk Create new address
        WebElement newAddressLink = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/a/span"));
        newAddressLink.click(); // Kliknij na przycisk Addresses

        //Wyszukaj alias i wpisz
        WebElement aliasInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input"));
        aliasInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        aliasInput.sendKeys(alias);

        //Wyszukaj FirstName i wpisz
        WebElement firstNameInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[2]/div[1]/input"));
        firstNameInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        firstNameInput.sendKeys(first_name);

        //Wyszukaj LastName i wpisz
        WebElement lastNameInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[3]/div[1]/input"));
        lastNameInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        lastNameInput.sendKeys(last_name);

        //Wyszukaj address i wpisz
        WebElement addressInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[6]/div[1]/input"));
        addressInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        addressInput.sendKeys(address);

        //Wyszukaj city i wpisz
        WebElement cityInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input"));
        cityInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        cityInput.sendKeys(city);

        //Wyszukaj Zip/Postal Code i wpisz
        WebElement postalCodeInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input"));
        postalCodeInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        postalCodeInput.sendKeys(postal_code);

        //Wyszukaj country i wpisz
        WebElement countryInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select"));
        countryInput.click(); // rozwiń listę
        countryInput.sendKeys(country);

        //Wyszukaj phone i wpisz
        WebElement phoneInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input"));
        phoneInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        phoneInput.sendKeys(phone);

        // Wyszukaj przycisk SAVE
        WebElement saveButton = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        saveButton.click(); // Kliknij na przycisk Addresses


        // Sprawdz czy adres poprawnie dodany
        WebElement successAlertField = this.driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));

        // Pobierz informacje o poprawnym dodaniu adresu
        String alertText = successAlertField.getText();

        // Zweryfikuj komunikat.
        assertEquals(expectedAlertText, alertText);


        // Pobierz dane dodanego adresu
        WebElement addressField = this.driver.findElement(By.className("address-body"));
        String addedAddressText = addressField.getText();

        //sprawdzenie czy dodany adres jest poprawny
        addedAddressText = addedAddressText.replaceAll("\\s+",""); //usuwam wszystkie spacje z dodanego adresu
        //System.out.println(addedAddressText);

        String expectedAddressText = alias + first_name + last_name + address + city + postal_code + country + phone;
        expectedAddressText = expectedAddressText.replaceAll("\\s+",""); //usuwam wszystkie spacje z oczekiwanego adresu

        // weryfikacja adresów
        assertEquals(expectedAddressText, addedAddressText);

    }
}