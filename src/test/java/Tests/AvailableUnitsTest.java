package Tests;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AvailableUnitsTest extends BaseTest {

    /* Test steps:
    1. Enter www.aliexpress.com (A random popop might appear here, close it if it appears)
    2. Search for "Iphone" (A random popop might appear here, close it if it appears)
    3. Go to on the second page of results
    4. Click on the second result (It opens on new tab)
    5. Verify the amount of items available is at least one */

    /// Driver configuration can be changed at BaseTest class - Currently configured for: Windows - Chrome browser ///

    String baseURL = "https://aliexpress.com";

    @Test()
    public void availableUnitsTest() throws InterruptedException {
    String query = "Iphone";

    //Going to AliExpress website
    driver.get(baseURL);
    HomePage onHome = new HomePage(driver);
    //Search for "Iphone"
    ResultsPage onResults = onHome.performSearch(query);
    //Scroll until pagination and click on second page
    onResults.goToNextPage();
    //Click on the second listed product
    ProductDetailsPage onProductDetails = onResults.clickOnSecondItem();
    //Verify if quantity is > 0
    boolean verificationResult = onProductDetails.verifyProductQuantity();
    Assert.assertTrue(verificationResult, "Product doesn't have available items");
    }

}
