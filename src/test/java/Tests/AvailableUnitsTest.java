package Tests;


/* Test steps:
1. Enter www.aliexpress.com
2. Search for "Iphone"
3. Click on the second result
4. Verify the amount of items available is at least one
*/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AvailableUnitsTest {

    String baseURL = "https://aliexpress.com";

    @Test
    public void availableUnitsTest() {

    //Setting path for windows chrome driver (replace for the folder in your PC)
    System.setProperty("webdriver.chrome.driver","C:\\automation\\MaxiTest\\MaxiTest\\driver\\chromedriver.exe");
    //Creating chrome driver
    WebDriver driver = new ChromeDriver();
    //Maximizing browser window
    driver.manage().window().maximize();
    //Going to AliExpress website
    driver.get(baseURL);


    }
}
