import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LiveCodeScriptTest {

    private LiveCodeScript liveCodeScript;

    @BeforeEach
    void setUp() {
        liveCodeScript = new LiveCodeScript();
    }

    // 스크립트 ID에 해당하는 스크립트를 성공적으로 로드하는지 테스트
    @Test
    void testLoadScript() {
        String scriptId = "123";
        String content = liveCodeScript.loadScript(scriptId);
        assertNotNull(content, "Script should be loaded successfully");
    }

    //주어진 스크립트 ID와 내용을 성공적으로 저장하는지 테스트
    @Test
    void testSaveScript() {
        String scriptId = "123";
        String content = "print('Hello, World!')";
        boolean isSaved = liveCodeScript.saveScript(scriptId, content);
        assertTrue(isSaved, "Script should be saved successfully");
    }
   
    // 주어진 스크립트 ID에 해당하는 스크립트를 성공적으로 실행하는지 테스트
    @Test
    void testExecuteScript() {
        String scriptId = "123";
        String result = liveCodeScript.executeScript(scriptId);
        assertEquals("Execution Successful", result, "Script should execute successfully");
    }

    //주어진 스크립트 ID에 해당하는 스크립트를 성공적으로 삭제하는지 테스트
    @Test
    void testDeleteScript() {
        String scriptId = "123";
        boolean isDeleted = liveCodeScript.deleteScript(scriptId);
        assertTrue(isDeleted, "Script should be deleted successfully");
    }

    // 주어진 스크립트 ID에 해당하는 스크립트를 성공적으로 삭제하는지 테스트
    @Test
    void testGetScriptStatus() {
        String scriptId = "123";
        String status = liveCodeScript.getScriptStatus(scriptId);
        assertEquals("Active", status, "Script status should be returned correctly");
    }
}
