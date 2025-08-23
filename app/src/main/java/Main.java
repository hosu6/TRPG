import play.GameEngine;
import play.PlayStatus;
import scenario.scenarioList.BattleScenario;
import unit.MonsterFactory;
import unit.UnitBox;

public class Main {
    public static void main(String[] args) {
        UnitBox players = new UnitBox(MonsterFactory.goblin(10), MonsterFactory.goblin(10));
        UnitBox monsters = new UnitBox(MonsterFactory.goblin(4));
        PlayStatus.scenariosOnReady.push(new BattleScenario(players, monsters));
        GameEngine.run();
    }
}
