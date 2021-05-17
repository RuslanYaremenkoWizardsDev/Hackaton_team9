package Interfaces;

import org.openqa.selenium.WebElement;

public interface IRegistrationPage extends IPage {
    WebElement getLoginField();
    WebElement getPasswordField();
    WebElement getConfirmPasswordField();
    WebElement getRegistrateButton();
    WebElement getRegErrorMessage();
    WebElement getLinkToAuth();
    WebElement getTitleReg();
    WebElement getLogoReg();
     WebElement getLoginLabel();
    WebElement getPasswordLabel();
    WebElement getConfirmLabel();


    void waitElementAndClick(WebElement element);

    void waitForVisibility(WebElement element);



}
