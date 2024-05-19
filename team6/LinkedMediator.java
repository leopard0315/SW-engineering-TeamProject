/**
 * 일치하는 UML데이터와 Code데이터를 포함하는 링킹 데이터를 사용해 UMLCode링킹 기능을 제공하는 클래스
 */
public abstract class LinkedMediator {

    /**
     * 연결된 데이터가 바뀐 경우를 나타내는 함수
     * @param data 링킹 데이터
     */
    public void LinkedContextChanged(LinkedData data){}

    /**
     * UML페이지에서 일치하는 클래스를 포함하는 Code페이지로 이동하는 함수
     * @param data UML데이터를 나타내며 UML데이터와 일치하는 Code데이터를 찾기 위한 매개변수
     */
    public void moveToCodeScript(UMLData data){}

    /**
     * Code페이지에서 일치하는 클래스를 포함하는 UML페이지로 이동하는 함수
     * @param data Code데이터를 나타내며 Code데이터와 일치하는 UML데이터를 찾기 위한 매개변수
     */
    public void moveToUMLPage(CodeData data){}

}

/**
 * LinkedMediator클래스에서 링킹 데이터를 통해 제공되는 기능을 구체화하는 중재자 클래스
 */
class UMLCodeLinking extends LinkedMediator {

    @Override
    public void moveToCodeScript(UMLData data) {
        super.moveToCodeScript(data);
    }

    @Override
    public void moveToUMLPage(CodeData data) {
        super.moveToUMLPage(data);
    }
}