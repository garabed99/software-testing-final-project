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

import static org.testng.Assert.*;

public class JobApplicationPageTest extends BaseTest {



    @Test
    public void testJobApplication() {
        CareersPage careersPage = homePage.goToCareersPage();
        SelectedCareersPage selectedCareersPage = careersPage.goToSelectedCareersPage();
        JobApplicationPage jobApplicationPage = selectedCareersPage.goToApplyNow();
//        jobApplicationPage.fillFirstName();
        jobApplicationPage.fillLastName();
        jobApplicationPage.fillEmail();
        jobApplicationPage.fillLocation();
        jobApplicationPage.chooseHeardAbout();

        //at every run, they keep switching, so better do manually
        jobApplicationPage.chooseIfOffered();
        jobApplicationPage.chooseAuthorizedToWork();
        jobApplicationPage.choosePrivacyNotice();

        jobApplicationPage.submitApplication();
        assertTrue(jobApplicationPage.checkForFirstNameError().contains("First Name is required."), "first Name entered");
    }
}
