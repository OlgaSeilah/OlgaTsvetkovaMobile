package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;
import utils.DataProviders;

public class NativeMobileTests extends BaseTest {

//    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
//    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
//        getPo().getWelement("signInBtn").click();
//        System.out.println("Simplest Android native test done");
//    }


    @Test(groups = {"native"}, description = "some description",
            dataProviderClass = DataProviders.class, dataProvider = "nativeTestData") //TODO add descr, change testName
    public void hwTest(String email, String name, String password, String expectedTitle) {

        getNativePO().getNativeLoginPage().goToRegistration();
        getNativePO().getNativeRegistrationPage().performRegistration(email, name, password);
        getNativePO().getNativeLoginPage().performLogin(email, password);
        String actualTitle = getNativePO().getNativeBudgetActivityPage().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }


}

