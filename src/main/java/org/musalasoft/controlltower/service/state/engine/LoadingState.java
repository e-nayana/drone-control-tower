package org.musalasoft.controlltower.service.state.engine;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.musalasoft.controlltower.domain.excepion.DroneStateEngineException;
import org.musalasoft.controlltower.domain.service.state.engine.State;

@Data
@AllArgsConstructor
public class LoadingState implements State {
    @Override
    public void startLoading(Controller context) {
        throw new DroneStateEngineException("This drone is already being loaded");
    }

    @Override
    public void completeLoading(Controller context) {
        if(context.getDrone().getBatterCapacity() < 20){
            throw new DroneStateEngineException("Battery capacity is not enough for delivering. current capacity "+ context.getDrone().getBatterCapacity() +"%");
        }
        context.setState(Factory.DroneState.getState(States.LOADED));
    }

    @Override
    public States getStates() {
        return null;
    }
}
