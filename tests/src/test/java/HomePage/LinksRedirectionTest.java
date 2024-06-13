package HomePage;

import org.assertj.core.api.WithAssertions;
import org.testng.annotations.Test;

public class LinksRedirectionTest extends BaseTestHome implements WithAssertions {
    @Test
    public void redirectLinks() {
        runLoginTest();
        runLinkRedirections();
    }
}
