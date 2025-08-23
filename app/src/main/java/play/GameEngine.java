package play;

import scenario.scenarioList.EndScenario;
import scenario.scenarioList.StartScenario;

public class GameEngine {
    public static void run() {
        new StartScenario().run();
        while (!PlayStatus.scenariosOnReady.isEmpty()) {
            PlayStatus.scenarioOnRunning = PlayStatus.scenariosOnReady.pop();
            PlayStatus.scenarioOnRunning.run();
        }
        new EndScenario().run();
    }
}
