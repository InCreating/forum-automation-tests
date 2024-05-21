package LoginPage;

import com.pages.AuthPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogInTest {
    WebDriver driver;
    public static final String USERNAME = "johndoe@gmail.com";
    public static final String PASS = "12345";
    AuthPage loginPage;

    @BeforeClass
    public void setUp() {
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        loginPage = new AuthPage(driver);
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
        loginPage.setEmail(USERNAME);
        loginPage.setPassword(PASS);
        loginPage.clickFinishLogIn();
    }
}
