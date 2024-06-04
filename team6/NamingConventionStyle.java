import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamingConventionStyle implements CodeStyleStrategy {
    private String convention;
    private String[] variableNames;

    public NamingConventionStyle(String convention, String[] variableNames) {
        this.convention = convention;
        this.variableNames = variableNames;
    }

    @Override
    public void applyStyle() {
    }

    private boolean isCamelCase(String str) {
        return false;
    }

    private boolean isSnakeCase(String str) {
        return false;
    }

    private boolean isPascalCase(String str) {
        return false;
    }
}
