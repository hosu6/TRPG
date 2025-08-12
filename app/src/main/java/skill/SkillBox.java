package skill;

import exception.common.NotEnoughQuantityException;
import exception.common.QuantityUnderZeroException;
import exception.skill.AccessNotExistSkillException;
import exception.skill.UseSkillOnCoolTimeException;
import exception.skill.UseSkillWithNotEnoughMpException;
import exception.skill.UseSkillWithNotEnoughSpException;
import skill.enums.SkillTypes;
import skill.enums.Skills;
import status.BaseStatus;
import status.UnitStatus;
import unit.Unit;

import java.util.HashMap;
import java.util.HashSet;

public class SkillBox {

    private final HashMap<Skills, SkillState> skillBox;
    private final HashSet<Skills> onCooldownSkills = new HashSet<>();
    private int skillPoint = 0; //skill 레벨을 올릴 수 있는 포인트. 레벨업 시 3 획득

    public SkillBox(HashMap<Skills, SkillState> skillBox) {
        this.skillBox = skillBox;
    }

    public SkillBox copy() {
        HashMap<Skills, SkillState> clonedSkillBox = new HashMap<>();
        for (HashMap.Entry<Skills, SkillState> entry : skillBox.entrySet()) {
            clonedSkillBox.put(entry.getKey(), entry.getValue().copy());
        }
        return new SkillBox(clonedSkillBox);
    }

    public void gainLevelUpSkillPoint() {
        skillPoint += 3;
    }

    public void levelUpSkill(Skills skill, int quantity) {
        if (quantity <= 0) throw new QuantityUnderZeroException("소모하려는 스킬포인트는 1 이상이어야 합니다.");
        if (quantity > skillPoint) throw new NotEnoughQuantityException("소모하려는 스킬포인트가 잔여 스킬포인트보다 많습니다.");
        skillBox.get(skill).addLevel(quantity);
        skillPoint -= quantity;
    }

    private int calculateDamage(Skills skill, Unit caster, Unit target) {
        SkillState skillState = skillBox.get(skill);
        int damage = skill.getDamagePerLevel().getOrDefault(skillState.getLevel(), 0);
        BaseStatus casterEffectiveBaseStatus = caster.getUnitStatus().getEffectiveBaseStatus();
        BaseStatus targetEffectiveBaseStatus = target.getUnitStatus().getEffectiveBaseStatus();
        switch (skill.getAttribute()) {
            case PHYSICAL:
                damage += casterEffectiveBaseStatus.getAtk() + casterEffectiveBaseStatus.getStr() - targetEffectiveBaseStatus.getVit() - targetEffectiveBaseStatus.getDef();
                break;
            case MAGIC:
                damage += casterEffectiveBaseStatus.getAtk() + casterEffectiveBaseStatus.getWis() - targetEffectiveBaseStatus.getArc() - targetEffectiveBaseStatus.getDef();
        }
        return damage;
    }

    private int calculateHeal(Skills skill, Unit caster, Unit target) {
        SkillState skillState = skillBox.get(skill);
        int heal = skill.getHealPerLevel().getOrDefault(skillState.getLevel(), 0);
        BaseStatus casterEffectiveBaseStatus = caster.getUnitStatus().getEffectiveBaseStatus();
        BaseStatus targetEffectiveBaseStatus = target.getUnitStatus().getEffectiveBaseStatus();
        heal += casterEffectiveBaseStatus.getWis() + targetEffectiveBaseStatus.getArc();
        return heal;
    }

    public void useDamageSkillInOrder(Unit caster, Unit target) {
        for (Skills skill : skillBox.keySet()) {
            if (skill.getType() == SkillTypes.DAMAGE && !onCooldownSkills.contains(skill)) {
                useSkill(skill, caster, target);
                return;
            }
        }
        throw new AccessNotExistSkillException(caster.getName() + "은 현재 실행할 수 있는 스킬이 존재하지 않는다");
    }

    public void useSkill(Skills skill, Unit caster, Unit target) {
        if (onCooldownSkills.contains(skill)) throw new UseSkillOnCoolTimeException("아직 쿨다운 중인 스킬이라 사용이 불가능합니다.");
        SkillState skillState = skillBox.get(skill);
        UnitStatus casterUnitStatus = caster.getUnitStatus();
        UnitStatus targetUnitStatus = target.getUnitStatus();
        int cost = skill.getCostPerLevel().getOrDefault(skillState.getLevel(), 0);
        switch (skill.getAttribute()) {
            case PHYSICAL:
                if (casterUnitStatus.getSp() < cost) throw new UseSkillWithNotEnoughSpException("스킬을 시전하기에 SP가 모자랍니다.");
                casterUnitStatus.changeSp(-1 * cost);
                break;
            case MAGIC:
                if (casterUnitStatus.getMp() < cost) throw new UseSkillWithNotEnoughMpException("스킬을 시전하기에 MP가 모자랍니다.");
                casterUnitStatus.changeMp(-1 * cost);
                break;
        }

        switch (skill.getType()) {
            case DAMAGE:
                int damage = calculateDamage(skill, caster, target);
                targetUnitStatus.changeHp(-1 * damage);
                break;
            case HEAL:
                int heal = calculateHeal(skill, caster, target);
                targetUnitStatus.changeMp(heal);
                break;
            case BUFF:
                break;
            case DEBUFF:
                break;
        }
        int cooldown = skill.getCooldownPerLevel().getOrDefault(skillState.getLevel(), 0);
        if (cooldown > 0) {
            skillState.setLeftCooldownTime(cooldown);
            onCooldownSkills.add(skill);
        }
    }
}
