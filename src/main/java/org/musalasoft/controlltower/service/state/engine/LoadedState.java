package org.musalasoft.controlltower.service.state.engine;

import org.musalasoft.controlltower.domain.excepion.DroneStateEngineException;
import org.musalasoft.controlltower.domain.service.state.engine.State;

public class LoadedState implements State {
    @Override
    public void startLoading(ControlPanel context) {
        throw new DroneStateEngineException("This drone is already loaded");
    }

    @Override
    public void completeLoading(ControlPanel context) {
        throw new DroneStateEngineException("This drone is ready to deliver");
    }

    @Override
    public void startDelivery(ControlPanel context) {
        context.setState(Factory.DroneState.getState(States.DELIVERING));
    }

    @Override
    public void completeDelivery(ControlPanel context) {
        throw new DroneStateEngineException("Method not allow at this state");
    }

    @Override
    public void returning(ControlPanel context) {
        throw new DroneStateEngineException("Method not allow at this state");
    }

    @Override
    public void finishJourney(ControlPanel context) {
        throw new DroneStateEngineException("Method not allow at this state");
    }

    @Override
    public States getStates() {
        return States.LOADED;
    }
}
