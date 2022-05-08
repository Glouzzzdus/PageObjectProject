package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.apache.maven.shared.utils.StringUtils.split;

public class SearchResultsPage extends BasePage
{
    @FindBy(xpath = "//div[@class='item-prod col-lg-3']")
    private List<WebElement> searchResultsProductsList;
    @FindBy(xpath = "//div[@class='pagination']//a[contains(@class,'btn-see-more')]")
    private WebElement seeMoreButton;
    @FindBy(xpath = "//li[contains(@class,'active')][@data-paginator='2']")
    private WebElement paginatorsLink;
    @FindBy(xpath = "//a[@class='tags__item']")
    private WebElement tagNameOfSearch;
    @FindBy(xpath = "//div[@class='brand-box__title']/a[contains(@href,'ochki')]")
    private WebElement brandBoxChoice;
    @FindBy(xpath = "//div[contains(@class,'js_filter_parent')]//input[contains(@class,'max')]")
    private WebElement maxPriceInput;
    @FindBy(xpath = "//div[contains(@class,'open-filter-tooltip')]//span[contains(@class,'inner')]")
    private WebElement innerButton;
    @FindBy(xpath = "//div[@class='category-top']//select[@class='js-select sort-select js_sort_select select2-hidden-accessible']")
    private WebElement dropDownOfSorting;

    @FindBy(xpath = "//div[@class='item-prod col-lg-3']//div[contains(@class,'prise-new')]")
    private WebElement visiblePriceMaxOfSearchResult;

    public SearchResultsPage(WebDriver driver)
    {
        super(driver);
    }
    public List<WebElement> getSearchResultsList()
    {
        return searchResultsProductsList;
    }
    public int getSearchResultsCount()
    {
        return getSearchResultsList().size();
    }
    public void clickForSeeMorePagesOfResults()
    {
        seeMoreButton.click();
    }
    public WebElement getPaginatorsLink()
    {
        return paginatorsLink;
    }
    public String getTagText()
    {
        return tagNameOfSearch.getText();
    }
    public void getBrandBoxChoise()
    {
        brandBoxChoice.click();
    }
    public void inputMaxSearchedPrice(int MaxPriceOf)
    {
        String MaxPriceOfInString = Integer.toString(MaxPriceOf);
        maxPriceInput.clear();
        maxPriceInput.sendKeys(MaxPriceOfInString, Keys.ENTER);
    }
    public WebElement getInnerButton()
    {
        return innerButton;
    }
    public void sortingMethodChoice(String SortingMethod)
    {
        Select sortObject = new Select(dropDownOfSorting);
        implicitWait(5);
        sortObject.selectByVisibleText(SortingMethod);
    }
    public int getSortingResultOfPrice()
    {
        return Integer.parseInt(visiblePriceMaxOfSearchResult.getText().split(" ")[0]);
    }
}
