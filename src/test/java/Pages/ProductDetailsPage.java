package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BasePage {

    @FindBy(xpath = "//div[@class='product-quantity-tip']/span")
    private WebElement productQuantityText;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        switchToNextTab();
        waitUntilDocumentIsReady();
    }

    public boolean verifyProductQuantity() {
        explicitWait(productQuantityText);
        String totalText = productQuantityText.getText();
        System.out.println(totalText);
        //changing logic to remove non numeric characters through RE because msg is different when 0 < available items < 10
        int cleanValue = Integer.valueOf(totalText.replaceAll("[^0-9]",""));
        System.out.println(cleanValue);
        if(cleanValue > 0) {
            return true;
        }
        return false;
    }

}
