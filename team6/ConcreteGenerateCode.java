/**
 * 코드 생성을 위한 구체 클래스 인터페이스.
 */
public interface ConcreteGenerateCode {
    String generate(String data);
}

/**
 * OpenAI 어댑터 클래스.
 */
public class OpenAIAdapter implements ConcreteGenerateCode {
    private OpenAI openAI;

    @Override
    public String generate(String data) {
        return ""; 
    }
}
