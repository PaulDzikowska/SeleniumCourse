package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreAddressPage {
    private WebDriver driver;

    public StoreAddressPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickSignIn() {
        //Wyszukaj przycisk Sign in
        WebElement signInButton = this.driver.findElement(By.className("user-info"));
        signInButton.click(); // Sign in
    }

    public void inputEmail(String email) {
        WebElement emailInput = this.driver.findElement(By.className("form-control"));
        emailInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        emailInput.sendKeys(email);
    }

    public void inputPassword(String pass) {
        WebElement passwordInput = this.driver.findElement(By.xpath("//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input"));
        passwordInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        passwordInput.sendKeys(pass);
    }

    public void clickSubmit() {
        WebElement submitButton = this.driver.findElement(By.id("submit-login"));
        submitButton.click();
    }

    public void clickAddressLink() {
        WebElement addressesLink = this.driver.findElement(By.linkText("Addresses"));
        addressesLink.click(); // Kliknij na przycisk Addresses
    }

    public void clickCreateAddress() {
        WebElement newAddressLink = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/a/span"));
        newAddressLink.click(); // Kliknij na przycisk Addresses
    }

    public void inputAlias(String alias) {
        //Wyszukaj alias i wpisz
        WebElement aliasInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input"));
        aliasInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        aliasInput.sendKeys(alias);
    }

    public void inputFirstName(String first_name) {
        //Wyszukaj FirstName i wpisz
        WebElement firstNameInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[2]/div[1]/input"));
        firstNameInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        firstNameInput.sendKeys(first_name);
    }

    public void inputLastName(String last_name) {
        WebElement lastNameInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[3]/div[1]/input"));
        lastNameInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        lastNameInput.sendKeys(last_name);
    }

    public void inputAddress(String address) {
        WebElement addressInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[6]/div[1]/input"));
        addressInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        addressInput.sendKeys(address);
    }

    public void inputCity(String city) {
        WebElement cityInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input"));
        cityInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        cityInput.sendKeys(city);
    }

    public void inputPostalCode(String postal_code) {
        WebElement postalCodeInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input"));
        postalCodeInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        postalCodeInput.sendKeys(postal_code);
    }


    public void inputCountry(String country) {
        WebElement countryInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select"));
        countryInput.click(); // rozwiń listę
        countryInput.sendKeys(country);
    }

    public void inputPhone(String phone) {
        WebElement phoneInput = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input"));
        phoneInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        phoneInput.sendKeys(phone);
    }

    public void clickSaveAddress() {
        WebElement saveButton = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        saveButton.click(); // Kliknij na przycisk Addresses
    }

    public void checkMessage(String expectedAlertText) {
        // Sprawdz czy adres poprawnie dodany
        WebElement successAlertField = this.driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));
        // Pobierz informacje o poprawnym dodaniu adresu
        String alertText = successAlertField.getText();
        // Zweryfikuj komunikat.
        assertEquals(expectedAlertText, alertText);
    }

    public void checkAddedAddress(String alias, String first_name, String last_name, String address, String city, String postal_code, String country, String phone) {
    // Pobierz dane dodanego adresu
    WebElement addressField = this.driver.findElement(By.className("address-body"));
    String addedAddressText = addressField.getText();

    //sprawdzenie czy dodany adres jest poprawny
    addedAddressText =addedAddressText.replaceAll("\\s+",""); //usuwam wszystkie spacje z dodanego adresu
    //System.out.println(addedAddressText);

    String expectedAddressText = alias + first_name + last_name + address + city + postal_code + country + phone;
    expectedAddressText =expectedAddressText.replaceAll("\\s+",""); //usuwam wszystkie spacje z oczekiwanego adresu

    // weryfikacja adresów
    assertEquals(expectedAddressText, addedAddressText);
    }
}
