package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import utilities.FileManager;
import utilities.Logs;

public class SuiteListeners implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        Logs.info("on suite start");
        FileManager.deletePreviousEvidence();
    }

    @Override
    public void onFinish(ISuite suite) {
        Logs.info("on suite finish");
    }
}
