import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SettingCodeRule {
    private static SettingCodeRule instance;

    private CodeStyleStrategy codeStyleStrategy;
    private CodeStyleStrategy namingConventionStyle;
    private CodeStyleStrategy indentationStyle;
    private CodeStyleStrategy commentStyle;
    private CodeStyleStrategy whitespaceStyle;
    private CodeStyleStrategy lineBreakStyle;

    private int indentation;
    private String commentStyleSetting;
    private String lineWrap;
    private String namingConvention;
    private boolean removeTrailingSpaces;
    private Map<String, String> commentFormats;

    private SettingCodeRule() {
        this.commentFormats = new HashMap<>();
        this.commentFormats.put("singleline", "//");
        this.commentFormats.put("multiline", "/* */");
        this.commentFormats.put("javadoc", "/** */");

        this.namingConventionStyle = new NamingConventionStyle("CamelCase");
        this.indentationStyle = new IndentationStyle(4);
        this.commentStyle = new CommentStyle("singleline", commentFormats);
        this.whitespaceStyle = new WhitespaceStyle(true);
        this.lineBreakStyle = new LineBreakStyle("unix");
    }

    public static synchronized SettingCodeRule getInstance() {
        if (instance == null) {
            instance = new SettingCodeRule();
        }
        return instance;
    }

    public void setCodeStyleStrategy(CodeStyleStrategy codeStyleStrategy) {
        this.codeStyleStrategy = codeStyleStrategy;
    }

    public void applyCodeStyle() {
    }

    public void applyNamingConventionStyle() {
    }

    public void applyIndentationStyle() {
    }

    public void applyCommentStyle() {
    }

    public void applyWhitespaceStyle() {
    }

    public void applyLineBreakStyle() {
    }

    public void setIndentation(int spaces) {
        this.indentation = spaces;
        this.indentationStyle = new IndentationStyle(spaces);
        applyIndentationStyle();
    }

    public void setCommentStyle(String style) {
        this.commentStyleSetting = style;
        this.commentStyle = new CommentStyle(style, commentFormats);
        applyCommentStyle();
    }

    public void setLineWrap(String lineWrap) {
        this.lineWrap = lineWrap;
        this.lineBreakStyle = new LineBreakStyle(lineWrap);
        applyLineBreakStyle();
    }

    public void setNamingConvention(String namingConvention) {
        this.namingConvention = namingConvention;
        this.namingConventionStyle = new NamingConventionStyle(namingConvention);
        applyNamingConventionStyle();
    }

    public void setWhitespaceSetting(boolean removeTrailingSpaces) {
        this.removeTrailingSpaces = removeTrailingSpaces;
        this.whitespaceStyle = new WhitespaceStyle(removeTrailingSpaces);
        applyWhitespaceStyle();
    }

    public void saveSettings() {
        Properties properties = new Properties();
        properties.setProperty("indentation", String.valueOf(indentation));
        properties.setProperty("commentStyle", commentStyleSetting);
        properties.setProperty("lineWrap", lineWrap);
        properties.setProperty("namingConvention", namingConvention);
        properties.setProperty("removeTrailingSpaces", String.valueOf(removeTrailingSpaces));

        try (OutputStream output = new FileOutputStream("settings.properties")) {
            properties.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void loadSettings() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("settings.properties")) {
            properties.load(input);
            setIndentation(Integer.parseInt(properties.getProperty("indentation")));
            setCommentStyle(properties.getProperty("commentStyle"));
            setLineWrap(properties.getProperty("lineWrap"));
            setNamingConvention(properties.getProperty("namingConvention"));
            setWhitespaceSetting(Boolean.parseBoolean(properties.getProperty("removeTrailingSpaces")));
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
