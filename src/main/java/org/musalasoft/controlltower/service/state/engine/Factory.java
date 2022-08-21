package org.musalasoft.controlltower.service.state.engine;

import org.musalasoft.controlltower.domain.entity.Drone;
import org.musalasoft.controlltower.domain.service.state.engine.State;

public class Factory {

    public static class DroneState {
        public static State getState(State.States state) {
            switch (state) {
                case IDLE:
                    return new IdealState();
                case LOADING:
                    return new LoadingState();
                default:
                    return null;
            }

        }
    }

    public static class DroneController {
        public static Controller getController(Drone drone) {
            return new Controller(drone, DroneState.getState(drone.getState()));
        }
    }


}
