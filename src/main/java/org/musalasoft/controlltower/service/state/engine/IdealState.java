package org.musalasoft.controlltower.service.state.engine;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.musalasoft.controlltower.domain.excepion.DroneStateEngineException;
import org.musalasoft.controlltower.domain.service.state.engine.State;

@Data
@AllArgsConstructor
public class IdealState implements State {

    @Override
    public void startLoading(ControlPanel context) {
        if (context.getDrone().getBatteryCapacity() < 20) {
            throw new DroneStateEngineException("Battery capacity is not enough for delivering. current capacity " + context.getDrone().getBatteryCapacity() + "%");
        }
        if (context.getDrone().getModel().getWeightLimit() < context.getDrone().getMedication().getWeight()) {
            throw new DroneStateEngineException("This drone is not compatible for such a weight. Max weight " + context.getDrone().getModel().getWeightLimit() + "g");
        }
        context.setState(Factory.DroneState.getState(States.LOADING));
        context.getDrone().setState(States.LOADING);
        //save in db by persistant provider
    }

    @Override
    public void completeLoading(ControlPanel context) {
        throw new DroneStateEngineException("This drone is not in loading state. please start loading before complete");
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
        return States.IDLE;
    }
}
