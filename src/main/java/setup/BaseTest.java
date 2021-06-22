package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageObjects.NativePageObject;
import pageObjects.WebPageObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver; // singleton
    private NativePageObject nativePageObject;
    private WebPageObject webPageObject;


    @Override
    public AppiumDriver getDriver() { return appiumDriver; }

    public WebPageObject getWebPO() {
        return webPageObject;
    }

    public NativePageObject getNativePO() {
        return nativePageObject;
    }

    @Parameters({"platformName", "deviceName", "udid", "browserName","app", "appPackage", "appActivity", "appType", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(@Optional("") String platformName,
                      @Optional("") String deviceName,
                      @Optional("") String udid,
                      @Optional("") String browserName,
                      @Optional("") String app,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String appType,
                      @Optional("") String bundleId
                      ) throws Exception {
        System.out.println("Before: app type - "+appType);
        setAppiumDriver(platformName, deviceName, udid, browserName, app, appPackage, appActivity, appType, bundleId);
        setPageObject(appType, appiumDriver);

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("After" + appiumDriver.getContext());
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName, String deviceName, String udid,
                                 String browserName, String app, String appPackage,
                                 String appActivity, String appType, String bundleId){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName",platformName);
        capabilities.setCapability("deviceName",deviceName);

        if(app.endsWith(".apk")) capabilities.setCapability("app", (new File(app)).getAbsolutePath());

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck","true");

        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        capabilities.setCapability("bundleId", bundleId);
        capabilities.setCapability("udid", udid);

//        try {
            System.out.println(System.getProperty("ts.appium"));
//            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), capabilities);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {

        switch (appType) {
            case "native":
                nativePageObject = new NativePageObject(appiumDriver);
                break;
            case "web":
                webPageObject = new WebPageObject(appiumDriver);
                break;
            default:
                throw new Exception("Can't create a page object for " + appType);
        }
    }


}
