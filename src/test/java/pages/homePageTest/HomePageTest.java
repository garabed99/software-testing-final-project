package pages.homePageTest;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static constants.locators.HomePageConstants.*;

import static org.testng.Assert.assertEquals;

public class HomePageTest extends BaseTest {
    private By html = By.xpath(HTML);

    @Test
    public void testTheme() {
        homePage.changeTheme();
        assertEquals("light",driver.findElement(html).getCssValue("color-scheme"), "wrong theme");
    }
}