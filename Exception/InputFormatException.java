package Exception;


public class InputFormatException extends RuntimeException {
    public InputFormatException() {
        super("잘못된 입력 형식입니다. 다시 입력하세요.");
    }

    public InputFormatException(String message) {
        super(message);
    }
}
