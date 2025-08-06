package scenario;

public class Scenario {
    protected Scenario nextScenario;
    protected String name;
    protected String description;
    protected Runnable runnableScenario;

    public Scenario() {
        this(null, "", "", null);
    }

    public Scenario(Scenario nextScenario, String name, String description, Runnable runnableScenario) {
        this.nextScenario = nextScenario;
        this.name = name;
        this.description = description;
        this.runnableScenario = runnableScenario;
    }

    public Scenario executeAndGetNextScenario() {
        runnableScenario.run();
        return nextScenario;
    }
}
