package Pages;

import org.apache.commons.lang3.math.NumberUtils;
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
        //Setting result as false by default
        boolean result = false;
        int cleanValue = 0;
        explicitWait(productQuantityText);
        String totalText = productQuantityText.getText();
        System.out.println("Extracted text from website:" + totalText);
        //Removing non numeric values from String
        String cleanString = totalText.replaceAll("[^0-9]","");
        //Making sure the result is numeric (if response didn't have numbers, we need to fail)
        if (NumberUtils.isNumber(cleanString)) {
            cleanValue = Integer.valueOf(totalText.replaceAll("[^0-9]",""));
        }
        System.out.println("Clean int value to verify:" + cleanValue);
        if(cleanValue > 0) {
            result = true;
        }
        return result;
    }

}
