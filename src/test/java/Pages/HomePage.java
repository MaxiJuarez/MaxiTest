package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(id = "search-key")
    private WebElement searchBar;

    @FindBy(css = "input[class='search-button']")
    private WebElement submitSearchButton;

    @FindBy(css = "a[class='close-layer']")
    private WebElement closePopupButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        closePopUpIfPresent(closePopupButton);
    }

    public ResultsPage performSearch(String query) {
        explicitWait(searchBar);
        searchBar.click();
        searchBar.sendKeys(query);
        submitSearchButton.click();
        return new ResultsPage(driver);
    }

}