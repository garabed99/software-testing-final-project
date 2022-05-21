package pages.careersTest;
import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.SelectedCareersPage;

import java.util.concurrent.TimeUnit;

import static constants.locators.SelectedCareersPageConstants.POSITION_TITLE;
import static org.testng.Assert.assertTrue;

public class SelectedCareersPageTest extends BaseTest {
    private By titleCareer = By.xpath(POSITION_TITLE);

    @Test
    public void testGoToCareersPage() {
        CareersPage careersPage = homePage.goToCareersPage();
        careersPage.selectMarketing();
        SelectedCareersPage selectedCareersPage = careersPage.goToSelectedCareersPage();

        assertTrue(selectedCareersPage.getJobTeam().contains("Marketing"), "Not Found");
    }
}