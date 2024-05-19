import java.util.Scanner;

public abstract class LinkedMediator {

    private String[] linkingData;

    private LinkedData linkedData;

    public LinkedMediator(String[] linkingData) {

        this.linkingData = linkingData;
    }

    public void LinkedContextChanged(String[] data){}

    public void moveToCodeScript(String[] data){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose an index to move to code script: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < data.length && data[index] != null) {

            System.out.println("Moving to code script for: " + data[index]);
        } else {

            System.out.println("Invalid index selected.");
        }
    }

    public void moveToUMLPage(String[] data){}

}

class UMLCodeLinking extends LinkedMediator {

    public UMLCodeLinking(String[] linkingData) {

        super(linkingData);
    }

    @Override
    public void moveToCodeScript(String[] data) {

        super.moveToCodeScript(data);
    }

    @Override
    public void moveToUMLPage(String[] data) {

        super.moveToUMLPage(data);
    }
}