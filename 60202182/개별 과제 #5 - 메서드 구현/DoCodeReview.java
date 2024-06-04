/**
 * 코드 리뷰를 진행 하는 클래스
 */
public class DoCodeReview {

    /**
     * 코드 리뷰를 진행 하는 브렌치
     */
    private String targetBranch;

    /**
     * 코드 리뷰를 진행 하는 코드 리뷰어 유저
     */
    private User reviewer;

    /**
     * 코드 리뷰를 요청 하는 코드 리뷰어 리퀘스 유저
     */
    private User reviewee;

    /**
     * 리뷰를 진행하며 남긴 코멘트 들의 집합
     */
    private String[] reviewComments;

    /**
     * 커맨드 클래스의 기능을 제공하는 객체 변수
     */
    private ReviewCommand command;

    /**
     * 리뷰를 시작하는 함수
     */
    public void startReview(){}

    /**
     * 리뷰를 보내는 함수
     */
    public void sentReview(){}

    /**
     * 커멘드 클래스의 기능을 실행하는 함수
     */
    public void executeCommand(){}

    /**
     * 코멘트를 추가하는 함수
     * @param comment 코드 리뷰어가 작성한 코멘트
     */
    public void addComment(String comment){}
}
