package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StoreAddressPage {
    private WebDriver driver;

    public StoreAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void appendSearchPhrase(String phraseToSearch) {
        WebElement searchInputBox = this.driver.findElement(By.name("q"));
        searchInputBox.sendKeys(phraseToSearch);
    }

    public void clickSearchIcon() {
        WebElement submitButton = this.driver.findElement(
                By.cssSelector("form[data-testid=mainSearchBar] button[type=submit]")
        );
        submitButton.click();
    }



}
