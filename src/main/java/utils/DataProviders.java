package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public Object[][] nativeTestData() {
        String email = TestDataProps.getTestDataProps().getProperty("email");
        String name = TestDataProps.getTestDataProps().getProperty("name");
        String password = TestDataProps.getTestDataProps().getProperty("password");
        String title = TestDataProps.getTestDataProps().getProperty("title");

        return new Object[][] {
                {email, name, password, title}
        };
    }

    @DataProvider
    public Object[][] webTestData() {
        String url = TestDataProps.getTestDataProps().getProperty("url");
        String wordForSearch = TestDataProps.getTestDataProps().getProperty("wordForSearch");

        return new Object[][]{
                {url, wordForSearch}
        };
    }
}
