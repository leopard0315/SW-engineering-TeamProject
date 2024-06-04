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
        System.out.println("적용: 줄바꿈 스타일 - " + lineBreak);
        String joinedLines = String.join(getLineBreakCharacter(), lines);
        System.out.println(joinedLines);
    }

    private String getLineBreakCharacter() {
        switch (lineBreak.toLowerCase()) {
            case "unix":
                return "\n";
            case "windows":
                return "\r\n";
            default:
                throw new IllegalArgumentException("지원되지 않는 줄바꿈 스타일: " + lineBreak);
        }
    }
}
