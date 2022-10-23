package Exception;


public class InputRangeException extends RuntimeException {
    public InputRangeException() {
        super("잘못된 입력입니다. 다시 입력하세요.");
    }

    public InputRangeException(String message) {
        super(message);
    }
}