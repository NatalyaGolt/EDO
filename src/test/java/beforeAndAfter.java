import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class beforeAndAfter {
    private static ChromeOptions options = new ChromeOptions();
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static WebElement shadowRoot;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        options.addArguments("start-maximized"); //браузер будет открыт в полный размер экрана
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterTest
    public void tearDown() throws IOException {
        var sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("C:\\!Natalya\\docs\\AISA\\Автотесты\\edoDdoSKO\\TestEvidence.png"));
        driver.quit();
    }

}
