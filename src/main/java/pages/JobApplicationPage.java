package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static constants.locators.JobApplicationPageConstants.*;

public class JobApplicationPage {
    private WebDriver driver;
    private By firstNameInput = By.xpath(FIRST_NAME_INPUT);
    private String firstNameValue = FIRST_NAME;
    private By firstNameError = By.xpath(FIRST_NAME_ERROR);
    private By lastNameInput = By.xpath(LAST_NAME_INPUT);
    private String lastNameValue = LAST_NAME;
    private By emailInput = By.xpath(EMAIL_INPUT);
    private String emailValue = EMAIL;
    private By locationInput = By.xpath(LOCATION_INPUT);
    private String locationValue = LOCATION;
    private By heardAboutOptionBtn = By.xpath(HEARD_ABOUT);
    private String careerSiteOption = CAREER_SITE_OPTION;
    private By ifOffered = By.xpath(IF_OFFERED);
    private By ifOfferedAnswerYes = By.xpath(IF_OFFERED_ANSWER_YES);
    private By authorizedToWork = By.xpath(AUTHORIZED_TO_WORK);
    private By authorizedToWorkYes = By.xpath(AUTHORIZED_TO_WORK_ANSWER_YES);
    private By privacyNotice = By.xpath(PRIVACY_NOTICE);
    private By privacyNoticeYes = By.xpath(PRIVACY_NOTICE_ANSWER_YES);
    private By submitBtn = By.xpath(SUBMIT_BUTTON);

    public JobApplicationPage(WebDriver driver) {
        this.driver = driver;
    }

//    public void fillFirstName() {
//        driver.findElement(firstNameInput).sendKeys(firstNameValue);
//    }
    public void fillLastName() {
        driver.findElement(lastNameInput).sendKeys(lastNameValue);
    }
    public void fillEmail() {
        driver.findElement(emailInput).sendKeys(emailValue);
    }
    public void fillLocation() {
        driver.findElement(locationInput).sendKeys(locationValue);
    }

    public void chooseHeardAbout() {
        driver.findElement(heardAboutOptionBtn).sendKeys(careerSiteOption, Keys.ENTER);;
    }

    public void chooseIfOffered() {
        driver.findElement(ifOffered).click();
        driver.findElement(ifOfferedAnswerYes).click();
    }

    public void chooseAuthorizedToWork() {
        driver.findElement(authorizedToWork).click();
        driver.findElement(authorizedToWorkYes).click();
    }

    public void choosePrivacyNotice() {
        driver.findElement(privacyNotice).click();
        driver.findElement(privacyNoticeYes).click();
    }
    public void submitApplication() {
        WebElement submit = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(submitBtn));
        submit.click();
    }
    public String checkForFirstNameError() {
        return driver.findElement(firstNameError).getText();
    }
}
