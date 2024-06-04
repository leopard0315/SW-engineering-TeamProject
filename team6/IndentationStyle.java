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
        System.out.println("적용: 들여쓰기 스타일 - " + spaces + " spaces");
        for (String line : lines) {
            String indentedLine = indent(line);
            System.out.println(indentedLine);
        }
    }

    private String indent(String line) {
        String spacesString = new String(new char[spaces]).replace('\0', ' ');
        return spacesString + line;
    }
}
