package exception.common;

import exception.abstracts.PrintException;

public class QuantityUnderZeroException extends PrintException {
    public QuantityUnderZeroException(String message) {
        super(message);
    }
}
