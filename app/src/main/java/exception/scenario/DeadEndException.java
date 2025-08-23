package exception.scenario;

import exception.abstracts.PrintException;

public class DeadEndException extends PrintException {
    public DeadEndException(String message) {
        super(message);
    }
}
