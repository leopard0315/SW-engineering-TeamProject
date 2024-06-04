/**
 * 코드 스크립트의 상태를 정의하는 인터페이스 클래스
 */
public interface State {

    /**
     * 스크립트를 사용하는 기능을 정의하는 함수
     */
    public void useScript();

    /**
     * 코드에 접근하는 함수
     */
    public void acessCode();
}
