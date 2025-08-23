package scenario.scenarioList;

import play.Play;
import play.PlayStatus;
import scenario.Scenario;

public class DeadScenario extends Scenario {
    public DeadScenario() {
        super("DeadScenario", "플레이 사망 시나리오", () -> {
            Play.println("플레이어가 전부 사망하였습니다.");
            PlayStatus.scenariosOnReady.push(new EndScenario());
        });
    }
}
