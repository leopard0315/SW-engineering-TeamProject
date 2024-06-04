import java.util.List;

public class IndentationStyle implements CodeStyleStrategy {
    private int spaces;
    private List<String> lines;

    public IndentationStyle(int spaces, List<String> lines) {
        this.spaces = spaces;
        this.lines = lines;
    }

    @Override
    public void applyStyle() {
    }

    private String indent(String line) {
        return "";
    }
}
