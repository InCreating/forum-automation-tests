package LoginPage;

import com.pages.AuthPage;
import com.utils.WebDriverFactory;
import org.assertj.core.api.WithAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTestLogin implements WithAssertions {
    protected static WebDriver driver;
    public AuthPage loginPage;
    public AuthPage signUpPage;
    public static final String EMAIL ="johndo@gmail.com";
    public static final String PASSWORD = "12345";
    public static final String USERNAME = "tanja";
    public static final String MAIN_URL = "https://speakup.lol/login";
    public static final String HOME_URL = "https://speakup.lol/home";
    public static final String FAIL_MESSAGE_SIGN = "Signup Failed!";

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.get(MAIN_URL);
    }

    @BeforeMethod
    public void initializePages() {
        loginPage = new AuthPage(driver);
        signUpPage = new AuthPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void runLoginTest(){
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickFinishLogIn();

        loginPage.waitForUrlChange(HOME_URL);

        assertThat(loginPage.getCurrentLink()).isEqualTo(HOME_URL);
    }

    public void runSignUpTest(){
        signUpPage.clickSwitchToSignUp();
        signUpPage.setUsername(USERNAME);
        signUpPage.setEmailSignUp(EMAIL);
        signUpPage.setPasswordSignUp(PASSWORD);
        signUpPage.setConfirmPassElement(PASSWORD);
        signUpPage.clickFinishSignUp();
        signUpPage.assertTextExistence();

        assertThat(signUpPage.assertTextExistence())
                .isEqualTo(FAIL_MESSAGE_SIGN);
    }
}
