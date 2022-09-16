package myStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.StoreAddressPage;
import java.time.Duration;

public class Zad1CucumberSteps {

    private WebDriver driver;

    private StoreAddressPage storePage;


    @Given("^An url (.*) opened in browser$")
    public void openUrlInBrowser(String url){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get(url);

        this.storePage = new StoreAddressPage(this.driver);
    }

    @When("Sign In button clicked")
    public void clickSignInC() {
        storePage.clickSignIn();
    }

    @And("^Email (.*) is entered into Email field$")
    public void inputEmailC(String email) {
        storePage.inputEmail(email);
    }

    @And("^Password (.*) is entered into Password field$")
    public void inputPasswordC(String pass) {
        storePage.inputPassword(pass);
    }

    @And("SUBMIT button clicked")
    public void clickSubmitC() {
        storePage.clickSubmit();
    }

    @And("Address link clicked")
    public void clickAddressLinkC() {
        storePage.clickAddressLink();
    }

    @And("Create address clicked")
    public void clickCreateAddressC() {
        storePage.clickCreateAddress();
    }

    @And("^a text (.*) is entered in Alias field$")
    public void inputAliasC(String alias) { storePage.inputAlias(alias);   }

    @And("^a text (.*) is entered in First Name field$")
    public void inputFirstNameC(String first_name) { storePage.inputFirstName(first_name);}

    @And("^a text (.*) is entered in Last Name field$")
    public void inputLastNameC(String last_name) { storePage.inputLastName(last_name);}

    @And("^a text (.*) is entered in Address field$")
    public void inputAddressC(String address) { storePage.inputAddress(address);}

    @And("^a text (.*) is entered in City field$")
    public void inputCityC(String city) { storePage.inputCity(city);}

    @And("^a text (.*) is entered in Zip/Postal Code field$")
    public void inputPostalCodeC(String postal_code) { storePage.inputPostalCode(postal_code);}

    @And("^a text (.*) is entered in Country field$")
    public void inputCountryC(String country) { storePage.inputCountry(country);}

    @And("^a text (.*) is entered in Phone field$")
    public void inputPhoneC(String phone) { storePage.inputPhone(phone);}

    @And("SAVE button clicked")
    public void clickSaveAddressC() {
        storePage.clickSaveAddress();
    }

    @Then("^Message results contain (.*) phrase$")
    public void checkMessageC(String expectedAlertText) { storePage.checkMessage(expectedAlertText);}

    @And("^Added address is equal to: (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) values$")
    public void checkAddedAddressC(String alias, String first_name, String last_name, String address, String city, String postal_code, String country, String phone) {
        storePage.checkAddedAddress(alias,first_name,last_name,address,city,postal_code,country,phone);}

    @And("Quit browser")
    public void quitBrowser() {
        driver.quit();
    }
}

