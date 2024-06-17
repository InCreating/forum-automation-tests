package HomePage;

import org.testng.annotations.Test;

public class LinksRedirectionTest extends BaseTestHome {
    @Test
    public void redirectLinks() {
        runLoginTest();
        runLinkRedirections();
    }
}
