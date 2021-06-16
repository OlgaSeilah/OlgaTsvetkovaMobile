package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import setup.BaseTest;
import utils.DataProviders;

public class WebMobileTests extends BaseTest {

    @Test(groups = {"web"},
            description = "Open Google, find word EPAM, make sure, that answer list is not empty",
            dataProviderClass = DataProviders.class, dataProvider = "webTestData")
    public void testGooglePage(String url, String wordForSearch) {
        getDriver().get(url);
        getWebPO().getWebGooglePage().search(wordForSearch);

        Assert.assertTrue(getWebPO().getWebGooglePage().getSearchResults().size() != 0);
    }

}