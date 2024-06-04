import java.io.*;
import java.util.HashMap;
import java.util.List;
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

        this.namingConventionStyle = null;
        this.indentationStyle = null;
        this.commentStyle = null;
        this.whitespaceStyle = null;
        this.lineBreakStyle = null;
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
        if (namingConventionStyle != null) {
            namingConventionStyle.applyStyle();
        } else {
            System.out.println("이름 규칙 스타일이 설정되지 않았습니다.");
        }
    }

    // 기본 들여쓰기 스타일 적용 메서드
    public void applyIndentationStyle() {
        if (indentationStyle != null) {
            indentationStyle.applyStyle();
        } else {
            System.out.println("들여쓰기 스타일이 설정되지 않았습니다.");
        }
    }

    // 기본 주석 스타일 적용 메서드
    public void applyCommentStyle() {
        if (commentStyle != null) {
            commentStyle.applyStyle();
        } else {
            System.out.println("주석 스타일이 설정되지 않았습니다.");
        }
    }

    // 기본 공백 스타일 적용 메서드
    public void applyWhitespaceStyle() {
        if (whitespaceStyle != null) {
            whitespaceStyle.applyStyle();
        } else {
            System.out.println("공백 스타일이 설정되지 않았습니다.");
        }
    }

    // 기본 줄바꿈 스타일 적용 메서드
    public void applyLineBreakStyle() {
        if (lineBreakStyle != null) {
            lineBreakStyle.applyStyle();
        } else {
            System.out.println("줄바꿈 스타일이 설정되지 않았습니다.");
        }
    }

    // 들여쓰기 설정 로직
    public void setIndentation(int spaces, List<String> lines) {
        this.indentation = spaces;
        this.indentationStyle = new IndentationStyle(spaces, lines);
        System.out.println("설정된 들여쓰기: " + spaces + " spaces");
        applyIndentationStyle();
    }

    // 주석 스타일 설정 로직
    public void setCommentStyle(String style, List<String> comments) {
        this.commentStyleSetting = style;
        this.commentStyle = new CommentStyle(style, commentFormats, comments);
        System.out.println("설정된 주석 스타일: " + commentStyleSetting);
        applyCommentStyle();
    }

    // 줄바꿈 설정 로직
    public void setLineWrap(String lineWrap, List<String> lines) {
        this.lineWrap = lineWrap;
        this.lineBreakStyle = new LineBreakStyle(lineWrap, lines);
        System.out.println("설정된 줄바꿈: " + lineWrap);
        applyLineBreakStyle();
    }

    // 이름 컨벤션 설정 로직
    public void setNamingConvention(String namingConvention, String[] variableNames) {
        this.namingConvention = namingConvention;
        this.namingConventionStyle = new NamingConventionStyle(namingConvention, variableNames);
        System.out.println("설정된 이름 컨벤션: " + namingConvention);
        applyNamingConventionStyle();
    }

    // 공백 설정 로직
    public void setWhitespaceSetting(boolean removeTrailingSpaces, List<String> lines) {
        this.removeTrailingSpaces = removeTrailingSpaces;
        this.whitespaceStyle = new WhitespaceStyle(removeTrailingSpaces, lines);
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
            setIndentation(Integer.parseInt(properties.getProperty("indentation")), List.of());
            setCommentStyle(properties.getProperty("commentStyle"), List.of());
            setLineWrap(properties.getProperty("lineWrap"), List.of());
            setNamingConvention(properties.getProperty("namingConvention"), new String[]{});
            setWhitespaceSetting(Boolean.parseBoolean(properties.getProperty("removeTrailingSpaces")), List.of());
            System.out.println("설정 로드됨");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
