/**
 * UML데이터와 Code데이터를 연결하여 링킹 데이터를 저장하고 중재자 클래스에 전달하는 클래스
 */
public abstract class LinkedData {

    /**
     * 링킹 데이터를 저장하는 생성 클래스 함수
     */
    public void LinkingData(){}

    /**
     * 바뀐 내용을 적용하는 함수
     */
    public void Changed(){}

}

/**
 * UML데이터를 정의하고 해당 클래스에서 일치하는 Code데이터를 연결하는 클래스
 */
class UMLData extends LinkedData{

    public void LinkingData(){}

    /**
     * UML데이터와 일치하는 Code데이터를 찾는 함수
     */
    public void findMatchingCode(){}

    /**
     * UML데이터를 수정하는 함수
     */
    public void modifyUML(){}
}

/**
 * Code데이터를 정의하고 해당 클래스에서 일치하는 UML데이터를 연결하는 클래스
 */
class CodeData extends LinkedData{

    public void LinkingData(){}

    /**
     * Code데이터와 일치하는 UML데이터를 찾는 함수
     */
    public void findMatchingUML(){}

    /**
     * Code데이터를 수정하는 함수
     */
    public void modifyCode(){}

}
