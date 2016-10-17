package org.adarrivi.ant.entity.state;

import java.util.Collection;

public class StateChart {

    private final Collection<StateTransition> transitions;

    public StateChart(Collection<StateTransition> transitions) {
        this.transitions = transitions;
    }

}
