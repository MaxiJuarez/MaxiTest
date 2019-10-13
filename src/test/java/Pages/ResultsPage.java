package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import static Tests.BaseTest.wasPopupClosed;


public class ResultsPage extends BasePage {

    @FindBy(css = "a[class='next-dialog-close']")
    private WebElement closePopupButton;

    @FindBy(css = "span[class='logo-base']")
    private WebElement logo;

    @FindBy(css = "div[class='next-pagination-pages']")
    private WebElement pagination;

    @FindBy(css = "button[aria-label^='Next']")
    private WebElement nextPageLink;

    @FindBy(css = "a[class='item-title']")
    private List<WebElement> itemTitles;

    @FindBy(xpath = "(//a[@class='item-title'])[2]")
    private WebElement secondItemTitle;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if(!wasPopupClosed) closePopUpIfPresent(closePopupButton);
    }

    public void goToNextPage() throws InterruptedException {
        explicitWait(itemTitles.get(0));
        String firstItemTitle = itemTitles.get(0).getText();
        scrollToPaginationAndClick(nextPageLink);
        waitUntilPageContentChanged(firstItemTitle);
    }

    public ProductDetailsPage clickOnSecondItem() {
        itemTitles = driver.findElements(By.cssSelector("a[class='item-title']"));
        explicitWait(itemTitles.get(1));
        itemTitles.get(1).click();
        return new ProductDetailsPage(driver);
    }

    public void waitUntilPageContentChanged(String firstItemTitle) throws InterruptedException {
        waitUntilUrlContains("page=2");
        for(int i=0 ;i<10 ; i++) {
            itemTitles = driver.findElements(By.cssSelector("a[class='item-title']"));
            String readItemTitle = itemTitles.get(0).getText();
            if(readItemTitle.equals(firstItemTitle)) {
                Thread.sleep(500);
            } else i=11;
        }
        Thread.sleep(1000);
    }

}