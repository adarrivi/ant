package org.adarrivi.ant.entity.state;

import org.adarrivi.ant.entity.action.Action;
import org.adarrivi.ant.entity.event.Event;

import java.util.Collection;
import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class StateTransition {

    private final State from;
    private final State to;
    private final Collection<Action> actions;
    private final Optional<Event> eventOptional;

    public StateTransition(State from, State to, Collection<Action> actions, Optional<Event> eventOptional) {
        this.from = from;
        this.to = to;
        this.actions = actions;
        this.eventOptional = eventOptional;
    }

    public State getFrom() {
        return from;
    }

    public State getTo() {
        return to;
    }

    public Collection<Action> getActions() {
        return actions;
    }

    public Optional<Event> getEventOptional() {
        return eventOptional;
    }
}
