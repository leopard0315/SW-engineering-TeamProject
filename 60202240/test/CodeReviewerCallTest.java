import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CodeReviewerCallTest {

    private CodeReviewerCall codeReviewerCall;

    @BeforeEach
    void setUp() {
        codeReviewerCall = new CodeReviewerCall();
    }

    // 주어진 스크립트 ID와 리뷰어 ID에 대해 리뷰 요청을 성공적으로 생성하는지 테스트
    @Test
    void testRequestReview() {
        String scriptId = "123";
        String reviewerId = "456";
        boolean isRequested = codeReviewerCall.requestReview(scriptId, reviewerId);
        assertTrue(isRequested, "Review request should be successful");
    }

    // 주어진 스크립트 ID에 대해 리뷰 요청을 성공적으로 취소하는지 테스트
    @Test
    void testCancelReview() {
        String scriptId = "123";
        boolean isCancelled = codeReviewerCall.cancelReview(scriptId);
        assertTrue(isCancelled, "Review request should be cancelled successfully");
    }

    // 주어진 스크립트 ID에 대한 리뷰 상태를 정확하게 반환하는지 테스트
    @Test
    void testGetReviewStatus() {
        String scriptId = "123";
        String status = codeReviewerCall.getReviewStatus(scriptId);
        assertEquals("Pending", status, "Review status should be returned correctly");
    }

    // 주어진 리뷰어 ID에 대해 보류 중인 리뷰 목록을 성공적으로 반환하는지 테스트
    @Test
    void testListPendingReviews() {
        String reviewerId = "456";
        List<String> pendingReviews = codeReviewerCall.listPendingReviews(reviewerId);
        assertNotNull(pendingReviews, "Pending reviews should be listed successfully");
        assertFalse(pendingReviews.isEmpty(), "Pending reviews list should not be empty");
    }

    // 주어진 스크립트 ID에 대해 리뷰를 성공적으로 완료하는지 테스트
    @Test
    void testCompleteReview() {
        String scriptId = "123";
        boolean isCompleted = codeReviewerCall.completeReview(scriptId);
        assertTrue(isCompleted, "Review should be completed successfully");
    }
}
