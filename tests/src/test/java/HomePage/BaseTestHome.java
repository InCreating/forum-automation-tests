package HomePage;

import LoginPage.BaseTestLogin;
import com.pages.AuthPage;
import com.pages.HomePage;
import com.utils.WebDriverFactory;
import org.assertj.core.api.WithAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTestHome extends BaseTestLogin implements WithAssertions {
    protected static WebDriver driver;
    public HomePage homePage;
    public static final String MAIN_URL = "https://speakup.lol/login";
    public static final String HOME_URL = "https://speakup.lol/home";
    public static final String POPULAR_URL = "https://speakup.lol/popular";
    public static final String ALL_URL = "https://speakup.lol/all";
    public static final String POST_URL = "https://speakup.lol/createpost?topic=";
    public static final String TOPIC_URL = "https://speakup.lol/createtopic";
    public static final String WELCOME_URL = "https://speakup.lol/welcome";

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
        homePage = new HomePage(driver);
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

    public void runLinkRedirections() {
        homePage.clickPopularLink();
        assertThat(homePage.getCurrentLink())
                .isEqualTo(POPULAR_URL);

        homePage.clickAllLink();
        assertThat(homePage.getCurrentLink())
                .isEqualTo(ALL_URL);

        homePage.clickHomeLink();
        assertThat(homePage.getCurrentLink())
                .isEqualTo(HOME_URL);

        homePage.clickPlusLink();
        assertThat(homePage.checkAddLinksVisibility()).isTrue();
        homePage.clickTopic();
        assertThat(homePage.getCurrentLink())
                .isEqualTo(TOPIC_URL);
        homePage.clickPlusLink();
        homePage.clickPost();
        assertThat(homePage.getCurrentLink())
                .isEqualTo(POST_URL);

        homePage.clickMenuLink();
        assertThat(homePage.checkMenuLinksVisibility()).isTrue();
        homePage.clickSettings();
        homePage.clickTheme();
        homePage.clickLogout();
        assertThat(homePage.getCurrentLink())
                .isEqualTo(WELCOME_URL);
    }
}
