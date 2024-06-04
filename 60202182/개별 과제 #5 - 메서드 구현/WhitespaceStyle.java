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
        System.out.println("적용: 공백 스타일 - " + (removeTrailingSpaces ? "Remove trailing spaces" : "Keep trailing spaces"));
        for (String line : lines) {
            String processedLine = processWhitespace(line);
            System.out.println(processedLine);
        }
    }

    private String processWhitespace(String line) {
        if (removeTrailingSpaces) {
            return line.stripTrailing();
        } else {
            return line;
        }
    }
}
