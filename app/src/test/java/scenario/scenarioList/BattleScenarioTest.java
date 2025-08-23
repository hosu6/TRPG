package scenario.scenarioList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import play.GameEngine;
import play.Play;
import play.PlayStatus;
import unit.MonsterFactory;
import unit.UnitBox;

import java.io.ByteArrayInputStream;

class BattleScenarioTest {

    @AfterEach
    void setUp() {
        GameEngine.run();
    }

    @Test
    void run() {
        String input = "attack\nattack\nattack\nattack\nattack\nattack\nattack\nattack\nattack\nattack\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn); // System.in을 테스트용 스트림으로 변경합니다.
        // PlayerAction.scanner가 새롭게 변경된 System.in을 사용하도록 재생성합니다.
        Play.scanner = new java.util.Scanner(System.in);


        UnitBox players = new UnitBox(MonsterFactory.goblin(10), MonsterFactory.goblin(10));
        UnitBox monsters = new UnitBox(MonsterFactory.goblin(4));
        PlayStatus.scenariosOnReady.push(new BattleScenario(monsters, players));
    }
}