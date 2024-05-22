package LoginPage;

import com.pages.AuthPage;
import com.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected static WebDriver driver;
    public AuthPage loginPage;
    public AuthPage signUpPage;
    public static final String EMAIl ="johndoe@gmail.com";
    public static final String PASSWORD = "12345";
    public static final String USERNAME = "tanja";

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://speakup.lol/login");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void runLoginTest() {
        loginPage = new AuthPage(driver);
        loginPage.setEmail(EMAIl);
        loginPage.setPassword(PASSWORD);
        loginPage.clickFinishLogIn();
    }

    public void runSignUpTest() {
        signUpPage = new AuthPage(driver);
        signUpPage.clickSwitchToSignUp();
        signUpPage.setUsername(USERNAME);
        signUpPage.setEmail(EMAIl);
        signUpPage.setPassword(PASSWORD);
        signUpPage.clickFinishSignUp();
    }
}
