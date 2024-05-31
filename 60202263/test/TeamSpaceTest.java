import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

public class TeamSpaceTest {

    @Test
    void testToolComponent() {

        String input1 = "Tool\n5\n";
        System.setIn(new ByteArrayInputStream(input1.getBytes()));

        TeamSpace teamSpace = new TeamSpace();
        teamSpace.accessComponent();
    }

    @Test
    void testManageSystem() {

        String input = "Manage\n5\nexit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TeamSpace teamSpace = new TeamSpace();
        teamSpace.accessComponent();
    }

    @Test
    void testMemberSystem() {

        String input = "Member\nexit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        TeamSpace teamSpace = new TeamSpace();
        teamSpace.accessComponent();
    }

    @Test
    void testInvalidSystemName() {

        String input = "Invalid\nexit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TeamSpace teamSpace = new TeamSpace();
        teamSpace.accessComponent();
    }

    @Test
    void testExitSystem() {

        String input = "exit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TeamSpace teamSpace = new TeamSpace();
        teamSpace.accessComponent();

    }
}
