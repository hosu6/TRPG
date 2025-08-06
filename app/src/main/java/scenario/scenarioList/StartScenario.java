package scenario.scenarioList;

import scenario.Scenario;

public class StartScenario extends Scenario {
    public StartScenario() {
        super();
        name = "플레이 시작";
        description = "";
        runnableScenario = () -> {
            System.out.println("안녕하세요 플레이어님. 플레이를 시작합니다.");
            nextScenario = new EndScenario();
        };
    }
}
