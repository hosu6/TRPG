package scenario.scenarioList;

import play.Play;
import scenario.Scenario;

public class EndScenario extends Scenario {
    public EndScenario() {
        super("EndScenario", "플레이 종료 시나리오", () -> {
            Play.println("플레이가 종료되었습니다.");
        });
    }
}
