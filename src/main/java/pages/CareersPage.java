package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static constants.locators.CareersPageConstants.*;

public class CareersPage {
    private WebDriver driver;
    private By team = By.id(TEAM);
    private By marketingTeam = By.xpath(MARKETING_TEAM);
    private By tableBody = By.className(TABLE_BODY);
//    private By sanFrancisco = By.xpath(SAN_FRANCISCO_BAY_AREA);
    private By seniorSoftwareEng = By.xpath(SENIOR_SOFTWARE_ENGINEER);
    private By remoteLocations = By.xpath(REMOTE_LOCATIONS);

    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectMarketing() {
        driver.findElement(team).click();
        driver.findElement(marketingTeam).click();
    }

//    public void selectSanFrancisco() {
//        driver.findElement(location).click();
//        driver.findElement(sanFrancisco).click();
//
//    }

    public SelectedCareersPage goToSelectedCareersPage() {
        driver.findElement(seniorSoftwareEng).click();
        return new SelectedCareersPage(driver);
    }

    public boolean isPositionRemote() {
        List<WebElement> remoteLocations = driver.findElements(tableBody);
        for(WebElement remote : remoteLocations) {
            System.out.println(remote.getText());
            if(!remote.getText().contains("Remote Germany")) {

                return false;
            }
        }
        return true;
    }
}

//*[@id="listings-positions"]/tbody/tr[57]/td[2]
//*[@id="listings-positions"]/tbody/tr[59]/td[2]
//*[@id="listings-positions"]/tbody/tr[60]/td[2]



