package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.locators.SelectedCareersPageConstants.*;

public class SelectedCareersPage {
    private WebDriver driver;
    private By positionTitle = By.xpath(POSITION_TITLE);
    private By applyNowBtn = By.xpath(APPLY_NOW);
    private By jobTeam = By.className(JOB_TEAM);

    public SelectedCareersPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getJobTeam() {
        return driver.findElement(jobTeam).getText();
    }

    public JobApplicationPage goToApplyNow() {
        driver.findElement(applyNowBtn).click();
        return new JobApplicationPage(driver);
    }
}
