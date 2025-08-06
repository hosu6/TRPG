package unit;

import java.util.LinkedList;

public class UnitBox {
    private final LinkedList<Unit> unitBox;

    public UnitBox(LinkedList<Unit> unitBox) {
        this.unitBox = unitBox;
    }

    public void addUnit(Unit unit) {
        unitBox.add(unit);
    }

    public void addUnitFirst(Unit unit) {
        unitBox.addFirst(unit);
    }

    public void addUnitLast(Unit unit) {
        unitBox.addLast(unit);
    }

    public void removeUnit(Unit unit) {
        unitBox.remove(unit);
    }

    public boolean isAllDead() {
        for (Unit unit : unitBox) {
            if (unit.getUnitStatus().getHp() > 0) return false;
        }
        return true;
    }

    public Unit getNextAliveUnit() {
        for (Unit unit : unitBox) {
            if (unit.getUnitStatus().getHp() > 0) return unit;
        }
        return null;
    }

    public void attackTarget(Unit target) {
        try {
            for (Unit unit : unitBox) {
                unit.getSkillBox().useDamageSkillInOrder(unit, target);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void attackTargets(UnitBox targetBox) {
        try {
            for (Unit unit : unitBox) {
                Unit target = targetBox.getNextAliveUnit();
                if (target == null) break;
                unit.getSkillBox().useDamageSkillInOrder(unit, target);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Unit unit : unitBox) {
            result.append(unit.getName()).append(" ");
        }
        return result.toString();
    }
}
