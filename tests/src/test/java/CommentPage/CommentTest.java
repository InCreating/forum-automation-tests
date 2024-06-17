package CommentPage;

import org.testng.annotations.Test;

public class CommentTest extends BaseCommentTest {
    @Test
    public void createComment() {
        runLoginTest();
        runCommentCreateTest();
    }
}
