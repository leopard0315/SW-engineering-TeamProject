import java.util.List;
import java.util.Map;

public class CommentStyle implements CodeStyleStrategy {
    private String style;
    private Map<String, String> commentFormats;
    private List<String> comments;

    public CommentStyle(String style, Map<String, String> commentFormats, List<String> comments) {
        this.style = style;
        this.commentFormats = commentFormats;
        this.comments = comments;
    }

    @Override
    public void applyStyle() {
        System.out.println("적용: 주석 스타일 - " + style);
        String commentFormat = commentFormats.get(style.toLowerCase());
        if (commentFormat == null) {
            throw new IllegalArgumentException("지원되지 않는 주석 스타일: " + style);
        }

        for (String comment : comments) {
            String formattedComment = formatComment(comment, commentFormat);
            System.out.println(formattedComment);
        }
    }

    private String formatComment(String comment, String format) {
        switch (format) {
            case "//":
                return "// " + comment;
            case "/* */":
                return "/* " + comment + " */";
            case "/** */":
                return "/** " + comment + " */";
            default:
                throw new IllegalArgumentException("지원되지 않는 주석 포맷: " + format);
        }
    }
}
