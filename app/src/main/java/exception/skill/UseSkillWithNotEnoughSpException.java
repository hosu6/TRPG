package exception.skill;

import exception.abstracts.PrintException;

public class UseSkillWithNotEnoughSpException extends PrintException {
    public UseSkillWithNotEnoughSpException(String message) {
        super(message);
    }
}
