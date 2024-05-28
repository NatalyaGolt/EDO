package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewDocumentCreationChoose extends Desktop{

    private final By arrowDocumentationListLocator = By.xpath("//*[@id='createDocModal']//*[contains(@class, 'select2-selection__arrow')]");
    private final By ddoSKoDocumentLocator = By.xpath("//li[text()='Сведения о ДДО с КО']");
    private final By submitDocumentChoiseLocator = By.xpath("//*[@id='createDocModal']//button[@id='upload']");

    public NewDocumentCreationChoose(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void  newDocumentCreationChoose() {
        WebElement shadowHost = driver.findElement(Desktop.shadowHostLocator);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(Desktop.buttonCreationDocumentLocator);
        shadowContent.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(arrowDocumentationListLocator));
        driver.findElement(arrowDocumentationListLocator).click();
    }

    public void svedenyaDdoSKoChooseForCreation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ddoSKoDocumentLocator));
        driver.findElement(ddoSKoDocumentLocator).click();
    }

    public void submitDocumentationChoose() {
        driver.findElement(submitDocumentChoiseLocator).click();
    }

    public void chooseSvedenyaDdoSKoForCreation(){
        newDocumentCreationChoose();
        svedenyaDdoSKoChooseForCreation();
        submitDocumentationChoose();
    }

}
