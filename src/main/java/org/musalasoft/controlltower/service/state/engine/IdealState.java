package org.musalasoft.controlltower.service.state.engine;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.musalasoft.controlltower.domain.excepion.DroneStateEngineException;
import org.musalasoft.controlltower.domain.service.state.engine.State;

@Data
@AllArgsConstructor
public class IdealState implements State {

    @Override
    public void startLoading(Controller context) {
        if (context.getDrone().getBatterCapacity() < 20) {
            throw new DroneStateEngineException("Battery capacity is not enough for delivering. current capacity " + context.getDrone().getBatterCapacity() + "%");
        }
        if (context.getDrone().getModel().getWeightLimit() < context.getDrone().getMedication().getWeight()) {
            throw new DroneStateEngineException("This drone is not compatible for such a weight. Max weight " + context.getDrone().getModel().getWeightLimit() + "g");
        }
        context.setState(Factory.DroneState.getState(States.LOADING));
        //save in db by persistant provider
    }

    @Override
    public void completeLoading(Controller context) {
        throw new DroneStateEngineException("This drone is not in loading state. please start loading before complete");
    }

    @Override
    public States getStates() {
        return States.IDLE;
    }
}
