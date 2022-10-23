package Exception;

public class InputEmptyException extends RuntimeException {
    public InputEmptyException() {
        super("잘못된 입력입니다. 다시 입력하세요.");
    }

    public InputEmptyException(String message) {
        super(message);
    }
}