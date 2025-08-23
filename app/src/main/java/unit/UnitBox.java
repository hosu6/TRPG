package unit;

import play.Play;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

public class UnitBox {
    private final LinkedList<Unit> unitBox;
    private final LinkedList<Unit> controllableUnitBox = new LinkedList<>();

    public UnitBox(LinkedList<Unit> unitBox) {
        this.unitBox = unitBox;
    }

    public UnitBox(Unit... units) {
        this.unitBox = new LinkedList<>();
        unitBox.addAll(Arrays.asList(units));
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

    public int size() {
        return unitBox.size();
    }

    public void updateControllableUnitBox() {
        controllableUnitBox.clear();
        for (Unit unit : unitBox) {
            if (unit.getUnitStatus().getHp() > 0) controllableUnitBox.add(unit);
        }
    }

    public Unit getUnit(int index) {
        return unitBox.get(index);
    }

    public Optional<Unit> getControllableUnit() {
        if (controllableUnitBox.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(controllableUnitBox.pop());
    }

    public Unit getNextAliveUnit() {
        for (Unit unit : unitBox) {
            if (unit.getUnitStatus().getHp() > 0) return unit;
        }
        return null;
    }

    public void attackTarget(Unit target) {
        for (Unit unit : unitBox) {
            if (unit.getUnitStatus().getHp() <= 0) continue;
            unit.getSkillBox().useDamageSkillInOrder(unit, target);
        }
    }

    public void attackTargets(UnitBox targetBox) {
        for (Unit unit : unitBox) {
            if (unit.getUnitStatus().getHp() <= 0) continue;
            Unit target = targetBox.getNextAliveUnit();
            if (target == null) break;
            unit.getSkillBox().useDamageSkillInOrder(unit, target);
        }
    }

    public void printAllUnits() {
        int index = 1;
        for (Unit unit : unitBox) {
            Play.println(index++ + "번 유닛");
            Play.println(unit.unitInfo() + "\n");
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
