public abstract class LinkedData {

    public void LinkingData(){}
    public void Changed(){}

}

class UMLData extends LinkedData{

    public void LinkingData(){}
    public void findMatchingCode(){}
    public void modifyUML(){}
}

class CodeData extends LinkedData{

    public void LinkingData(){}
    public void findMatchingUML(){}
    public void modifyCode(){}

}
