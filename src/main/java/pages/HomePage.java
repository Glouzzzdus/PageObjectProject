package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;
    @FindBy(xpath = "//button[@class='button-reset search-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,'vis-text')]/p[3]/span")
    private WebElement textBlockContains;
    @FindBy(xpath = "//div[@class='content']/p[4]/span")
    private WebElement textBlockStart;
    @FindBy(xpath = "//div[contains(@class,'top-links__left')]//a[@href='/tradein']")
    private WebElement topLink;
    @FindBy(xpath = "//div[@class='category-items--min ']//a[contains(text(),'Samsung')]")
    private WebElement inCategoryChoice;
    @FindBy(xpath = "//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'game-zone')]")
    private WebElement inSlideBarChoice;

    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    public void searchByKeyword(final String keyWord)
    {
        searchInput.sendKeys(keyWord);
        searchButton.click();
    }
    public String getTextBlockContains()
    {
        return textBlockContains.getText();
    }
    public void getTopLinkChoice()
    {
        topLink.click();
    }
    public boolean getTextBlockStart(String StartString)
    {
        return textBlockStart.getText().startsWith(StartString);
    }
    public void getCategoryChoise()
    {
        inCategoryChoice.click();
    }
    public void getInSlideBarChoice()
    {
        inSlideBarChoice.click();
    }
}
