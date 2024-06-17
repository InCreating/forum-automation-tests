package TopicPostPage;

import org.testng.annotations.Test;

public class TopicTest extends BaseTopicPost{
    @Test
    public void createTopic() {
        runLoginTest();
        runCreateNewTopic();
    }
}
