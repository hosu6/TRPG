package exception.scenario;

import exception.abstracts.PrintException;

public class ExitException extends PrintException {
    public ExitException(String message) {
        super(message);
    }
}
