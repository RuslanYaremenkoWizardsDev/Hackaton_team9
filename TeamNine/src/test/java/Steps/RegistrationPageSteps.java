package Steps;
import Core.Config;
import Core.DriverFactory;
import cucumber.api.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class RegistrationPageSteps extends Steps {

    @Given("^I open registration page$")
    public void iOpenRegistrationPage() {
        log.info("I open reg page");
        DriverFactory.getDriver().get(Config.URL_REGISTRATION);
        DriverFactory.start();
    }

    @When("user fill in required fields with valid data {string} and {string}")
    public void userFillInRequiredFieldsWithValidDataAnd (String login, String password) {
        log.info("User fill in required fields");
        rp.getLoginField().sendKeys(login);
                rp.getPasswordField().sendKeys(password);
                rp.getConfirmPasswordField().sendKeys(password);
        }


    @And("I click the button {string}")
    public void iClickTheButton(String registrate) {
        log.info("click the reg button");
        rp.waitElementAndClick(rp.getRegistrateButton());;
    }


    @Then("^transition to the authorization page$")
    public void transitionToTheAuthorizationPage() {
            log.info("user is registered");
            ap.waitForVisibility(ap.getTitle());
        }


    @When("^user fill in required fields with invalid data (.*) and (.*)$")
    public void userFillInRequiredFieldsWithInvalidDataLoginAndPassword(String login, String password) {
        log.info("user fill in required fields");
        rp.getLoginField().sendKeys(login);
        rp.getPasswordField().sendKeys(password);
        rp.getConfirmPasswordField().sendKeys(password);
    }

    @Then("^error message is displayed$")
    public void errorMessageIsDisplayed() {
        log.info("error message is displayed");
        rp.waitForVisibility(rp.getRegErrorMessage());
       Assertions.assertTrue(rp.getRegErrorMessage().isDisplayed()) ;
    }


    @Then("^I check visually UI that elements are displayed$")
    public void iCheckVisuallyUIThatElementsAreDisplayed() {
        log.info("check UI elements");
        rp.waitForVisibility(rp.getLoginLabel());
        rp.waitForVisibility(rp.getLogoReg());
        rp.waitForVisibility(rp.getTitleReg());
        Assertions.assertEquals(rp.getTitleReg().getText(), "Registration");
        rp.waitForVisibility(rp.getLoginLabel());
        rp.waitForVisibility(rp.getPasswordLabel());
        rp.waitForVisibility(rp.getConfirmLabel());
        rp.waitForVisibility(rp.getLinkToAuth());
        rp.waitForVisibility(rp.getPasswordField());
        rp.waitForVisibility(rp.getConfirmPasswordField());
        rp.waitForVisibility(rp.getLoginField());
        rp.waitForVisibility(rp.getRegistrateButton());

    }
}






