package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Autorization {

    private WebDriver driver;
    private WebDriverWait wait;

    public Autorization(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
    protected String urlMainPageEdoTest = "http://10.241.2.242/#/";

    public void open(){
        driver.navigate().to(urlMainPageEdoTest);
    }

    protected String login = "7830002078";
    protected String password = "7830002078";
    @FindBy(xpath = "//button[contains(@class,'align-items-center')]")
    public WebElement buttonEnter;
    @FindBy(xpath = "//*[contains(@id, 'login-modal')]//*[@id = 'login']")
    public WebElement loginField;
    @FindBy(xpath = "//*[contains(@id, 'login-modal')]//*[@id = 'password']")
    public WebElement passwordField;
    @FindBy(xpath = "//*[contains(@id, 'login-modal')]//button[@type = 'submit']")
    public WebElement buttonSubmitInLoginModal;
    @FindBy(xpath = "//*[contains(@id, 'cabinet-modal')]//option[text()=' Сотрудник поставщика данных ']")
    public WebElement roleSotrudnikPd;
    @FindBy(xpath = "//*[contains(@id, 'cabinet-modal')]//button[contains(@class,'btn-primary')]")
    public WebElement buttonSubmitInRoleModal;

    public void autorization(){

        open();

        wait.until(ExpectedConditions.visibilityOf(buttonEnter));
        buttonEnter.click();

        wait.until(ExpectedConditions.visibilityOf(loginField));
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        buttonSubmitInLoginModal.click();

        wait.until(ExpectedConditions.visibilityOf(roleSotrudnikPd));
        roleSotrudnikPd.click();
        buttonSubmitInRoleModal.click();

    }
}
