package play;

import scenario.Scenario;
import scenario.scenarioList.StartScenario;
import unit.Unit;
import unit.UnitBox;

import java.util.LinkedList;
import java.util.Stack;

public class PlayStatus {
    public static Unit controllingUnit;
    public static UnitBox controllingUnitBox;
    public final static LinkedList<Unit> ownedUnits = new LinkedList<>();
    public final static Stack<Scenario> scenariosOnReady = new Stack<>();
    public final static Stack<Scenario> scenariosOnFinished = new Stack<>();
    public static Scenario scenarioOnRunning = new StartScenario();
}
