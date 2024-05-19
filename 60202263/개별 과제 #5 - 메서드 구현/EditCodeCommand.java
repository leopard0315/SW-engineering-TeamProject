/**
 * 커멘드를 수정하는 클래스
 */
class EditCodeCommand implements ReviewCommand{

    @Override
    public void execute(DoCodeReview review) {}
}

/**
 * 유저의 커멘드를 알리는 클래스
 */
class NotifyUserCommand implements ReviewCommand{

    @Override
    public void execute(DoCodeReview review) {}
}
