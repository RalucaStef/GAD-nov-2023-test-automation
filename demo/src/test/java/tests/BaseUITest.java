package tests;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import tests.utils.SeleniumUtils;

import java.util.Properties;

public class BaseUITest {
    WebDriver driver;

    String url;

    String path;

    String browser;

    String pageUnderTestUrl;

    @BeforeClass
    public void setup() throws IOException
    {
        Properties properties = SeleniumUtils.readProperties("src\\test\\resources\\application.properties");
        url = properties.getProperty("url");
        path = properties.getProperty("path");
        pageUnderTestUrl = url + path;

        browser = properties.getProperty("browser");

        System.out.println("Browser: " + browser);
        System.out.println("Page under test: " + pageUnderTestUrl);
    }

    @AfterClass

    public void close()
    {
        // if(driver != null)
        // {
        //     driver.quit();
        // }
    }
}
