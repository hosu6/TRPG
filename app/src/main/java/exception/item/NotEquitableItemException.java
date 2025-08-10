package exception.item;

import exception.abstracts.PrintException;

public class NotEquitableItemException extends PrintException {
    public NotEquitableItemException(String message) {
        super(message);
    }
}
