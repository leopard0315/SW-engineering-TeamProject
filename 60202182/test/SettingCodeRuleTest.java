import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.*;

class SettingCodeRuleTest {

    private SettingCodeRule settingCodeRule;

    @BeforeEach
    void setUp() {
        settingCodeRule = SettingCodeRule.getInstance();
    }

    // Test 1: Singleton instance
    @Test
    void testSingletonInstance() {
        SettingCodeRule instance1 = SettingCodeRule.getInstance();
        SettingCodeRule instance2 = SettingCodeRule.getInstance();
        assertSame(instance1, instance2, "Instances are not the same");
    }

    // Test 2: Set and apply indentation style
    @Test
    void testSetAndApplyIndentationStyle() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        settingCodeRule.setIndentation(4, List.of("line1", "line2"));

        String output = out.toString();
        assertTrue(output.contains("설정된 들여쓰기: 4 spaces"));
    }

    // Test 3: Set and apply comment style
    @Test
    void testSetAndApplyCommentStyle() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        settingCodeRule.setCommentStyle("singleline", List.of("comment1", "comment2"));

        String output = out.toString();
        assertTrue(output.contains("설정된 주석 스타일: singleline"));
    }

    // Test 4: Save settings to file
    @Test
    void testSaveSettings() throws IOException {
        settingCodeRule.setIndentation(4, List.of("line1", "line2"));
        settingCodeRule.setCommentStyle("singleline", List.of("comment1", "comment2"));
        settingCodeRule.saveSettings();

        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("settings.properties")) {
            properties.load(input);
        }

        assertEquals("4", properties.getProperty("indentation"));
        assertEquals("singleline", properties.getProperty("commentStyle"));
    }

    // Test 5: Load settings from file
    @Test
    void testLoadSettings() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("indentation", "4");
        properties.setProperty("commentStyle", "singleline");
        try (OutputStream output = new FileOutputStream("settings.properties")) {
            properties.store(output, null);
        }

        settingCodeRule.loadSettings();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        settingCodeRule.applyIndentationStyle();
        settingCodeRule.applyCommentStyle();

        String output = out.toString();
        assertTrue(output.contains("설정된 들여쓰기: 4 spaces"));
        assertTrue(output.contains("설정된 주석 스타일: singleline"));
    }
}
