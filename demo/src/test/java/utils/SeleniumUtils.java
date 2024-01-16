package utils;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.NoSuchDriverException;
import org.openqa.selenium.safari.SafariDriver;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.InputStream;
import java.io.FileInputStream;

public class SeleniumUtils {
    public static Browsers getBrowserEnumFromString(String browserString) {
        for (Browsers browser : Browsers.values()) {
            if (browserString.equalsIgnoreCase(browser.toString())) {
                return browser;
            }
        }
        return null;
    }

    public static WebDriver getDriver(String browserString) {
        WebDriver driver = null;

        try {
            switch (Objects.requireNonNull(getBrowserEnumFromString(browserString))) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case IE:
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case SAFARI:
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

            }
        } catch (NoSuchDriverException e) {
            System.out.println("The " + browserString + " browser is not available");
        }
        return driver;
    }

    public static boolean isEmailValid(String email) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        // compile pattern expression to get the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static Properties readProperties(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }
}
