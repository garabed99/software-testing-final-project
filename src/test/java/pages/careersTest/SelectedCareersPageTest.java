package pages.careersTest;
import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CareersPage;

import java.util.concurrent.TimeUnit;

import static constants.locators.SelectedCareersPageConstants.POSITION_TITLE;
import static org.testng.Assert.assertTrue;

public class SelectedCareersPageTest extends BaseTest {
    private By titleCareer = By.xpath(POSITION_TITLE);

    @Test
    public void testGoToCareersPage() {
        CareersPage careersPage = homePage.goToCareersPage();
        careersPage.selectMarketing();
//        careersPage.selectSanFrancisco();
        careersPage.goToSelectedCareersPage();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assertTrue(driver.findElement(titleCareer).getText().contains("Senior Manager,"), "Not Found");
    }
}