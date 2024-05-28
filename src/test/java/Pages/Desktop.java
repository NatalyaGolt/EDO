package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Desktop {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Desktop(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    protected static final By shadowHostLocator = By.xpath("//left-nav");
    protected static final By buttonCreationDocumentLocator = By.cssSelector("#createDocumentButton");

    @FindBy(xpath = "//*[contains(@class, 'loadTooltip')]")
    public static WebElement loadDocumentList;
    @FindBy(xpath = "//*[contains(@class, 'tabulator-table')]//div[contains(@class, 'tabulator-row')][1]//*[contains(@class, 'tabulator-cell')][2]")
    public static WebElement lastSavedDocCdoc;

    public void waitForDocListLoading(){
        wait.until(ExpectedConditions.invisibilityOf(Desktop.loadDocumentList));
    }

    public String getLastSavedDocCdoc(){
        return lastSavedDocCdoc.getText();
    }

    public void docCreationAssert(){
        waitForDocListLoading();
        Assert.assertEquals(FillSvedenyaDdoSKO.docCdoc, getLastSavedDocCdoc(), "Последний сохраненный документ не отображается на рабочем столе");
    }

}
