package TopicPostPage;

import org.testng.annotations.Test;

public class PostTest extends BaseTopicPost{
    @Test
    public void createPost() {
        runLoginTest();
        runCreateNewPost();
    }
}
