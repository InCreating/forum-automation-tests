package TopicPostPage;

import org.assertj.core.api.WithAssertions;
import org.testng.annotations.Test;

public class TopicTest extends BaseTopicPost implements WithAssertions {
    @Test
    public void createTopic() {
        runLoginTest();
        runCreateNewTopic();
    }
}
