package pages.careersTest;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CareersPage;
import static constants.locators.CareersPageConstants.*;
import static org.testng.Assert.*;

public class CareersPageTest extends BaseTest {
    private By remoteLocations = By.xpath(REMOTE_LOCATIONS);


    @Test
    public void checkRemotePosition() {
        CareersPage careersPage = homePage.goToCareersPage();
careersPage.selectMarketing();
        assertTrue(careersPage.isPositionRemote(), "No such position");

    }

}