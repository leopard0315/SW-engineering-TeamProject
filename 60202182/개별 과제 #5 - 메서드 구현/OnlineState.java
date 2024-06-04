/**
 * 온라인 상태일때 기능을 나타내는 상태 클래스
 */
class OnlineState implements State{

    @Override
    public void useScript() {}

    @Override
    public void acessCode() {}
}

/**
 * 오프라인 상태일때 기능을 나타내는 상태 클래스
 */
class OfflineState implements State {

    @Override
    public void useScript() {}

    @Override
    public void acessCode() {}
}

class Context {

    private State state;

    public void setState(State state) {}
}
