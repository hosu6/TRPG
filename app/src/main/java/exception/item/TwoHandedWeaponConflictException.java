package exception.item;

import exception.abstracts.PrintException;

public class TwoHandedWeaponConflictException extends PrintException {
    public TwoHandedWeaponConflictException(String message) {
        super(message);
    }
}
