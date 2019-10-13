package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;
    public static boolean wasPopupClosed = false;

    @BeforeMethod
    public void createDriver() {

        //Change folder and driver type here if you will execute this on Mac or another browser

        //Setting path for windows chrome driver (replace with the folder where you downloaded the project in your PC)
        System.setProperty("webdriver.chrome.driver","C:\\automation\\MaxiTest\\MaxiTest\\driver\\chromedriver.exe");
        //Creating chrome driver
        driver = new ChromeDriver();
        //Maximizing browser window
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeDriver() {
        //Killing driver
        driver.quit();
    }
}
