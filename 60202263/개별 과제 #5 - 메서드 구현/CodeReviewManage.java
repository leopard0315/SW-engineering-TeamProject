public class CodeReviewManage {

    private ReviewState currentState(){
        return null;
    }

    public void reviewReceived() {}
    public void applyReview() {}
    public void rejectReview() {}
    public void changeState(ReviewState newState) {}
}

class PendingReviewState{

    public void reviewCode(CodeReviewManage manager) {}
}

class ApprovedReviewState extends PendingReviewState{

    public void reviewCode(CodeReviewManage manager) {}
}

class RejectedReviewState extends PendingReviewState{

    public void reviewCode(CodeReviewManage manager) {}
}