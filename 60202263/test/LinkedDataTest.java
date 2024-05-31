import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedDataTest {

    private UMLData umlData;
    private CodeData codeData;

    @BeforeEach
    void setUp() {
        // 초기화
        String[] classDiagram = {"Factory", "Facade", "Observer"};
        umlData = new UMLData(classDiagram);
        codeData = new CodeData();
    }

    @Test
    void testFindFactory() {
        String[] classNames = {"Factory"};

        umlData.findMatchingCode(classNames);

        String[] linkedData = umlData.getLinkingData();
        assertNotNull(linkedData[0]);
        assertEquals("Factory", linkedData[0]);
    }

    @Test
    void testFindSingleton() {
        String[] classNames = {"Singleton"};

        umlData.findMatchingCode(classNames);

        String[] linkedData = umlData.getLinkingData();
        assertNull(linkedData[0]);
    }

    @Test
    void testFindNullCode() {
        String[] classNames = {null};

        umlData.findMatchingCode(classNames);

        String[] linkedData = umlData.getLinkingData();
        assertNull(linkedData[0]);
    }

    @Test
    void testFindUMLFactory() {
        String[] classDiagram = {"Factory"};

        codeData.findMatchingUML(classDiagram);

        String[] linkedData = codeData.getLinkingData();
        assertNotNull(linkedData[0]);
        assertNotNull(linkedData[1]);
    }

    @Test
    void testFindAdapter() {
        String[] classDiagram = {"Adapter"};

        codeData.findMatchingUML(classDiagram);

        String[] linkedData = codeData.getLinkingData();
    }

    @Test
    void testFindNullUML() {
        codeData.findMatchingUML(null);

        String[] linkedData = codeData.getLinkingData();
        assertNull(linkedData[0]);
    }
}
