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
    }

    private String formatComment(String comment, String format) {
        return "";
    }
}
