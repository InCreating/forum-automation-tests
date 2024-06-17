package SettingPage;

import LoginPage.BaseTestLogin;
import com.pages.AuthPage;
import com.pages.SettingPage;
import com.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseSettingPage extends BaseTestLogin {
    public static final String SET_URL = "https://speakup.lol/settings";
    public static final String USERNAME = "MyUsername";
    public static final String EMAIL = "johndoee@gmail.com";
    public static final String PASSWORD = "12345";
    public static final String USER_TOAST = "Username changed!";
    public static final String EMAIL_TOAST = "Email changed!";
    public static final String PASS_TOAST = "Password changed!";
    public SettingPage settingPage;
    protected static WebDriver driver;
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
        settingPage = new SettingPage(driver);
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

    @Override
    public void runLoginTest() {
        super.runLoginTest();
    }

    public void runUsernameChangeTest() {
        settingPage.pageRedirect(SET_URL);

        settingPage.clickUsernameBtn();

        settingPage.setNewUsername(USERNAME);
        settingPage.clickUsernameSbmBtn();

        assertThat(settingPage.assertTextExistence())
                .isEqualTo(USER_TOAST);
    }

    public void runEmailChangeTest() {
        settingPage.pageRedirect(SET_URL);

        settingPage.clickEmailBtn();
        settingPage.setNewEmail(EMAIL);
        settingPage.clickEmailSbmBtn();

        assertThat(settingPage.assertTextExistence())
                .isEqualTo(EMAIL_TOAST);
    }

    public void runPassChangeTest() {
        settingPage.pageRedirect(SET_URL);

        settingPage.clickPassBtn();
        settingPage.setNewPass(PASSWORD);
        settingPage.setOldPass(PASSWORD);
        settingPage.clickPassSbmBtn();

        assertThat(settingPage.assertTextExistence())
                .isEqualTo(PASS_TOAST);
    }
}
