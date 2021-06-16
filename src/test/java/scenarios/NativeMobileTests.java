package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;
import utils.DataProviders;

public class NativeMobileTests extends BaseTest {


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

