package org.musalasoft.controlltower.service.state.engine;

import org.musalasoft.controlltower.domain.entity.Drone;
import org.musalasoft.controlltower.domain.service.state.engine.State;

public class Factory {

    public static class DroneState {
        public static State getState(State.States state) {
            if(state == null) return new IdealState();
            switch (state) {
                case LOADING:
                    return new LoadingState();
                case LOADED:
                    return new LoadedState();
                case DELIVERING:
                    return new DeliveringState();
                case DELIVERED:
                    return new DeliveredState();
                case RETURNING:
                    return new ReturningState();
                default:
                    return new IdealState();
            }

        }
    }

    public static class DroneController {
        public static ControlPanel getController(Drone drone) {
            return new ControlPanel(drone, DroneState.getState(drone.getState()));
        }
    }


}
