package scenario.scenarioList;

import scenario.Scenario;

public class EndScenario extends Scenario {
    public EndScenario() {
        super();
        name = "플레이 종료";
        description = "";
        runnableScenario = () -> {
            System.out.println("플레이가 종료되었습니다.");
        };
    }
}
