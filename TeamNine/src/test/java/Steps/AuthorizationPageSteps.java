package Steps;

import Core.Config;
import Core.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AuthorizationPageSteps extends Steps {
    @Given("^I open authorization page$")
    public void iOpenAuthorizationPage() {
        log.info("I open auth page");
        DriverFactory.getDriver().get(Config.URL_AUTHORIZATION);
        DriverFactory.start();
    }


    @When("user fill in required fields with registered data {string} and {string}")
    public void userFillInRequiredFieldsWithRegisteredDataAnd(String login, String password) {
        log.info("User fill in required fields");
        ap.getLoginFieldAuth().sendKeys(login);
        ap.getPasswordFieldAuth().sendKeys(password);
    }

    @And("I click on button {string}")
    public void iClickOnButton(String submit) {
        log.info("click the submit button");
        ap.waitElementAndClick(ap.getSubmitButton());}


    @Then("^transition to the main page$")
    public void transitionToTheMainPage() {
        log.info("user is authorized");
        ap.waitForVisibility(ap.getTournamentTable());
    }

    @When("^user fill in required fields with not registered data (.*) and (.*)$")
    public void userFillInRequiredFieldsWithNotRegisteredDataLoginAndPassword(String login, String password) {
        log.info("user fill in not registered data");
        ap.getLoginFieldAuth().sendKeys(login);
        ap.getPasswordFieldAuth().sendKeys(password);
    }

    @Then("error message is shown")
    public void errorMessageIsShown() {
        log.info("error message is shown");
        rp.waitForVisibility(ap.getAuthErrorMessage());
        Assertions.assertTrue(ap.getAuthErrorMessage().isDisplayed()) ;
    }
}

