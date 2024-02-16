import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class creationDdoSKo extends beforeAndAfter {
    private final String urlMainPageEdoTest = "http://172.31.1.149/#/";
    private final String login = "7802047944";
    private final String password = "7802047944";
    private final By buttonEnterLocator = By.xpath("//button[contains(@class,'align-items-center')]");
    private final By loginFieldLocator = By.xpath("//*[contains(@id, 'login-modal')]//*[@id = 'login']");
    private final By passwordFieldLocator = By.xpath("//*[contains(@id, 'login-modal')]//*[@id = 'password']");
    private final By buttonSubmitInLoginModalLocator = By.xpath("//*[contains(@id, 'login-modal')]//button[@type = 'submit']");
    private final By roleSotrudnikPdLocator = By.xpath("//*[contains(@id, 'cabinet-modal')]//option[text()=' Сотрудник поставщика данных ']");
    private final By buttonSubmitInRoleModalLocator = By.xpath("//*[contains(@id, 'cabinet-modal')]//button[contains(@class,'btn-primary')]");
    private final By shadowHostLocator = By.xpath("//left-nav");
    private final By buttonCreationDocumentLocator = By.cssSelector("#createDocumentButton");
    private final By arrowDocumentationListLocator = By.xpath("//*[@id='createDocModal']//*[contains(@class, 'select2-selection__arrow')]");
    private final By ddoSKoDocumentLocator = By.xpath("//li[text()='Сведения о ДДО с КО']");
    private final By submitDocumentChoiseLocator = By.xpath("//*[@id='createDocModal']//button[@id='upload']");
    private final By arrowYearListDdoSKoLocator = By.xpath("//*[contains(@class,'infoDocumentYears')]//*[@class='multiselect__select']");
    private final By year23Locator = By.xpath("//*[contains(@class,'infoDocumentYears')]//span[text()='2023']");

    @Test
    public void test1_MainPage_MenuPages_NamesAreCorrectAndOpened(){

        driver.navigate().to(urlMainPageEdoTest);

        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonEnterLocator));
        driver.findElement(buttonEnterLocator).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginFieldLocator));
        driver.findElement(loginFieldLocator).sendKeys(login);
        driver.findElement(passwordFieldLocator).sendKeys(password);
        driver.findElement(buttonSubmitInLoginModalLocator).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(roleSotrudnikPdLocator));
        driver.findElement(roleSotrudnikPdLocator).click();
        driver.findElement(buttonSubmitInRoleModalLocator).click();

        WebElement shadowHost = driver.findElement(shadowHostLocator);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(buttonCreationDocumentLocator);
        shadowContent.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(arrowDocumentationListLocator));
        driver.findElement(arrowDocumentationListLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ddoSKoDocumentLocator));
        driver.findElement(ddoSKoDocumentLocator).click();
        driver.findElement(submitDocumentChoiseLocator).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(arrowYearListDdoSKoLocator));
        driver.findElement(arrowYearListDdoSKoLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(year23Locator));
        Assert.assertTrue(driver.findElement(year23Locator).isDisplayed(), "2023 год не отображается в списке");
    }
}
