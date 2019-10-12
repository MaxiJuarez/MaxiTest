package Tests;


/* Test steps:
1. Enter www.aliexpress.com
2. Search for "Iphone"
3. Click on the second result
4. Verify the amount of items available is at least one
*/


import Pages.HomePage;
import Pages.ResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AvailableUnitsTest {

    String baseURL = "https://aliexpress.com";
    String query = "Iphone";
    int pageNumber = 2;

    @Test
    public void availableUnitsTest() throws InterruptedException {

    //Setting path for windows chrome driver (replace with the folder where you downloaded the project in your PC)
    System.setProperty("webdriver.chrome.driver","C:\\automation\\MaxiTest\\MaxiTest\\driver\\chromedriver.exe");
    //Creating chrome driver
    WebDriver driver = new ChromeDriver();
    //Maximizing browser window
    driver.manage().window().maximize();
    //Going to AliExpress website
    driver.get(baseURL);
    HomePage onHome = new HomePage(driver);
    //Will close the "New user" popup if present
    onHome.closePopUpIfPresent();
    //Search for "Iphone"
    ResultsPage onResults = onHome.performSearch(query);
    //Scroll until pagination and click on second page
    onResults.goToPage(2);

    }
}
