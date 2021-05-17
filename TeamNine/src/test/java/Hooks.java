import Core.Config;
import Core.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class Hooks {
    @BeforeEach
    public void beforeScenario() {
        DriverFactory.start();
    }

    @AfterEach
    public void afterScenario() {
        DriverFactory.quit();
    }
}
