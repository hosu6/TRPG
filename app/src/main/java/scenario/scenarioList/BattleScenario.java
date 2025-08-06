package scenario.scenarioList;

import scenario.Scenario;
import unit.UnitBox;

public class BattleScenario extends Scenario {
    public BattleScenario(UnitBox monsters, UnitBox players, Scenario nextScenario) {
        super();
        name = "전투 시나리오";
        runnableScenario = () -> {
            System.out.println("다음 적대 유닛과 전투를 시작합니다.");
            monsters.toString();
            while (!monsters.isAllDead() && !players.isAllDead()) {
                System.out.println("플레이어의 턴입니다.");
                players.attackTargets(monsters);
                System.out.println("적대 유닛의 턴입니다.");
                monsters.attackTargets(players);
            }
            System.out.println("전투가 종료되었습니다.");
            if (players.isAllDead()) {
                this.nextScenario = new DeadScenario();
            }
            if (monsters.isAllDead()) {
                this.nextScenario = nextScenario;
            }
        };
    }
}
