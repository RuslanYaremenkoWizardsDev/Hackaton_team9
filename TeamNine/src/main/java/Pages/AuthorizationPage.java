package Pages;

import Core.DriverFactory;
import Interfaces.IAuthorizationPage;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Core.DriverFactory.getDriver;

@Getter

public class AuthorizationPage implements IAuthorizationPage {
    public AuthorizationPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(css = "body > div.bg > div > div > div.auth > div.auth__header > h1")
    private WebElement title;

    @FindBy(css = "#login")
    private WebElement loginFieldAuth;

    @FindBy(css = "#password")
    private WebElement passwordFieldAuth;

    @FindBy(css = "#signBtn")
    private WebElement submitButton;

    @FindBy(css = "content-tournaments")
    private WebElement tournamentTable;

    @FindBy(css = "#error")
    private WebElement authErrorMessage;

    WebDriverWait wait;

    public void waitElementAndClick(WebElement element) {
        new WebDriverWait(getDriver(), 120).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForVisibility(WebElement element) {
        new WebDriverWait(getDriver(), 120).until(ExpectedConditions.visibilityOf(element));
    }

}
