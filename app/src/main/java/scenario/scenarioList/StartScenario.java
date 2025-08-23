package scenario.scenarioList;

import play.Play;
import scenario.Scenario;

public class StartScenario extends Scenario {
    public StartScenario() {
        super("StartScenario", "플레이 시작 시나리오", () -> {
            Play.println("안녕하세요 플레이어님. 플레이를 시작합니다.");
        });
    }
}
