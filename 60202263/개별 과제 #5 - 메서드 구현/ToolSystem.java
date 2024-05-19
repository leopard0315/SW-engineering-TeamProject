import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ToolSystem extends ToolComponent{

    private Map<String, ToolComponent> tool = new HashMap<>();

    public ToolSystem() {

        tool.put("1", new UMLTool());
        tool.put("2", new ScheduleTool());
        tool.put("3", new GraphTool());
        tool.put("4", new DocumentTool());
    }

    public void accessTool(){

        String toolNumber;

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("-------------------");
            System.out.println("|1. UML           |");
            System.out.println("|2. Schedule      |");
            System.out.println("|3. Graph         |");
            System.out.println("|4. Document      |");
            System.out.println("|5. Exit          |");
            System.out.println("-------------------");

            System.out.print("Choose a number to use (or type '5' to quit): ");

            toolNumber = scanner.nextLine();

            if (toolNumber.equalsIgnoreCase("5")) {
                break;
            }
            ToolComponent toolComponent = tool.get(toolNumber);

            if (toolComponent != null) {

                toolComponent.accessTool();
            } else {

                System.out.println("Invalid input");
            }
        }
    }
}

class UMLTool extends ToolComponent{
    @Override
    public void accessTool(){

        String UMLName;

        UMLFactory factory = null;

        UMLElements diagram = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Access UMLTool");

        while(true) {
            System.out.println("------------------");
            System.out.println("|1. UseCase      |");
            System.out.println("|2. Activity     |");
            System.out.println("|3. Class        |");
            System.out.println("|4. StateMachine |");
            System.out.println("|5. Sequence     |");
            System.out.println("|6. Exit         |");
            System.out.println("------------------");

            System.out.print("Choose a number to use (or type '6' to quit): ");

            int choiceUML = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch(choiceUML) {
                case 1:
                    factory = new UMLFactory.UseCaseDiagramFactory();
                    diagram = factory.createDiagram();
                    break;
                case 2:
                    factory = new UMLFactory.ActivityDiagramFactory();
                    diagram = factory.createDiagram();
                    break;
                case 3:
                    factory = new UMLFactory.ClassDiagramFactory();
                    diagram = factory.createDiagram();
                    break;
                case 4:
                    factory = new UMLFactory.StateMachineDiagramFactory();
                    diagram = factory.createDiagram();
                    break;
                case 5:
                    factory = new UMLFactory.SequenceDiagramFactory();
                    diagram = factory.createDiagram();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
                    continue;
            }

            while(true){

                System.out.println("------------------------");
                System.out.println("|1. edit diagram       |");
                System.out.println("|2. remove diagram     |");
                System.out.println("|3. save diagram       |");
                System.out.println("|4. Exit               |");
                System.out.println("------------------------");

                System.out.print("Choose a number to act (or type '4' to quit): ");

                int choiceUMLAct = scanner.nextInt();

                switch(choiceUMLAct) {
                    case 1:

                        factory.editDiagram();
                        continue;
                    case 2:

                        factory.removeDiagram();
                        break;
                    case 3:

                        factory.saveDiagram();
                        continue;
                    case 4:

                        System.out.println("Exiting...");
                        break;
                    default:

                        System.out.println("Invalid input. Please try again.");
                        continue;
                }
                break;
            }
        }
    }
}

class ScheduleTool extends ToolComponent{
    @Override
    public void accessTool() {

        System.out.println("Access ScheduleTool");
    }
}

class GraphTool extends ToolComponent{
    @Override
    public void accessTool() {

        System.out.println("Access GraphTool");
    }
}

class DocumentTool extends ToolComponent {
    @Override
    public void accessTool() {

        System.out.println("Access DocumentTool");
    }
}
