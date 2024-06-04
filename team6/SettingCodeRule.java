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

    // private 생성자로 외부 인스턴스 생성을 막음
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

    // 싱글톤 인스턴스 반환 메서드
    public static synchronized SettingCodeRule getInstance() {
        if (instance == null) {
            instance = new SettingCodeRule();
        }
        return instance;
    }

    // 코드 스타일 전략 설정 메서드
    public void setCodeStyleStrategy(CodeStyleStrategy codeStyleStrategy) {
        this.codeStyleStrategy = codeStyleStrategy;
    }

    // 코드 스타일 적용 메서드
    public void applyCodeStyle() {
        if (codeStyleStrategy != null) {
            codeStyleStrategy.applyStyle();
        } else {
            System.out.println("코드 스타일 전략이 설정되지 않았습니다.");
        }
    }

    // 기본 이름 규칙 스타일 적용 메서드
    public void applyNamingConventionStyle() {
        namingConventionStyle.applyStyle();
    }

    // 기본 들여쓰기 스타일 적용 메서드
    public void applyIndentationStyle() {
        indentationStyle.applyStyle();
    }

    // 기본 주석 스타일 적용 메서드
    public void applyCommentStyle() {
        commentStyle.applyStyle();
    }

    // 기본 공백 스타일 적용 메서드
    public void applyWhitespaceStyle() {
        whitespaceStyle.applyStyle();
    }

    // 기본 줄바꿈 스타일 적용 메서드
    public void applyLineBreakStyle() {
        lineBreakStyle.applyStyle();
    }

    // 들여쓰기 설정 로직
    public void setIndentation(int spaces) {
        this.indentation = spaces;
        this.indentationStyle = new IndentationStyle(spaces);
        System.out.println("설정된 들여쓰기: " + spaces + " spaces");
        applyIndentationStyle();
    }

    // 주석 스타일 설정 로직
    public void setCommentStyle(String style) {
        this.commentStyleSetting = style;
        this.commentStyle = new CommentStyle(style, commentFormats);
        System.out.println("설정된 주석 스타일: " + commentStyleSetting);
        applyCommentStyle();
    }

    // 줄바꿈 설정 로직
    public void setLineWrap(String lineWrap) {
        this.lineWrap = lineWrap;
        this.lineBreakStyle = new LineBreakStyle(lineWrap);
        System.out.println("설정된 줄바꿈: " + lineWrap);
        applyLineBreakStyle();
    }

    // 이름 컨벤션 설정 로직
    public void setNamingConvention(String namingConvention) {
        this.namingConvention = namingConvention;
        this.namingConventionStyle = new NamingConventionStyle(namingConvention);
        System.out.println("설정된 이름 컨벤션: " + namingConvention);
        applyNamingConventionStyle();
    }

    // 공백 설정 로직
    public void setWhitespaceSetting(boolean removeTrailingSpaces) {
        this.removeTrailingSpaces = removeTrailingSpaces;
        this.whitespaceStyle = new WhitespaceStyle(removeTrailingSpaces);
        System.out.println("설정된 공백: " + (removeTrailingSpaces ? "Remove trailing spaces" : "Keep trailing spaces"));
        applyWhitespaceStyle();
    }

    // 설정 저장 메서드
    public void saveSettings() {
        Properties properties = new Properties();
        properties.setProperty("indentation", String.valueOf(indentation));
        properties.setProperty("commentStyle", commentStyleSetting);
        properties.setProperty("lineWrap", lineWrap);
        properties.setProperty("namingConvention", namingConvention);
        properties.setProperty("removeTrailingSpaces", String.valueOf(removeTrailingSpaces));
        
        try (OutputStream output = new FileOutputStream("settings.properties")) {
            properties.store(output, null);
            System.out.println("설정 저장됨");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    // 설정 로드 메서드
    public void loadSettings() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("settings.properties")) {
            properties.load(input);
            setIndentation(Integer.parseInt(properties.getProperty("indentation")));
            setCommentStyle(properties.getProperty("commentStyle"));
            setLineWrap(properties.getProperty("lineWrap"));
            setNamingConvention(properties.getProperty("namingConvention"));
            setWhitespaceSetting(Boolean.parseBoolean(properties.getProperty("removeTrailingSpaces")));
            System.out.println("설정 로드됨");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
