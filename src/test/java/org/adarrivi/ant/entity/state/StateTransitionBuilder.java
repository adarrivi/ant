package org.adarrivi.ant.entity.state;

import org.adarrivi.ant.Builder;
import org.adarrivi.ant.entity.action.Action;
import org.adarrivi.ant.entity.event.Event;

public interface StateTransitionBuilder extends Builder<StateTransition> {

    StateTransitionBuilder from(State state);

    StateTransitionBuilder to(State state);

    StateTransitionBuilder withAction(Action action);

    StateTransitionBuilder forEvent(Event event);
}
