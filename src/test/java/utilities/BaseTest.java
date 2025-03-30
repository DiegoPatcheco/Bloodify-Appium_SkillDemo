package utilities;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListeners.class, SuiteListeners.class})
public class BaseTest {
    protected final String smoke = "smoke";
    protected final String regression = "regression";
    protected final CommonFlows commonFlows = new CommonFlows();
    protected final DriverManager driverManager = new DriverManager();

    @BeforeMethod(alwaysRun = true)
    public void masterSetUp() {
        Logs.debug("Initializing driver");
        driverManager.buildDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void masterTearDown() {
        Logs.debug("Killing driver");
        driverManager.killDriver();
    }
}
