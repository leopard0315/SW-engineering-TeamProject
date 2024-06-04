/**
* 팀 스페이스의 복합 객체를 나타내며 해당 계층의 단일 객체들의 기능을 포함하는 클래스.
 */
public abstract class TeamSpace implements SystemComponent {

    /**
     * 단일 객체들의 집합을 나타내는 component 배열
     */
    private SystemComponent[] components;

    /**
     * 단일 객체들에 접근하는 함수
     * @param acess 컴포넌트 배열로 단일 객체에 접근하는 매개변수
     */
    public abstract void accessComponent(SystemComponent acess);

    /**
     * ManageSystem에서 사용하는 팀 스페이스 설정을 하는 함수
     */
    public abstract void settingTeamSpace();

    /**
     * ManageSystem에서 사용하는 저장소를 바꾸는 함수
     */
    public abstract void changeRepository();

    /**
     * ManageSystem에서 사용하는 저장소를 복제하는 함수
     */
    public abstract void cloneRepository();

    /**
     * ManageSystem에서 사용하는 채팅을 사용하는 함수
     */
    public abstract void useChatting();

    /**
     * MemberSystem에서 사용하는 멤버 설정을 하는 함수
     */
    public abstract void settingMembership();

    /**
     * MemberSystem에서 사용하는 멤버를 초대하는 함수
     */
    public abstract void inviteMember();

    /**
     * ToolSystem에서 사용하는 도구에 접근하는 함수
     */
    public abstract void accessTool();

}

/**
* Tool의 단일 객체들을 포함하는 복합 객체 클래스
 */
interface ToolComponent extends SystemComponent{

    /**
     * 특정 도구에 접근하는 함수
     */
    public void accessTool();

}

/**
 * ManageSystem의 기능을 포함하는 단일 객체 클래스
 */
class ManageSystem implements SystemComponent {

    public void settingTeamSpace(){}
    public void changeRepository(){}
    public void cloneRepository(){}
    public void useChatting(){}

}

/**
 * MemberSystem의 기능을 포함하는 단일 객체 클래스
 */
class MemberSystem implements SystemComponent {

    public void settingMembership(){}
    public void inviteMember(){}

}