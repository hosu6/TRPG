package exception.skill;

import exception.abstracts.PrintException;

public class AccessNotExistSkillException extends PrintException {
    public AccessNotExistSkillException(String message) {
        super(message);
    }
}
