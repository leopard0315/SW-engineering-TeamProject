import javax.tools.Tool;

/**
 * Tool의 단일 객체들을 포함하는 복합 객체 클래스
 */
public abstract class ToolSystem implements ToolComponent{

    /**
     * Tool의 단일 객체들의 집합을 나타내는 배열
     */
    private ToolComponent[] tool;

    /**
     * 특정 도구에 접근하는 함수
     */
    public void accessTool(){}
}

/**
 * UML 도구 단일 객체 클래스
 */
class UMLTool implements ToolComponent{
    @Override
    public void accessTool() {}
}

/**
 * SchedulTool 도구 단일 객체 클래스
 */
class ScheduleTool implements ToolComponent{
    @Override
    public void accessTool() {}
}

/**
 * GraphTool 도구 단일 객체 클래스
 */
class GraphTool implements ToolComponent{
    @Override
    public void accessTool() {}
}

/**
 * DocumentTool 도구 단일 객체 클래스
 */
class DocumentTool implements ToolComponent {
    @Override
    public void accessTool() {}
}
