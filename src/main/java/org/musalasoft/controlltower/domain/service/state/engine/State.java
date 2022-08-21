package org.musalasoft.controlltower.domain.service.state.engine;

import org.musalasoft.controlltower.service.state.engine.ControlPanel;

public interface State {
     enum States {
         IDLE("IDLE"),
         LOADING("LOADING"),
         LOADED("LOADED"),
         DELIVERING("DELIVERING"),
         DELIVERED("DELIVERED"),
         RETURNING("RETURNING"),
         DRAINED("DRAINED"),
         DOCKED("DOCKED");
        public String val;
        States(String val){
            this.val = val;
        }
    }

    void startLoading(ControlPanel context);

    void completeLoading(ControlPanel context);

    void startDelivery(ControlPanel context);

    void completeDelivery(ControlPanel context);

    void returning(ControlPanel context);

    void finishJourney(ControlPanel context);

    State.States getStates();
}
