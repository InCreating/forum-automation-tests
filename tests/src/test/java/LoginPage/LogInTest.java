package LoginPage;

import org.assertj.core.api.WithAssertions;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest implements WithAssertions {
    @Test
    public void loginChrome() {
        runLoginTest();
    }

    @Test
    public void loginEdge() {
        runLoginTest();
    }
}
