package exception.common;

import exception.abstracts.PrintException;

public class NotEnoughQuantityException extends PrintException {
    public NotEnoughQuantityException(String message) {
        super(message);
    }
}
