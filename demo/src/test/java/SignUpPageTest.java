
import org.testng.Assert;
import org.testng.annotations.Test;
import dataProviders.tests.SignUpPageDataProvider;
import utils.SeleniumUtils;

public class SignUpPageTest extends BaseUITest {
    @Test(dataProvider = "signUpPageDataProvider", dataProviderClass = SignUpPageDataProvider.class)
    public void testIfSignUpPageisAvailable(String browserType, boolean exceptedAvailability)
    {
        driver = SeleniumUtils.getDriver(browserType);

        SignUpPage signUpPage= new SignUpPage(driver);
        boolean isPageAvailable = signUpPage.open(pageUnderTestUrl);

        Assert.assertEquals(isPageAvailable, exceptedAvailability);
    }
}