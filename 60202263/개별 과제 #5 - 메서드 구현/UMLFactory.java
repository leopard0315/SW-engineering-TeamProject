import java.util.Scanner;

public abstract class UMLFactory {

    protected UMLElements diagram;

    public abstract UMLElements createDiagram();

    public void editDiagram() {

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("--------------------------------");
            System.out.println("|1. Input Text                 |");
            System.out.println("|2. Add Diagram Element        |");
            System.out.println("|3. Link Arrows                |");
            System.out.println("|4. Link Data                  |");
            System.out.println("|5. Move to linked Code        |");
            System.out.println("|6. Exit                       |");
            System.out.println("--------------------------------");

            System.out.print("Choose a number to act (or type '6' to quit): ");

            String choice = scanner.nextLine();

            switch(choice) {
                case "1":

                    diagram.inputText();
                    break;
                case "2":

                    diagram.addDiagram();
                    break;
                case "3":

                    diagram.linkArrow();
                    break;
                case "4":

                    diagram.linkData();
                    return;
                case "5":

                    diagram.moveToCode();
                    return;
                case "6":

                    System.out.println("Exiting...");
                    return;
                default:

                    System.out.println("Invalid input. Please try again.");
                    continue;
            }
        }
    }

    public void removeDiagram(){

        System.out.println("Removing " + diagram.getClass().getSimpleName());

        if (diagram != null) {
            diagram = null;
        }
    }

    public void saveDiagram() {

        System.out.println("Saving " + diagram.getClass().getSimpleName());
    }

    static class UseCaseDiagramFactory extends UMLFactory {
        @Override
        public UMLElements createDiagram() {

            System.out.println("Creating Use Case Diagram");

            diagram = new UseCaseDiagram();
            return diagram;
        }
    }

    static class ActivityDiagramFactory extends UMLFactory {
        @Override
        public UMLElements createDiagram() {

            System.out.println("Creating Activity Diagram");

            diagram = new ActivityDiagram();
            return diagram;
        }
    }

    static class ClassDiagramFactory extends UMLFactory {
        @Override
        public UMLElements createDiagram() {

            System.out.println("Creating Class Diagram");

            diagram = new ClassDiagram();
            return diagram;
        }
    }

    static class StateMachineDiagramFactory extends UMLFactory {
        @Override
        public UMLElements createDiagram() {

            System.out.println("Creating State Machine Diagram");

            diagram = new StateMachineDiagram();
            return diagram;
        }
    }

    static class SequenceDiagramFactory extends UMLFactory {
        @Override
        public UMLElements createDiagram() {

            System.out.println("Creating Sequence Diagram");

            diagram = new SequenceDiagram();
            return diagram;
        }
    }
}

