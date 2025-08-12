package exception.item;

import exception.abstracts.PrintException;

public class AccessNotExistItemBoxException extends PrintException {
    public AccessNotExistItemBoxException(String message) {
        super(message);
    }
}
