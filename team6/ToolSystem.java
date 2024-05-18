import javax.tools.Tool;

public abstract class ToolSystem implements ToolComponent{

    private ToolComponent[] tool;
    public void accessTool(){}
}

class UMLTool implements ToolComponent{
    @Override
    public void accessTool() {}
}

class ScheduleTool implements ToolComponent{
    @Override
    public void accessTool() {}
}

class GraphTool implements ToolComponent{
    @Override
    public void accessTool() {}
}

class DocumentTool implements ToolComponent {
    @Override
    public void accessTool() {}
}
