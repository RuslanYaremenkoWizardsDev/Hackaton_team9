package Steps;
import Pages.AuthorizationPage;
import Pages.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Steps {
    protected final Logger log = LogManager.getLogger(this.getClass());
    RegistrationPage rp = new RegistrationPage();
    AuthorizationPage ap = new AuthorizationPage();
}