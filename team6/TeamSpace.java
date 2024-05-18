public abstract class TeamSpace implements SystemComponent {

    private SystemComponent[] components;

    public abstract void accessComponent(SystemComponent acess);

    public abstract void settingTeamSpace();
    public abstract void changeRepository();
    public abstract void cloneRepository();
    public abstract void useChatting();
    public abstract void settingMembership();
    public abstract void inviteMember();
    public abstract void accessTool();

}

interface ToolComponent extends SystemComponent{

    public void accessTool();

}

class ManageSystem implements SystemComponent {

    public void settingTeamSpace(){}
    public void changeRepository(){}
    public void cloneRepository(){}
    public void useChatting(){}

}

class MemberSystem implements SystemComponent {

    public void settingMembership(){}
    public void inviteMember(){}

}