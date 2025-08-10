package exception.item;

import exception.abstracts.PrintException;

public class AccessNotExistItemException extends PrintException {
    public AccessNotExistItemException(String message) {
        super(message);
    }
}
