package org.musalasoft.controlltower.domain.service.state.engine;

import org.musalasoft.controlltower.service.state.engine.Controller;

public interface State {
     enum States {
        IDLE,LOADING,LOADED,DELIVERING,DELIVERED,RETURNING,DRAINED,DOCKED
    }
    void startLoading(Controller context);
    void completeLoading(Controller context);
    State.States getStates();
}
