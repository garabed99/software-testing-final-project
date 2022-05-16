package pages.searchingTest;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.SearchResultsPage;
import pages.SelectedSearchResultPage;

import static constants.locators.SearchResultsPageConstants.*;
import static constants.locators.SelectedSearchResultPageConstants.FIRST_SENTENCE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchResultsPageTest extends BaseTest {
    private By firstResult = By.xpath(FIRST_RESULT);
    private String validSearchKeyword = VALID_SEARCH_KEYWORD;
    private String invalidSearchKeyword = INVALID_SEARCH_KEYWORD;
    private By resultsNotFound = By.xpath(RESULTS_NOT_FOUND);
    private By firstParagraph = By.xpath(FIRST_SENTENCE);

    @Test
    public void testAccuracyOfSearch() {
        homePage.search(validSearchKeyword);
        SearchResultsPage searchResultsPage = homePage.goToSearchResultsPage();
        int result = searchResultsPage.numberOfRelevantAnswers();
        assertEquals(4, result, "not accurate");
    }



    @Test
    public void testValidSearch() {
        homePage.search(validSearchKeyword);
        SearchResultsPage searchResultsPage = homePage.goToSearchResultsPage();
        SelectedSearchResultPage selectedSearchResultPage = searchResultsPage.getFirstSearchedResult();
        selectedSearchResultPage.changeLanguageToFrench();
        WebElement paragraphCheck = new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(firstParagraph));

        assertTrue(paragraphCheck.getText().contains("La méthode"), "wrong page");
    }

    @Test
    public void testInvalidSearch() {
        homePage.search(invalidSearchKeyword);
        SearchResultsPage searchResultsPage = homePage.goToSearchResultsPage();
        searchResultsPage.getResultNotFound();
        WebElement resultCheck = new WebDriverWait(driver, 6)
                .until(ExpectedConditions.presenceOfElementLocated(resultsNotFound));
        assertTrue(resultCheck.getText().contains("Found 0 matches"), "Seems like website found a result");
    }

}