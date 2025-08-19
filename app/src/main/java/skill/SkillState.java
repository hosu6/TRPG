package skill;

import exception.common.QuantityUnderZeroException;
import lombok.Data;

@Data
public class SkillState {
    private int leftCooldownTime = 0;
    private int level = 1;

    public SkillState(int leftCooldownTime, int level) {
        this.leftCooldownTime = leftCooldownTime;
        this.level = level;
    }

    public SkillState copy() {
        return new SkillState(leftCooldownTime, level);
    }

    public void addLevel(int quantity) {
        if (quantity <= 0) throw new QuantityUnderZeroException("레벨 증가 수치는 1 이상이어야 합니다.");
        this.level += quantity;
    }
}
