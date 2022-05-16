package pages.fillingJobApplicationTest;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.JobApplicationPage;
import pages.SelectedCareersPage;

import java.util.concurrent.TimeUnit;

import static constants.locators.JobApplicationPageConstants.*;
import static org.testng.Assert.assertEquals;

public class JobApplicationPageTest extends BaseTest {
    private By firstNameError = By.xpath(FIRST_NAME_ERROR);


    @Test
    public void testJobApplication() {
        CareersPage careersPage = homePage.goToCareersPage();
        SelectedCareersPage selectedCareersPage = careersPage.goToSelectedCareersPage();
        JobApplicationPage jobApplicationPage = selectedCareersPage.goToApplyNow();
        jobApplicationPage.fillFirstName();
        jobApplicationPage.fillLastName();
        jobApplicationPage.fillEmail();
        jobApplicationPage.fillLocation();
        jobApplicationPage.chooseHeardAbout();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //at every run, they keep switching, so better do manually
//        jobApplicationPage.chooseIfOffered();
//        jobApplicationPage.chooseAuthorizedToWork();
        jobApplicationPage.choosePrivacyNotice();
        assertEquals(0,driver.findElements(firstNameError).size());
    }
}
