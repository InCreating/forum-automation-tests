package TopicPostPage;

import org.assertj.core.api.WithAssertions;
import org.testng.annotations.Test;

public class PostTest extends BaseTopicPost implements WithAssertions {
    @Test
    public void createPost() {
        runLoginTest();
        runCreateNewPost();
    }
}
