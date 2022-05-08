package avic_tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchResultsTests extends BaseTest
{
    private static final String SEARCH_TEXT = "технологии";
    private static final String SEARCH_KEYWORD = "Samsung";
    private static final String TEXT_BLOCK_STARTER = "Наши клиенты";
    private static final int EXPECTED_AMOUNT_OF_PRODUCTS = 24;

    @Test
    public void checkThatBlockContainsSearchWord()
    {
        Assert.assertTrue(getHomePage().getTextBlockContains().contains(SEARCH_TEXT));
    }
    @Test
    public void checkThatBlockStartsWithText()
    {
        getHomePage().getTopLinkChoice();
        Assert.assertTrue(getHomePage().getTextBlockStart(TEXT_BLOCK_STARTER));
    }
    @Test
    public void checkElementsAmountOnTwicePage()
    {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getHomePage().implicitWait(30);
        getSearchResultsPage().clickForSeeMorePagesOfResults();
        getSearchResultsPage().waitForPaginatorLinkIsActive(Duration.ofSeconds(300), getSearchResultsPage().getPaginatorsLink());
        Assert.assertEquals(getSearchResultsPage().getSearchResultsCount(), EXPECTED_AMOUNT_OF_PRODUCTS);
    }
    @Test
    public void checkThatFilterResultsContainsCorrectTag()
    {
        getHomePage().getCategoryChoise();
        Assert.assertEquals(getSearchResultsPage().getTagText(),SEARCH_KEYWORD);
    }
}
