import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TeamSpace implements SystemComponent {

    private Map<String, SystemComponent> system = new HashMap<>();

    public TeamSpace() {

        system.put("Tool", new ToolSystem());
        system.put("Manage", new ManageSystem());
        system.put("Member", new MemberSystem());
    }

    public void accessComponent(){

        String systemName;
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("--------------------");
            System.out.println("|Tool|Manage|Member|");
            System.out.println("--------------------");

            System.out.print("Enter System Name (or type 'exit' to quit): ");

            systemName = scanner.nextLine();

            if (systemName.equalsIgnoreCase("exit")) {

                break;
            }

            SystemComponent systemComponent = system.get(systemName);

            if (systemComponent != null) {

                systemComponent.accessComponent();
            } else {

                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public void settingTeamSpace(){}
    public void changeRepository(){}
    public void cloneRepository(){}
    public void useChatting(){}
    public void settingMembership(){}
    public void inviteMember(){}
    public void accessTool(){}

}

class ToolComponent implements SystemComponent{

    public void accessTool(){}

    public void accessComponent(){

        System.out.println("\nAccess ToolSystem");

        ToolSystem toolSystem = new ToolSystem();
        toolSystem.accessTool();
    }
}

class ManageSystem implements SystemComponent {

    public void settingTeamSpace(){

        System.out.println("Team Space Setting Page");
    }

    public void changeRepository(){

        System.out.println("Team Space Change Repository");
    }

    public void cloneRepository(){

        System.out.println("Team Space Clone Repository");
    }

    public void useChatting(){

        System.out.println("Team Space Use Chatting");
    }

    @Override
    public void accessComponent() {

        System.out.println("\nAccess ManageSystem");

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("-----------------------");
            System.out.println("|1. setting Teamspace |");
            System.out.println("|2. change Repository |");
            System.out.println("|3. clone Repository  |");
            System.out.println("|4. use Chatting      |");
            System.out.println("|5. Exit              |");
            System.out.println("-----------------------");

            System.out.print("Enter the number of the function to use (or type '5' to quit): ");

            String choice = scanner.nextLine();

            switch(choice) {
                case "1":

                    settingTeamSpace();
                    break;
                case "2":

                    changeRepository();
                    break;
                case "3":

                    cloneRepository();
                    break;
                case "4":

                    useChatting();
                    break;
                case "5":

                    System.out.println("Exiting...");
                    return;
                default:

                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}

class MemberSystem implements SystemComponent {

    public void settingMembership(){

        System.out.println("Member System Setting Page");
    }

    public void inviteMember(){

        System.out.println("Invite Member");
    }

    @Override
    public void accessComponent() {

        System.out.println("\nAccess MemberSystem");

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("----------------------------------");
            System.out.println("|setting Membership|invite Member|");
            System.out.println("----------------------------------");

            System.out.print("Enter the function to use (or type 'exit' to quit): ");

            String functionName = scanner.nextLine();

            if (functionName.equalsIgnoreCase("exit")) {
                break;
            } else if (functionName.equalsIgnoreCase("setting Membership")) {

                settingMembership();
            } else if (functionName.equalsIgnoreCase("invite Member")) {

                inviteMember();
            } else{

                System.out.println("Invalid input");
            }
        }
    }
}