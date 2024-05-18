public abstract class LinkedMediator {

    public void LinkedContextChanged(LinkedData data){}

    public void moveToCodeScript(UMLData data){}

    public void moveToUMLPage(CodeData data){}

}

class findMatchingCode extends LinkedMediator {

    @Override
    public void moveToCodeScript(UMLData data) {
        super.moveToCodeScript(data);
    }

    @Override
    public void moveToUMLPage(CodeData data) {
        super.moveToUMLPage(data);
    }
}