package Interfaces;

import org.openqa.selenium.WebElement;

public interface IAuthorizationPage extends IPage{
    WebElement getLoginFieldAuth();
    WebElement getPasswordFieldAuth();
    WebElement getSubmitButton();
    WebElement getTitle();
    WebElement getTournamentTable();
    WebElement getAuthErrorMessage();

    void waitElementAndClick(WebElement element);

    void waitForVisibility(WebElement element);
}
