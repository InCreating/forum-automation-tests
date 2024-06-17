package CommentPage;

import LoginPage.BaseTestLogin;
import com.pages.AuthPage;
import com.pages.CommentPage;
import com.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseCommentTest extends BaseTestLogin {
    protected static WebDriver driver;
    public CommentPage commentPage;
    public static final String URL_COMMENT = "https://speakup.lol/comments?postid=e4cac28b-ab46-4e67-b5e6-a53c9514c227";
    public static final String TEXT = "Here is text to write yeaaas";
    public static final String TOAST_MESSAGE = "Comment Posted!";
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
        commentPage = new CommentPage(driver);
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

    public void runCommentCreateTest() {
        commentPage.pageRedirect(URL_COMMENT);
        commentPage.setText(TEXT);
        commentPage.sendComment();
        assertThat(commentPage.assertTextExistence())
                .isEqualTo(TOAST_MESSAGE);
    }
}
