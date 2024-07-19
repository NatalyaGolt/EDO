package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BeforeAndAfter {
    
    protected static ChromeOptions options = new ChromeOptions();
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    protected Pages.Autorization edo;
    protected Pages.NewDocumentCreationChoose docChoise;
    protected Pages.FillSvedenyaDdoSKO docFill;
    protected Pages.Desktop doc;
    protected Pages.DocContextMenu docContextMenu;
    protected Pages.DatabaseQuery dbQuery;

    @BeforeTest
    public void setUp(){
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        edo = new Pages.Autorization(driver, wait);
        docChoise = new Pages.NewDocumentCreationChoose(driver, wait);
        docFill = new Pages.FillSvedenyaDdoSKO(driver, wait);
        doc = new Pages.Desktop(driver, wait);
        docContextMenu = new Pages.DocContextMenu(driver, wait);
        dbQuery = new Pages.DatabaseQuery();
    }

    @AfterTest
    public void tearDown() throws IOException {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        String formatedDateTime = current.format(format);

        var sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("./TestEvidence/TestEvidence" + formatedDateTime + ".png"));
        driver.quit();
    }
}
