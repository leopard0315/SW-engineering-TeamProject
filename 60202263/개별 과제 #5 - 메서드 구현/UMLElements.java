import java.util.Scanner;

public interface UMLElements {

    public void inputText();
    public void addDiagram();
    public void linkArrow();
    public void linkData();
    public void moveToCode();
}

class UseCaseDiagram implements UMLElements {

    private UseCaseDiagram[] diagram;

    @Override
    public void inputText() {}

    @Override
    public void addDiagram() {}

    @Override
    public void linkArrow() {}

    @Override
    public void linkData() {}

    @Override
    public void moveToCode() {}
}

class ActivityDiagram implements UMLElements {

    private ActivityDiagram[] diagrams;

    @Override
    public void inputText() {}

    @Override
    public void addDiagram() {}

    @Override
    public void linkArrow() {}

    @Override
    public void linkData() {}

    @Override
    public void moveToCode() {}
}

class ClassDiagram implements UMLElements {

    private static final int MAX_DIAGRAMS = 100;
    private String[] classDiagrams = new String[MAX_DIAGRAMS];
    private int diagramCount = 0;

    @Override
    public void inputText() {

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < diagramCount; i++) {

            System.out.println(i + ": " + classDiagrams[i]);
        }

        System.out.print("Choose an index to input text: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < diagramCount) {

            System.out.print("Enter text for diagram " + classDiagrams[index]+ ": ");
            String text = scanner.nextLine();
            System.out.println("Text added to diagram " + classDiagrams[index]+ ": " + text);

            classDiagrams[index] = classDiagrams[index] +" "+text;
        } else {

            System.out.println("Invalid diagram index.");
        }
    }

    @Override
    public void addDiagram() {

        if (diagramCount < MAX_DIAGRAMS) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the class name for the new diagram: ");
            String className = scanner.nextLine();

            classDiagrams[diagramCount] = className;
            diagramCount++;

            System.out.println("New diagram added.");
        } else {

            System.out.println("Maximum number of diagrams reached.");
        }
    }

    @Override
    public void linkArrow() {

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < diagramCount; i++) {

            System.out.println(i + ": " + classDiagrams[i]);
        }

        System.out.println("Choose an index to Link");
        System.out.print("start diagram: ");
        int startDiagramIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.print("end diagram: ");
        int endDiagramIndex = scanner.nextInt();
        scanner.nextLine();

        if (startDiagramIndex >= 0 && startDiagramIndex < diagramCount &&
                endDiagramIndex >= 0 && endDiagramIndex < diagramCount) {
            System.out.println("Arrow linked from diagram " + classDiagrams[startDiagramIndex] +
                    "to diagram " + classDiagrams[endDiagramIndex]);
        } else {
            System.out.println("Invalid diagram index.");
        }
    }

    @Override
    public void linkData() {

        System.out.println("Finding...");

        UMLData umlData = new UMLData(classDiagrams);
        CodeData codeData = new CodeData();
        umlData.findMatchingCode(codeData.getClassName());
    }

    @Override
    public void moveToCode() {

        UMLData umlData = new UMLData(classDiagrams);
        CodeData codeData = new CodeData();
        umlData.findMatchingCode(codeData.getClassName());
        String[] linkingData = umlData.getLinkingData();

        System.out.println("Linked data List");

        for (int i = 0; i < linkingData.length; i++) {
            if (linkingData[i] != null) {
                System.out.println(i + ": " + linkingData[i]);
            }

        }

        UMLCodeLinking umlCodeLinking = new UMLCodeLinking(linkingData);
        umlCodeLinking.moveToCodeScript(linkingData);
    }
}

class StateMachineDiagram implements UMLElements {

    private StateMachineDiagram[] diagram;

    @Override
    public void inputText() {}

    @Override
    public void addDiagram() {}

    @Override
    public void linkArrow() {}

    @Override
    public void linkData() {}

    @Override
    public void moveToCode() {}
}

class SequenceDiagram implements UMLElements {

    private SequenceDiagram[] diagram;

    @Override
    public void inputText() {}

    @Override
    public void addDiagram() {}

    @Override
    public void linkArrow() {}

    @Override
    public void linkData() {}

    @Override
    public void moveToCode() {}
}
