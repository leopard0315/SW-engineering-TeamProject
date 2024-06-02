import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoCodeReviewTest {

    private DoCodeReview doCodeReview;

    @BeforeEach
    void setUp() {
        doCodeReview = new DoCodeReview();
    }

    // 주어진 스크립트 ID에 대해 리뷰를 성공적으로 시작하는지 테스트
    @Test
    void testStartReview() {
        String scriptId = "123";
        boolean isStarted = doCodeReview.startReview(scriptId);
        assertTrue(isStarted, "Review should be started successfully");
    }

    // 주어진 스크립트 ID에 대해 코멘트를 성공적으로 추가하는지 테스트
    @Test
    void testAddComment() {
        String scriptId = "123";
        String comment = "N번째 줄 코드 수정 필요!";
        boolean isCommentAdded = doCodeReview.addComment(scriptId, comment);
        assertTrue(isCommentAdded, "Comment should be added successfully");
    }

    // 주어진 스크립트 ID에 대해 리뷰를 성공적으로 제출하는지 테스트
    @Test
    void testSubmitReview() {
        String scriptId = "123";
        boolean isSubmitted = doCodeReview.submitReview(scriptId);
        assertTrue(isSubmitted, "Review should be submitted successfully");
    }

    // 주어진 스크립트 ID에 대해 리뷰를 성공적으로 거절하는지 테스트
    @Test
    void testRejectReview() {
        String scriptId = "123";
        boolean isRejected = doCodeReview.rejectReview(scriptId);
        assertTrue(isRejected, "Review should be rejected successfully");
    }

    // 주어진 스크립트 ID에 대해 리뷰 코멘트를 성공적으로 반환하는 지 테스트
    @Test
    void testGetReviewComments() {
        String scriptId = "123";
        List<String> comments = doCodeReview.getReviewComments(scriptId);
        assertNotNull(comments, "Comments should be retrieved successfully");
        assertFalse(comments.isEmpty(), "Comments list should not be empty");
    }
}
