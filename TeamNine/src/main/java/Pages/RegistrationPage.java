package Pages;

import Core.DriverFactory;
import Interfaces.IRegistrationPage;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Core.DriverFactory.getDriver;

@Getter

    public class RegistrationPage implements IRegistrationPage {

    public RegistrationPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    WebDriverWait wait;

    @FindBy(css = "#login")
    private WebElement loginField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "#confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(css = "#signBtn")
    private WebElement registrateButton;

    @FindBy(css = "#error")
    private WebElement regErrorMessage;

    @FindBy(css = "body > div.bg > div > div > div.auth > div.auth__link")
    private WebElement linkToAuth;

    @FindBy(css = "#title")
    private WebElement titleReg;

    @FindBy(css = "body > div.bg > div > div > div.logo-block > img")
    private WebElement logoReg;

    @FindBy(css = "#logLabel")
    private WebElement loginLabel;

    @FindBy(css = "#passLabel")
    private WebElement passwordLabel;

    @FindBy(css = "#confirmLabel")
    private WebElement confirmLabel;






    public void waitElementAndClick(WebElement element) {
        new WebDriverWait(getDriver(), 120).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForVisibility(WebElement element) {
        new WebDriverWait(getDriver(), 120).until(ExpectedConditions.visibilityOf(element));
    }

    public void regByLogin (WebElement loginField, String login, WebElement passwordField,
                     String password, WebElement confirmPasswordField) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
    }


}



