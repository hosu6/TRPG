package scenario.scenarioList;

import scenario.Scenario;

public class DeadScenario extends Scenario {
    public DeadScenario() {
        super();
        name = "사망 종료";
        description = "";
        runnableScenario = () -> {
            System.out.println("플레이어가 사망하였습니다.");
            nextScenario = new EndScenario();
        };
    }
}
