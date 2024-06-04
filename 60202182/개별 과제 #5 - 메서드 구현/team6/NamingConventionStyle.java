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
        System.out.println("적용: 이름 규칙 스타일 - " + convention);

        switch (convention.toLowerCase()) {
            case "camelcase":
                for (String var : variableNames) {
                    if (!isCamelCase(var)) {
                        System.out.println(var + " is not in CamelCase format.");
                    }
                }
                break;
            case "snake_case":
                for (String var : variableNames) {
                    if (!isSnakeCase(var)) {
                        System.out.println(var + " is not in snake_case format.");
                    }
                }
                break;
            case "pascalcase":
                for (String var : variableNames) {
                    if (!isPascalCase(var)) {
                        System.out.println(var + " is not in PascalCase format.");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("지원되지 않는 이름 규칙 스타일: " + convention);
        }
    }

    private boolean isCamelCase(String str) {
        Pattern pattern = Pattern.compile("^[a-z]+([A-Z][a-z0-9]*)*$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private boolean isSnakeCase(String str) {
        Pattern pattern = Pattern.compile("^[a-z]+(_[a-z0-9]+)*$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private boolean isPascalCase(String str) {
        Pattern pattern = Pattern.compile("^[A-Z][a-z0-9]+([A-Z][a-z0-9]*)*$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
