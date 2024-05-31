import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class ClassDiagramTest {

    private ClassDiagram classDiagram;

    @BeforeEach
    void setUp() {
        classDiagram = new ClassDiagram();
    }

    @Test
    void testAddDiagram() {
        String input = "TestClass\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        classDiagram.addDiagram();

        String output = out.toString();
        assertTrue(output.contains("Enter the class name for the new diagram:"));
        assertTrue(output.contains("New diagram added."));
    }

    @Test
    void testInputText() {
        String addInput = "TestClass\n";
        System.setIn(new ByteArrayInputStream(addInput.getBytes()));
        classDiagram.addDiagram();

        String input = "0\nSomeText\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        classDiagram.inputText();

        String output = out.toString();
        assertTrue(output.contains("Choose an index to input text:"));
        assertTrue(output.contains("Enter text for diagram TestClass:"));
        assertTrue(output.contains("Text added to diagram TestClass: SomeText"));
    }

    @Test
    void testLinkArrow() {
        String diagram1 = "TestClass1\n";
        System.setIn(new ByteArrayInputStream(diagram1.getBytes()));
        classDiagram.addDiagram();

        String diagram2 = "TestClass2\n";
        System.setIn(new ByteArrayInputStream(diagram2.getBytes()));
        classDiagram.addDiagram();

        String start = "0\n1\n";
        System.setIn(new ByteArrayInputStream(start.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        classDiagram.linkArrow();

        String output = out.toString();
        assertTrue(output.contains("Choose an index to Link"));
    }

    @Test
    void testLinkData() {
        String add1 = "Facade\n";
        System.setIn(new ByteArrayInputStream(add1.getBytes()));
        classDiagram.addDiagram();

        String add2 = "Factory\n";
        System.setIn(new ByteArrayInputStream(add2.getBytes()));
        classDiagram.addDiagram();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        classDiagram.linkData();

        String output = out.toString();
        assertTrue(output.contains("Finding..."));
        assertTrue(output.contains("Match found: Factory"));
        assertTrue(output.contains("Match found: Facade"));
    }

    @Test
    void testMoveToCode() {
        String add1 = "Facade\n";
        System.setIn(new ByteArrayInputStream(add1.getBytes()));
        classDiagram.addDiagram();

        String add2 = "Factory\n";
        System.setIn(new ByteArrayInputStream(add2.getBytes()));
        classDiagram.addDiagram();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String link = "0\n";
        System.setIn(new ByteArrayInputStream(link.getBytes()));
        classDiagram.moveToCode();

        String output = out.toString();
        assertTrue(output.contains("Match found: Facade"));
        assertTrue(output.contains("Match found: Factory"));
        assertTrue(output.contains("Linked data List"));
        assertTrue(output.contains("0: Facade"));
        assertTrue(output.contains("1: Factory"));
    }
}
