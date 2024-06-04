/**
 * UML을 생성하는 펙토리 클래스
 */
public abstract class UMLFactory {

    /**
     * UML의 기능을 나타내는 변수
     */
    private UMLElements element;

    /**
     * 다이어그램을 생성하는 함수
     */
    public abstract void createDiagram();

    /**
     * 다이어그램을 삭제하는 함수
     */
    public abstract void removeDiagram();

    /**
     * 다이어그램을 편집하는 함수
     */
    public abstract void editDiagram();

}

/**
 * 유스 케이스 다이어그램의 펙토리 클래스
 */
class UseCaseDiagramFactory extends UMLFactory {
    @Override
    public void createDiagram() {

    }

    @Override
    public void removeDiagram() {

    }

    @Override
    public void editDiagram() {

    }
}

/**
 * 엑티비티 다이어그램의 펙토리 클래스
 */
class ActivityDiagramFactory extends UMLFactory {
    @Override
    public void createDiagram() {

    }

    @Override
    public void removeDiagram() {

    }

    @Override
    public void editDiagram() {

    }
}

/**
 * 클래스 다이어그램의 펙토리 클래스
 */
class ClassDiagramFactory extends UMLFactory {
    @Override
    public void createDiagram() {

    }

    @Override
    public void removeDiagram() {

    }

    @Override
    public void editDiagram() {

    }
}

/**
 * 상태 기계 다이어그램의 펙토리 클래스
 */
class StateMachineDiagramFactory extends UMLFactory {
    @Override
    public void createDiagram() {

    }

    @Override
    public void removeDiagram() {

    }

    @Override
    public void editDiagram() {

    }
}

/**
 * 순차 다이어그램의 펙토리 클래스
 */
class SequenceDiagramFactory extends UMLFactory {
    @Override
    public void createDiagram() {

    }

    @Override
    public void removeDiagram() {

    }

    @Override
    public void editDiagram() {

    }
}

