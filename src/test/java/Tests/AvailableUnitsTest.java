package Tests;


/* Test steps:
1. Enter www.aliexpress.com
2. Search for "Iphone"
3. Click on the second result
4. Verify the amount of items available is at least one
*/


import org.testng.annotations.Test;

public class AvailableUnitsTest {

    @Test
    public void availableUnitsTest() {

    System.setProperty("webdriver.chrome.driver","C:\\automation\\MaxiTest\\MaxiTest\\driver\\chromedriver.exe");

    }
}
