package exception.item;

import exception.abstracts.PrintException;

public class AlreadyEquippedItemException extends PrintException {
    public AlreadyEquippedItemException(String message) {
        super(message);
    }
}
