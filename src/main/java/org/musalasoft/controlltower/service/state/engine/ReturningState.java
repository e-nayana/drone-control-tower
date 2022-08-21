package org.musalasoft.controlltower.service.state.engine;

import org.musalasoft.controlltower.domain.excepion.DroneStateEngineException;
import org.musalasoft.controlltower.domain.service.state.engine.State;

public class ReturningState implements State {

    @Override
    public void startLoading(ControlPanel context) {
        throw new DroneStateEngineException("Method not allow at this state");
    }

    @Override
    public void completeLoading(ControlPanel context) {
        throw new DroneStateEngineException("Method not allow at this state");
    }

    @Override
    public void startDelivery(ControlPanel context) {
        throw new DroneStateEngineException("Method not allow at this state");
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
        if(context.getDrone().getBatteryCapacity() > 25){
            context.setState(Factory.DroneState.getState(States.IDLE));
        }else {
            context.setState(Factory.DroneState.getState(States.DRAINED));
        }
    }

    @Override
    public States getStates() {
        return null;
    }
}
