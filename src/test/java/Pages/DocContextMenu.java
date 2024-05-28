package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocContextMenu {
    private WebDriver driver;
    private WebDriverWait wait;

    public DocContextMenu(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@class, 'v-context')]")
    public WebElement contextMenu;
    @FindBy(xpath = "//*[contains(@class, 'v-context')]//*[text()='Удалить ЭД']")
    public WebElement deleteOption;
    @FindBy(xpath = "//*[contains(@class, 'swal2-icon-question')]//*[contains(@class, 'swal2-confirm')]")
    public WebElement submitDeletionButton;
    @FindBy(xpath = "//*[contains(@id, 'swal2-content')]")
    public WebElement waitModal;

    public void callContextMenu() {
        var actions = new Actions(driver);
        actions.contextClick(Desktop.lastSavedDocCdoc).perform();
        wait.until(ExpectedConditions.visibilityOf(contextMenu));
    }

    public void delete(){
        callContextMenu();
        deleteOption.click();
        wait.until(ExpectedConditions.visibilityOf(submitDeletionButton));
        submitDeletionButton.click();
    }

}
