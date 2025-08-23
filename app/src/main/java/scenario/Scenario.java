package scenario;

import lombok.Getter;

@Getter
public class Scenario {
    protected String name;
    protected String description;
    protected Runnable runnableScenario;

    public Scenario(String name, String description, Runnable runnableScenario) {
        this.name = name;
        this.description = description;
        this.runnableScenario = runnableScenario;
    }

    public void run() {
        runnableScenario.run();
    }
}
