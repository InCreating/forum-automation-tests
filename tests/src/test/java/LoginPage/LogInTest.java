package LoginPage;

import org.assertj.core.api.WithAssertions;
import org.testng.annotations.Test;

public class LogInTest extends BaseTestLogin implements WithAssertions {
    @Test
    public void login() {
        runLoginTest();
    }
}
