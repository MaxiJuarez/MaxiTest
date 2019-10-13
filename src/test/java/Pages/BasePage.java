package Pages;

import static Tests.BaseTest.wasPopupClosed;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    WebDriver driver;

    @FindBy(xpath = "//h4[text()='NEW TO ALIEXPRESS?']")
    private WebElement newUserText;

    public boolean waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public void explicitWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilUrlContains(String part) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.urlContains(part));
    }

    public void waitUntilDocumentIsReady() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public void scrollToPaginationAndClick(WebElement element) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Scroll all the way down to bottom
        String webHeight = jse.executeScript("return document.body.offsetHeight;").toString();
        jse.executeScript("window.scrollBy(0,"+ webHeight +")", "");
        //Now scroll up 0.5 * viewport size until pagination is visible
        String halfViewportHeight = Integer.toString(driver.manage().window().getSize().getHeight() / 2);
        for(int tries=0 ; tries < 5 ; tries++) {
            jse.executeScript("window.scrollBy(0,-" + halfViewportHeight + ")", "");
            try {
                element.click();
                break;
            } catch (NoSuchElementException | ElementClickInterceptedException e) {
                Thread.sleep(500);
            }
        }
    }

    public void closePopUpIfPresent(WebElement closePopup) {
        if(waitForVisibility(newUserText)) {
            closePopup.click();
            wasPopupClosed = true;
        }
    }

    public void switchToNextTab() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

}
