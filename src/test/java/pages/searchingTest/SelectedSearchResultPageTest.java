package pages.searchingTest;
import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.SearchResultsPage;
import pages.SelectedSearchResultPage;
import static org.testng.Assert.*;

import static constants.locators.SearchResultsPageConstants.*;
import static constants.locators.SelectedSearchResultPageConstants.*;



public class SelectedSearchResultPageTest extends BaseTest {
    private String validSearchKeyword = VALID_SEARCH_KEYWORD;

    @Test
    public void testArticleRelevancyWithTitle() {
        homePage.search(validSearchKeyword);
        SearchResultsPage searchResultsPage = homePage.goToSearchResultsPage();
        SelectedSearchResultPage selectedSearchResultPage = searchResultsPage.goToSpecificResultPage(1);
        String title = selectedSearchResultPage.getTopicTitle();
        assertTrue(title.contains("reduce"), "wrong");
    }
}
