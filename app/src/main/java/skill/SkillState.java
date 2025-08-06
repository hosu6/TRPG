package skill;

public class SkillState {
    private int leftCooldownTime = 0;
    private int level = 1;

    public SkillState(int leftCooldownTime, int level) {
        this.leftCooldownTime = leftCooldownTime;
        this.level = level;
    }

    public SkillState clone() {
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

    public void addLevel(int level) {
        if (level <= 0) throw new IllegalArgumentException("레벨 증가 수치는 1 이상이어야 합니다.");
        this.level += level;
    }
}
