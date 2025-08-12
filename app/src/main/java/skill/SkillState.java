package skill;

import exception.common.QuantityUnderZeroException;

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

    public int getLeftCooldownTime() {
        return leftCooldownTime;
    }

    public void setLeftCooldownTime(int leftCooldownTime) {
        this.leftCooldownTime = leftCooldownTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addLevel(int quantity) {
        if (quantity <= 0) throw new QuantityUnderZeroException("레벨 증가 수치는 1 이상이어야 합니다.");
        this.level += quantity;
    }
}
