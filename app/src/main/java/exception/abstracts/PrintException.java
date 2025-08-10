package exception.abstracts;

public abstract class PrintException extends RuntimeException {
    public PrintException(String message) {
        super(message);
    }
}
