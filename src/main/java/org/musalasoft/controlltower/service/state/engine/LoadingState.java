package org.musalasoft.controlltower.service.state.engine;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.musalasoft.controlltower.domain.excepion.DroneStateEngineException;
import org.musalasoft.controlltower.domain.service.state.engine.State;

@Data
@AllArgsConstructor
public class LoadingState implements State {
    @Override
    public void startLoading(ControlPanel context) {
        throw new DroneStateEngineException("This drone is already being loaded");
    }

    @Override
    public void completeLoading(ControlPanel context) {
        if(context.getDrone().getBatteryCapacity() < 20){
            throw new DroneStateEngineException("Battery capacity is not enough for delivering. current capacity "+ context.getDrone().getBatteryCapacity() +"%");
        }
        context.setState(Factory.DroneState.getState(States.LOADED));
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
        throw new DroneStateEngineException("Method not allow at this state");
    }

    @Override
    public States getStates() {
        return null;
    }
}
