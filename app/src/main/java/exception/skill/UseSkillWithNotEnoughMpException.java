package exception.skill;

import exception.abstracts.PrintException;

public class UseSkillWithNotEnoughMpException extends PrintException {
    public UseSkillWithNotEnoughMpException(String message) {
        super(message);
    }
}
