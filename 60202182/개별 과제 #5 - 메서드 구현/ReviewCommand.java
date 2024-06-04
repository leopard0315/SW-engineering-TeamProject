/**
 * 코드 리뷰의 기능을 제공하는 커멘드 클래스
 */
public interface ReviewCommand {

    /**
     * 특정 커멘드의 기능을 실행하는 함수
     * @param review
     */
    public void execute(DoCodeReview review);
}
