package pageObjects;

import io.appium.java_client.AppiumDriver;

public class WebPageObject  {

    WebGooglePage webGooglePage;

    public WebPageObject(AppiumDriver appiumDriver) {
        webGooglePage = new WebGooglePage(appiumDriver);
    }

    public WebGooglePage getWebGooglePage() {
        return webGooglePage;
    }
}
