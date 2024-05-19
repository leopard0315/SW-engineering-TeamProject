public abstract class LinkedData {

    private String[] linkingData;

    public LinkedData() {

        linkingData = new String[100];
    }

    public void LinkingData(String data){

        for (int i = 0; i < linkingData.length; i++) {

            if (linkingData[i] == null) {

                linkingData[i] = data;
                break;
            }
        }
    }

    public String[] getLinkingData() {

        return linkingData;
    }

    public void Changed(){}

}

class UMLData extends LinkedData{

    private String[] classDiagram;

    public UMLData(String[] classDiagram) {

        this.classDiagram = classDiagram;
    }

    public String[] getClassDiagram() {

        return classDiagram;
    }

    public void findMatchingCode(String[] className) {

        if (classDiagram == null || className == null) {

            System.out.println("Class diagram or class name array is null.");
            return;
        }

        for (String diagram : classDiagram) {

            if (diagram == null) {

                continue; // 다음 루프로 이동
            }

            boolean found = false;

            for (String name : className) {

                if (diagram.equals(name)) {

                    System.out.println("Match found: " + diagram);

                    LinkingData(diagram);
                    found = true;
                }
            }

            if (!found) {

                System.out.println("No match found for class");
            }
        }
    }

    public void modifyUML(){}
}

class CodeData extends LinkedData{

    private String[] className;

    public CodeData() {

        className = new String[5];
        className[0] = "Factory";
        className[1] = "Facade";
        className[2] = "Build";
        className[3] = "Singleton";
        className[4] = "Composite";
    }

    public String[] getClassName() {

        return className;
    }

    public void findMatchingUML(String[] classDiagram){

        for (String name : className) {

            boolean found = false;

            for (String diagram : classDiagram) {

                if (name.equals(name)) {

                    System.out.println("Match found: " + name);
                    LinkingData(name);
                    found = true;
                }
            }

            if (!found) {

                System.out.println("No match found for class");
            }
        }
    }

    public void modifyCode(){}

}
