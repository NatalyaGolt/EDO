package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FillSvedenyaDdoSKO {

    public static final String comment = "some txt";
    public static final String validEmail = "ukt@ukt.ru";

    public static String docMonth;
    public static String docYear;

    private WebDriver driver;
    private WebDriverWait wait;

    public FillSvedenyaDdoSKO (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@class,'infoDocumentYears')]//span[contains(@class,'multiselect__single')]")
    public WebElement yearField;
    @FindBy(xpath = "//*[contains(@class,'infoDocumentQuarter')]//span[contains(@class,'multiselect__single')]")
    public WebElement periodField;
    @FindBy(xpath = "//*[contains(@class,'executorMail')]//input")
    public WebElement emailField;
    @FindBy(xpath = "//*[contains(@id, 'table-bank')]//*[contains(@class, 'btn mr-2 btn-success')]")
    public WebElement addRowButton;
    @FindBy(xpath = "//*[contains(@role, 'row')]//*[contains(@role, 'cell')][3]")
    public WebElement firstFieldInn;
    @FindBy(xpath = "//*[contains(@role, 'row')]//*[contains(@role, 'cell')][3]//li[1]/span/span")
    public WebElement selectInn;
    @FindBy(xpath = "//*[contains(@role, 'row')]//*[contains(@role, 'cell')][32]//textarea")
    public WebElement thirtyFieldComment;
    @FindBy(xpath = "//*[contains(@id, 'mainButtons')]//li[1]")
    public WebElement backToDocListButton;
    @FindBy(xpath = "//*[contains(@id, 'mainButtons')]//li[4]")
    public WebElement docSaveButton;
    @FindBy(xpath = "//*[contains(@class,'swal2-popup')]")
    public WebElement saveDocumentModalWindow;
//    @FindBy(xpath = "//*[contains(@class,'swal2-loader')]")
//    public WebElement modalWindowLoader;
//    @FindBy(xpath = "//*[contains(@class,'swal2-success')]")
//    public WebElement modalWindowSuccessAction;

    public void fillEmail(){
        emailField.sendKeys(validEmail);
    }
    public void  addRow() {
        addRowButton.click();
    }

    public void  backToDocList() {
        backToDocListButton.click();
    }

    public void  fillSvedenyaDdoSKo() {

        wait.until(ExpectedConditions.visibilityOf(emailField));
        fillEmail();
        addRow();

        wait.until(ExpectedConditions.visibilityOf(firstFieldInn));
        firstFieldInn.click();
        wait.until(ExpectedConditions.visibilityOf(selectInn));
        selectInn.click();

        thirtyFieldComment.sendKeys(comment);
    }

//    public String createdDocCdoc(){
//        return "Сведения о ДДО с КО № 7830002078/" + yearField.getText() + "/" + periodField.getText();
//    }

    public String getDocMonth(){
        return docMonth = periodField.getText();
    }

    public String getDocYear(){
        return docYear = yearField.getText();
    }

//    public static String docCdoc;

    public void docSave() {
//        docCdoc = createdDocCdoc();
        getDocMonth();
        getDocYear();
        docSaveButton.click();
        wait.until(ExpectedConditions.visibilityOf(saveDocumentModalWindow));
        wait.until(ExpectedConditions.invisibilityOf(saveDocumentModalWindow));
//        sleep(2000);
    }

    public void sleep(int i){
        try {
            Thread.sleep(i);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
