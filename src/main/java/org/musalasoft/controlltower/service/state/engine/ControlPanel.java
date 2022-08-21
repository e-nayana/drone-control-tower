package org.musalasoft.controlltower.service.state.engine;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.musalasoft.controlltower.domain.entity.Drone;
import org.musalasoft.controlltower.domain.service.state.engine.State;

@Data
@AllArgsConstructor
public class ControlPanel implements State {
    private Drone drone;
    private State state;

    @Override
    public void startLoading(ControlPanel context) {
        state.startLoading(this);
    }

    @Override
    public void completeLoading(ControlPanel context) {
        state.completeLoading(this);

    }

    @Override
    public void startDelivery(ControlPanel context) {
        state.startDelivery(this);
    }

    @Override
    public void completeDelivery(ControlPanel context) {
        state.completeDelivery(this);
    }

    @Override
    public void returning(ControlPanel context) {
        state.returning(this);
    }

    @Override
    public void finishJourney(ControlPanel context) {
        state.finishJourney(this);
    }

    @Override
    public States getStates() {
        return state.getStates();
    }
}
