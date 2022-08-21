package org.musalasoft.controlltower.service.state.engine;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.musalasoft.controlltower.domain.entity.Drone;
import org.musalasoft.controlltower.domain.service.state.engine.State;

@Data
@AllArgsConstructor
public class Controller implements State {
    private Drone drone;
    private State state;

    @Override
    public void startLoading(Controller context) {
        state.startLoading(this);
    }

    @Override
    public void completeLoading(Controller context) {
        state.completeLoading(this);

    }

    @Override
    public States getStates() {
        return state.getStates();
    }
}
