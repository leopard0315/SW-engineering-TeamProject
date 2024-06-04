import java.util.List;

public class WhitespaceStyle implements CodeStyleStrategy {
    private boolean removeTrailingSpaces;
    private List<String> lines;

    public WhitespaceStyle(boolean removeTrailingSpaces, List<String> lines) {
        this.removeTrailingSpaces = removeTrailingSpaces;
        this.lines = lines;
    }

    @Override
    public void applyStyle() {
    }

    private String processWhitespace(String line) {
        return "";
    }
}
