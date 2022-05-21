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
    private String validSearchKeyword = VALID_SEARCH_KEYWORD;
    private String invalidSearchKeyword = INVALID_SEARCH_KEYWORD;


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
        selectedSearchResultPage.firstParagraph();


        assertTrue(selectedSearchResultPage.firstParagraph().contains("La méthode"), "wrong page");
    }

    @Test
    public void testInvalidSearch() {
        homePage.search(invalidSearchKeyword);
        SearchResultsPage searchResultsPage = homePage.goToSearchResultsPage();

        assertTrue(searchResultsPage.getResultNotFound().contains("No document"), "Seems like website found a result");
    }

}