package play;

import play.enums.Actions;

import java.util.HashSet;
import java.util.List;

public class ActionGroup {
    private final HashSet<Actions> actions;

    public ActionGroup(Actions... actions) {
        this.actions = new HashSet<>(List.of(actions));
    }

    public boolean contains(Actions action) {
        return actions.contains(action);
    }

    public Actions getAction(String key) {
        Actions action = Actions.getAction(key);
        if (actions.contains(action)) return action;
        return Actions.INVALID;
    }

    @Override
    public String toString() {
        return actions.toString();
    }
}
