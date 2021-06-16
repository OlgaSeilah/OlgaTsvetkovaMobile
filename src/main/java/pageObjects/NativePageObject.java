package pageObjects;

import io.appium.java_client.AppiumDriver;

public class NativePageObject  {
    NativeLoginPage nativeLoginPage;
    NativeRegistrationPage nativeRegistrationPage;
    NativeBudgetActivityPage nativeBudgetActivityPage;

    public NativePageObject(AppiumDriver appiumDriver) {
        nativeLoginPage = new NativeLoginPage(appiumDriver);
        nativeRegistrationPage = new NativeRegistrationPage(appiumDriver);
        nativeBudgetActivityPage = new NativeBudgetActivityPage(appiumDriver);
    }

    public NativeRegistrationPage getNativeRegistrationPage() {
        return nativeRegistrationPage;
    }

    public NativeLoginPage getNativeLoginPage() {
        return nativeLoginPage;
    }

    public NativeBudgetActivityPage getNativeBudgetActivityPage() {
        return nativeBudgetActivityPage;
    }




}
