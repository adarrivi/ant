package org.adarrivi.ant.entity.state.impl;

import org.adarrivi.ant.entity.action.Action;
import org.adarrivi.ant.entity.event.Event;
import org.adarrivi.ant.entity.state.State;
import org.adarrivi.ant.entity.state.StateTransition;
import org.adarrivi.ant.entity.state.StateTransitionBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
class StateTransitionBuilderImpl implements StateTransitionBuilder {

    private State from;
    private State to;
    private Collection<Action> actions = new ArrayList<>();
    private Optional<Event> eventOptional = Optional.empty();

    @Override
    public StateTransitionBuilder from(State state) {
        this.from = state;
        return this;
    }

    @Override
    public StateTransitionBuilder to(State state) {
        this.to = state;
        return this;
    }

    @Override
    public StateTransitionBuilder withAction(Action action) {
        this.actions.add(action);
        return this;
    }

    @Override
    public StateTransitionBuilder forEvent(Event event) {
        this.eventOptional = Optional.of(event);
        return this;
    }

    @Override
    public StateTransition build() {
        return new StateTransition(from, to, actions, eventOptional);
    }
}
