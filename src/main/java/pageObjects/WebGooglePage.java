package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebGooglePage {

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchField;

    @FindBy(xpath = "//div[@id='rso']/div")
    private List<WebElement> searchResults;

    public void search(String text) {
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public WebGooglePage(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }


}
