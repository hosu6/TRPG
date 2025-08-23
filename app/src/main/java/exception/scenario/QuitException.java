package exception.scenario;

import exception.abstracts.PrintException;

public class QuitException extends PrintException {
    public QuitException(String message) {
        super(message);
    }
}
