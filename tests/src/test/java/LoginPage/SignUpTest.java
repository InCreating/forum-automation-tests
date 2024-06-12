package LoginPage;

import org.testng.annotations.Test;

public class SignUpTest extends BaseTestLogin {
    @Test
    public void signUpChrome() {
        runSignUpTest();
    }

    @Test
    public void signUpEdge()  {
        runSignUpTest();
    }
}
