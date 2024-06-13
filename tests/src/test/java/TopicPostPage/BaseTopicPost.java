package TopicPostPage;

import LoginPage.BaseTestLogin;
import com.pages.AuthPage;
import com.pages.PostPage;
import com.pages.TopicPage;
import com.utils.WebDriverFactory;
import org.assertj.core.api.WithAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTopicPost extends BaseTestLogin implements WithAssertions {
    protected static WebDriver driver;
    public TopicPage topicPage;
    public PostPage postPage;
    public static final String POST_URL = "https://speakup.lol/createpost?topic=";
    public static final String TOPIC_URL = "https://speakup.lol/createtopic";
    public static final String MAIN_URL = "https://speakup.lol/login";
    public static final String TITLE = "Here is test-tile";
    public static final String TEXT = "Omygarble, whaaaat, it is new text?????";
    public static final String TOPIC_CHECK = "Topic Created!";
    public static final String POST_CHECK = "Post Created!";
    public static final String TOPIC_NAME = "Lol";
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
        topicPage = new TopicPage(driver);
        postPage = new PostPage(driver);
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

    public void runCreateNewTopic() {
        topicPage.pageRedirect(TOPIC_URL);
        topicPage.setTitle(TITLE);
        topicPage.setText(TEXT);
        topicPage.clickDiscard();
        topicPage.setTitle(TITLE);
        topicPage.setText(TEXT);
        topicPage.clickCreate();

        assertThat(topicPage.assertTextExistence())
                .isEqualTo(TOPIC_CHECK);
    }

    public void runCreateNewPost() {
        postPage.pageRedirect(POST_URL);
        postPage.clickTopicList();
        postPage.clickOnTopicByName(TOPIC_NAME);
        postPage.setTitleElement(TITLE);
        postPage.setTextElement(TEXT);
        postPage.clickDiscard();

        postPage.clickTopicList();
        postPage.clickOnTopicByName(TOPIC_NAME);
        postPage.setTitleElement(TITLE);
        postPage.setTextElement(TEXT);
        postPage.clickCreate();

        assertThat(postPage.assertTextExistence())
                .isEqualTo(POST_CHECK);
    }
}
