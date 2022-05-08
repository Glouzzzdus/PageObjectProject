package avic_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckMaxPriceTests extends BaseTest
{
    private static final int MAX_PRICE_VALUE = 20000;
    private static final String SORTING_METHOD = "От дорогих к дешевым";

    @Test
    public void checkMaxPriceLimit()
    {
        getHomePage().getInSlideBarChoice();
        getSearchResultsPage().getBrandBoxChoise();
        getSearchResultsPage().waitForPageLoadComplete(Duration.ofSeconds(120));
        getSearchResultsPage().inputMaxSearchedPrice(MAX_PRICE_VALUE);
        getSearchResultsPage().waitForPriceSearchButtonIsVisible(Duration.ofSeconds(60), getSearchResultsPage().getInnerButton());
        getSearchResultsPage().getInnerButton().click();
        getSearchResultsPage().sortingMethodChoice(SORTING_METHOD);
        getSearchResultsPage().waitForPageLoadComplete(Duration.ofSeconds(120));
        Assert.assertTrue(getSearchResultsPage().getSortingResultOfPrice() < MAX_PRICE_VALUE);
    }
}
