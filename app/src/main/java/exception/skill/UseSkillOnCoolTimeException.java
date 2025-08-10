package exception.skill;

import exception.abstracts.PrintException;

public class UseSkillOnCoolTimeException extends PrintException {
    public UseSkillOnCoolTimeException(String message) {
        super(message);
    }
}
