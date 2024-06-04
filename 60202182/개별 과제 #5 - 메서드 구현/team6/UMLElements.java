/**
 * UML에서 사용하는 기능들을 나타내는 클래스
 * 텍스트 입력, 다이어그램 추가, 화살표 연결 등의 기능을 정의한다.
 */
public interface UMLElements {

    /**
     * 다이어그램에 텍스트를 입력하는 함수
     */
    public void inputText();

    /**
     * 다이어그램을 추가하는 함수
     */
    public void addDiagram();

    /**
     * 화살표를 연결하는 함수
     */
    public void linkArrow();

}

/**
 * 유스케이스 다이어그램의 기능을 나타내는 제품 클래스
 */
class UseCaseDiagram implements UMLElements {

    @Override
    public void inputText() {

    }

    @Override
    public void addDiagram() {

    }

    @Override
    public void linkArrow() {

    }
}

/**
 * 엑티비티 다이어그램의 기능을 나타내는 제품 클래스
 */
class ActivityDiagram implements UMLElements {

    @Override
    public void inputText() {

    }

    @Override
    public void addDiagram() {

    }

    @Override
    public void linkArrow() {

    }
}

/**
 * 클래스 다이어그램의 기능을 나타내는 제품 클래스
 */
class ClassDiagram implements UMLElements {

    @Override
    public void inputText() {

    }

    @Override
    public void addDiagram() {

    }

    @Override
    public void linkArrow() {

    }
}

/**
 * 상태 기계 다이어그램의 기능을 나타내는 제품 클래스
 */
class StateMachineDiagram implements UMLElements {

    @Override
    public void inputText() {

    }

    @Override
    public void addDiagram() {

    }

    @Override
    public void linkArrow() {

    }
}

/**
 * 순차 다이어그램의 기능을 나타내는 제품 클래스
 */
class SequenceDiagram implements UMLElements {

    @Override
    public void inputText() {

    }

    @Override
    public void addDiagram() {

    }

    @Override
    public void linkArrow() {

    }
}
