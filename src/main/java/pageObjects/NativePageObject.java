package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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
