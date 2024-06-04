import java.util.List;

public class LineBreakStyle implements CodeStyleStrategy {
    private String lineBreak;
    private List<String> lines;

    public LineBreakStyle(String lineBreak, List<String> lines) {
        this.lineBreak = lineBreak;
        this.lines = lines;
    }

    @Override
    public void applyStyle() {
    }

    private String getLineBreakCharacter() {
        return "";
    }
}
