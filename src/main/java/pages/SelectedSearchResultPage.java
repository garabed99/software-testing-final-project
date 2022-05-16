package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static constants.locators.SelectedSearchResultPageConstants.*;

public class SelectedSearchResultPage {
    private WebDriver driver;
    private By languageBtn = By.xpath(LANGUAGE_BUTTON);
    private By frenchLanguage = By.xpath(FRENCH_LANGUAGE);
    private By topicTitle = By.xpath(TOPIC_TITLE);

    public SelectedSearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTopicTitle() {
        return driver.findElement(topicTitle).getText();
    }

    public void changeLanguageToFrench() {
        driver.findElement(languageBtn).click();
        driver.findElement(frenchLanguage).click();
    }
}
