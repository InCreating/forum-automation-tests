package LoginPage;

import com.pages.AuthPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignUpTest {
    WebDriver driver;
    public static final String USERNAME = "tanja";
    public static final String EMAIL = "johndoe@gmail.com";
    public static final String PASS = "12345";
    AuthPage signUpPage;

    @BeforeClass
    public void setUp() {
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        signUpPage = new AuthPage(driver);
        driver.get("https://speakapi.lol/login");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void login() {
        signUpPage.clickSwitchToSignUp();
        signUpPage.setUsername(USERNAME);
        signUpPage.setEmail(EMAIL);
        signUpPage.setPassword(PASS);
        signUpPage.clickFinishSignUp();
    }
}
